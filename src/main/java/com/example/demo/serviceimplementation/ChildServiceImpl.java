package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.Optional;

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


    public ChildServiceImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ChildServiceImpl(ChildRepository childRepository, ParentRepository parentRepository) {
        super();
        this.childRepository = childRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public List<Child> getAllChild() {

        return childRepository.findAll();
    }

    @Override
    public String addAChild(Child child) {
        /* CHECKING IF THE CHILD ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN */
        Optional<Child> newChild = childRepository.findById(child.getCivilId());
        if (!newChild.isPresent()) {
            childRepository.save(child);
            addParentToParentCollection(child);
            return "CHILD IS ADDED SUCCESSFULLY";
        } else {
            return "CHILD ALREADY EXISTS";
        }
    }

    public boolean addParentToParentCollection(Child child) {
		/* IF THE PARENT ALREADY EXISTS, SYSTEM IS NOT GOING TO ADD IT AGAIN */
        Optional<Parent> newParent = parentRepository.findById(child.getParent().getCivilId());
        if (!newParent.isPresent()) {
            parentRepository.save(child.getParent());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String removeAChild(String civilId) {
		/* IF THE CIVILID IS VALID THEN SYSTEM WILL DELETE IT, OTHERWISE NOT */
        Optional<Child> newChild = childRepository.findById(civilId);
        if (!newChild.isPresent()) {
            return "CHILD ID : " + civilId + " IS INVALID";
        } else {
            childRepository.deleteById(civilId);
            return "CHILD ID : " + civilId + " REMOVED SUCCESSFULLY";
        }
    }

    @Override
    public String updateAChild(Child child, String civilId) {
		/* CHECKING IF THE CHILD EXISTS,IF NOT SYSTEM IS NOT GOING TO UPDATE IT */
        Optional<Child> newChild = childRepository.findById(civilId);
        if (!newChild.isPresent()) {
            return  "NO CHILD FOUND WITH CIVIL ID : "+ civilId ;
        } else {

            if(child.getCivilId()!=civilId){
                childRepository.deleteById(civilId);
            }
            childRepository.save(child);
            addParentToParentCollection(child);

            return "CHILD WITH CIVIL_ID : "+civilId+" IS UPDATED SUCCESSFULLY";
        }
    }

}
