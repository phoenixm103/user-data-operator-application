package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Parent;

public interface ParentService {

	public List<Parent> getAllParent();

	public String addAParent(Parent parent);

    public String removeAParent(String id);

    public String updateAParent(Parent parent,String civilId);
}

