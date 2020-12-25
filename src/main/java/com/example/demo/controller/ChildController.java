package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Child;
import com.example.demo.service.ChildService;

@RestController
@RequestMapping("/child")
public class ChildController {

	@Autowired
	private ChildService childService;
	
	public ChildController() {
		super();
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
	@PutMapping("/{civilId}")
	public String updateAChild(@RequestBody Child child,@PathVariable String civilId) {
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
				return childService.updateAChild(child,civilId);
			}
		} catch (NullPointerException e) {
			return "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		}

	}
}
