package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Parent;
import com.example.demo.service.ParentService;

@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired
    private ParentService parentService;

    @GetMapping
    public List<Parent> getAllParent() {
        return parentService.getAllParent();
    }

    @PostMapping
    public String addAParent(@RequestBody Parent parent) {

        try {
            // INPUT VALIDATION
            if (parent.getCivilId().isEmpty()) {
                return null;
            } else if (parent.getFirstname().isEmpty()) {
                return null;
            } else if (parent.getLastname().isEmpty()) {
                return null;
            } else if (parent.getAddress().getCity().isEmpty()) {
                return null;
            } else if (parent.getAddress().getState().isEmpty()) {
                return null;
            } else if (parent.getAddress().getStreet().isEmpty()) {
                return null;
            } else if (parent.getAddress().getZip().isEmpty()) {
                return null;
            } else {
                // INPUT IS VALID
                return parentService.addAParent(parent);

            }
        } catch (NullPointerException e) {
            return "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
        }

    }

    @DeleteMapping("/{civilId}")
    public String removeAParent(@PathVariable String civilId) {
        try {
            //INPUT VALIDATION
            if (civilId.isEmpty()) {
                return null;
            } else {
                return parentService.removeAParent(civilId);
            }
        } catch (NullPointerException e) {
            return "INVALID INPUT : NO GIVEN CIVIL-ID OR NULL ID";
        }
    }

    @PutMapping("/{civilId}")
    public String addAParent(@RequestBody Parent parent,@PathVariable String civilId) {

        try {
            // INPUT VALIDATION
            if (parent.getCivilId().isEmpty()) {
                return null;
            } else if (parent.getFirstname().isEmpty()) {
                return null;
            } else if (parent.getLastname().isEmpty()) {
                return null;
            } else if (parent.getAddress().getCity().isEmpty()) {
                return null;
            } else if (parent.getAddress().getState().isEmpty()) {
                return null;
            } else if (parent.getAddress().getStreet().isEmpty()) {
                return null;
            } else if (parent.getAddress().getZip().isEmpty()) {
                return null;
            } else {
                // INPUT IS VALID
                return parentService.updateAParent(parent,civilId);

            }
        } catch (NullPointerException e) {
            return "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
        }

    }
}
