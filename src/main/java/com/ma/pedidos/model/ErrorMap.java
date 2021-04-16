package com.ma.pedidos.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class ErrorMap implements MultiValueMap {

	private Map<String,String> errors = new HashMap<String,String>();

	public ErrorMap() {
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return errors.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return errors.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return errors.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return errors.containsValue(value);
	}

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		return errors.get(key);
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		return errors.put((String)key, (String)value);
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		return errors.remove(key);
	}

	@Override
	public void putAll(Map m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection values() {
		// TODO Auto-generated method stub
		return errors.values();
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFirst(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(Object key, List values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(MultiValueMap values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAll(Map values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map toSingleValueMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
