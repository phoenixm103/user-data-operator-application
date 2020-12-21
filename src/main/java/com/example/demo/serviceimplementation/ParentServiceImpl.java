package com.example.demo.serviceimplementation;

import java.util.List;

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
		/*
		 * CHECKING IF THE PARENT ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN
		 */
		boolean isParentExist = false;
		List<Parent> parentList = parentRepository.findAll();
		for (int i = 0; i < parentList.size(); i++) {
			if (parentList.get(i).getCivilId().equals(parent.getCivilId())) {
				isParentExist = true;
			}
		}
		if (isParentExist == false) {
			/*
			 * PARENT DOES NOT EXIST ALREADY, SYSTEM IS GOING TO ADD IT TO PARENT COLLECTION
			 */
			parentRepository.save(parent);

			return "PARENT IS ADDED SUCCESSFULLY";
		} else {
			return "PARENT ALREADY EXISTS";
		}
	}
}
