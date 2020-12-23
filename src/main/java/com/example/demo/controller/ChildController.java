package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
@RequestMapping("/child")
public class ChildController {

	@Autowired
	private ChildService childService;
	
	
	
	public ChildController() {
		super();
		//this.childService = childService;
	}

	@GetMapping
	public List<Child> getAllChild() {
		return childService.getAllChild();
	}

	@PostMapping
	public String addAChild(@RequestBody Child child) {
		try {
			//INPUT VALIDATION
			if (child.getCivilId().isEmpty()) {
				return null;
			} else if (child.getFirstname().isEmpty()) {
				return null;
			} else if (child.getLastname().isEmpty()) {
				return null;
			} else if (child.getParent().getCivilId().isEmpty()) {
				return null;
			} else if (child.getParent().getFirstname().isEmpty()) {
				return null;
			} else if (child.getParent().getLastname().isEmpty()) {
				return null;
			} else if (child.getParent().getAddress().getCity().isEmpty()) {
				return null;
			} else if (child.getParent().getAddress().getState().isEmpty()) {
				return null;
			} else if (child.getParent().getAddress().getStreet().isEmpty()) {
				return null;
			} else if (child.getParent().getAddress().getZip().isEmpty()) {
				return null;
			} else {
				//INPUT IS VALID
				return childService.addAChild(child);
			}
		} catch (NullPointerException e) {
			return "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		} 

	}
	
	@DeleteMapping("/{civilId}")
	public String removeAChild(@PathVariable String civilId) {

		try {
			//INPUT VALIDATION
			if (civilId.isEmpty()) {
				return null;
			} else {
				return childService.removeAChild(civilId);
			}
		} catch (NullPointerException e) {
			return "INVALID INPUT : NO GIVEN CIVIL-ID OR NULL ID";
		}

	}

}
