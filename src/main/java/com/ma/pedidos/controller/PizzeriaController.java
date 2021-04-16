package com.ma.pedidos.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ma.exceptions.ErrorException;
import com.ma.interfaces.PedidoValidation;
import com.ma.pedidos.model.Pedido;
import com.ma.pedidos.model.PedidoDetalle;
import com.ma.pedidos.model.Producto;
import com.ma.repository.PedidoDetalleRepository;
import com.ma.repository.PedidoRepository;
import com.ma.repository.ProductoRepository;
import com.ma.validators.CantidadValidator;
import com.ma.validators.DireccionValidator;


@RestController
public class PizzeriaController {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoDetalleRepository pedidoDetalleRepository;
	
	
	@RequestMapping("/productos")
	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto getProductos(@PathVariable("id") String id) {
		return productoRepository.findById(id).orElse(new Producto());
	}
	
	@PostMapping("/productos")
	public Producto addProducto(@RequestBody Producto producto) {
		productoRepository.save(producto);
		return producto;
	}
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable("id") String id) {
		try {
			Producto p2 = productoRepository.getOne(id);
			productoRepository.delete(p2);
		 
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new ErrorException("Error");
		}
	}
	
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> updateProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
		try {
			Producto p = productoRepository.getOne(id);
			p.setNombre(producto.getNombre());
			p.setDescripcionCorta(producto.getDescripcionCorta());
			p.setDescripcionLarga(producto.getDescripcionLarga());
			p.setPrecioUnitario(producto.getPrecioUnitario());
			productoRepository.save(p);
			
			return new ResponseEntity<Producto>(HttpStatus.OK);
			
		} catch (Exception e) {
			throw new ErrorException("Error");
		}
	}
	
	@RequestMapping("/pedidos")
	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}
	
	@GetMapping("/pedidos/{fecha}")
	public List<Pedido> getPedidosPorFecha(@PathVariable("fecha") LocalDate fecha) {
		return pedidoRepository.findByFechaAlta(fecha);
	}
	
	
	@GetMapping("/pedidos/{id}")
	public Pedido getPedidos(@PathVariable("id") long id) {
		return pedidoRepository.findById(id).orElse(new Pedido());
	}
	
	@Transactional
	@PostMapping("/pedidos")
	public synchronized ResponseEntity<String> addPedido(@RequestBody Pedido pedido) {
		
				
		final List<PedidoValidation> conditions = new ArrayList<>();
		conditions.add(new DireccionValidator());
		conditions.add(new CantidadValidator());
		
		final List<String> errors = new ArrayList<>();
		
		if (pedido.getDetalle() == null) {
	        pedido.setDetalle(new HashSet<PedidoDetalle>(0));
	    }
	    
	    try {
	        //entityManager.getTransaction().begin();
	        System.out.println("addPedido called");
	        
	        validarPedido(pedido,conditions,errors);
	        
	        if(errors.size()>0) {
	        	return new ResponseEntity<String>(errors.toString(),HttpStatus.BAD_REQUEST);
	        }
	        
			if(pedido.getDetalle()!=null && pedido.getDetalle().size()>3) {
				pedido.setAplicoDescuento(true);
				pedido.setMontoTotal(0.7*pedido.getMontoTotal());
			}
	        entityManager.persist(pedido);
	        
	        
	        
	        for (PedidoDetalle pedidoDetalle : pedido.getDetalle()) {
	            pedidoDetalle.setPedido(pedido);
	            entityManager.merge(pedidoDetalle);
	        }
	        
	
	        
	        return new ResponseEntity<String>(pedido.toString(),HttpStatus.CREATED);
	        //entityManager.getTransaction().commit();
	    } catch (Exception e) {
	    	//return new ResponseEntity<Pedido>(pedido,errores,HttpStatus.BAD_REQUEST);
	    	return new ResponseEntity<String>(errors.toString(),HttpStatus.BAD_REQUEST);
		} finally {
	        if (entityManager != null) {
	            entityManager.close();
	        }
	    }
		
	}
	
	
	private void validarPedido(Pedido pedido, List<PedidoValidation> conditions, List<String> errors) {
		for (final PedidoValidation condition : conditions) {
		    final Optional<String> error = condition.validate(pedido);
		    if (error.isPresent()) {
		        errors.add(error.get());
		    }
		}
	}
	
	
	
}
