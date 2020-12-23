package com.example.demo.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;
import com.example.demo.service.ChildService;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public List<Child> getAllChild() {

        return childRepository.findAll();
    }

    @Override
    public String addAChild(Child child) {

        addParentToParentCollection(child);
        /*
		 * CHECKING IF THE CHILD ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN
		 */
        boolean isChildExist = false;
        List<Child> childList = childRepository.findAll();
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).getCivilId().equals(child.getCivilId())) {
                isChildExist = true;
            }
        }
        if (!isChildExist) {
			/*
			 * CHILD DOES NOT EXIST ALREADY, SYSTEM IS GOING TO ADD IT TO PARENT COLLECTION
			 */
            childRepository.save(child);

            return "CHILD IS ADDED SUCCESSFULLY";
        } else {
            return "CHILD ALREADY EXISTS";
        }
    }

    private void addParentToParentCollection(Child child) {
		/*
		 * IF THE PARENT ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN
		 */
        boolean isParentExist = false;
        List<Parent> parentList = parentRepository.findAll();
        for (int i = 0; i < parentList.size(); i++) {
            if (parentList.get(i).getCivilId().equals(child.getParent().getCivilId())) {
                isParentExist = true;
                break;
            }
        }
        if (!isParentExist) {
			/*
			 * PARENT DOES NOT EXIST ALREADY, SYSTEM IS GOING TO ADD IT TO PARENT COLLECTION
			 */
            parentRepository.save(child.getParent());
        }

    }

    @Override
    public String removeAChild(String civilId) {

        boolean isChildExist = false;
        List<Child> childList = childRepository.findAll();
        for (int i = 0; i < childList.size(); i++) {
            if (childList.get(i).getCivilId().equals(civilId)) {
                isChildExist = true;
                break;
            }
        }
        if (isChildExist) {
			/*
			 * CHILD EXISTS ALREADY, SYSTEM IS GOING TO DELETE IT
			 */
            childRepository.deleteById(civilId);
            return "CHILD ID : "+civilId+" REMOVED SUCCESSFULLY";
        }
        else {
            return "CHILD ID : "+civilId+" IS INVALID";
        }
    }

}
