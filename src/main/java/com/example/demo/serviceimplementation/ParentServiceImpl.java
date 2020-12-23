package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Parent;
import com.example.demo.repository.ParentRepository;
import com.example.demo.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	private ParentRepository parentRepository;

	@Override
	public List<Parent> getAllParent() {
		return parentRepository.findAll();
	}

	@Override
	public String addAParent(Parent parent) {
		/* CHECKING IF THE PARENT ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN */
		Optional<Parent> newParent = parentRepository.findById(parent.getCivilId());
		if (newParent.isEmpty()) {
			parentRepository.save(parent);
			return "PARENT IS ADDED SUCCESSFULLY";
		} else {
			return "PARENT ALREADY EXISTS";
		}

	}

	@Override
	public String removeAParent(String civilId) {
		/* IF THE CIVILID IS VALID THEN SYSTEM WILL DELETE IT, OTHERWISE NOT */
		Optional<Parent> newParent = parentRepository.findById(civilId);
		if (newParent.isEmpty()) {
			return "PARENT ID : " + civilId + " IS INVALID";
		} else {
			parentRepository.deleteById(civilId);
			return "PARENT ID : " + civilId + " REMOVED SUCCESSFULLY";
		}
	}
}
