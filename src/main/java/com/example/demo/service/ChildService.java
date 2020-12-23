package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Child;

public interface ChildService {

	public List<Child> getAllChild();
	
	public String addAChild(Child child);

	public String removeAChild(String id);

}
