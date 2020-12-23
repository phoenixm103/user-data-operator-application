package com.example.demo.serviceimplementation;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.controller.ChildController;
import com.example.demo.model.Address;
import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.repository.ChildRepository;
import com.example.demo.repository.ParentRepository;

@ExtendWith(MockitoExtension.class)
public class ChildServiceImplTest {

	@Mock
	ChildServiceImpl childServiceImpl;
	@Mock
	ChildRepository childRepository;
	@Mock
	ChildController childController;
	
	Child child = new Child("123", "moin", "mahmud",
			new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
	
//	@Test
//	public void test_addAChild_Response() {
//		when(childServiceImpl.addAChild(child)).thenReturn("CHILD IS ADDED SUCCESSFULLY");
//		String expected = "CHILD IS ADDED SUCCESSFULLY";
//		String actual = childServiceImpl.addAChild(child);
//		System.out.println(actual);
//		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
//	}
//	
	@Test
	public void test_addAChild_Response() {
		//when(childRepository.save(child)).thenReturn(child);
		//when(childServiceImpl.addParentToParentCollection(child)).thenReturn(true);
		//when(childRepository.findById(child.getCivilId())).thenReturn(Optional.empty());
		String s=childController.addAChild(child);
		String a="CHILD IS ADDED SUCCESSFULLY";
		System.out.println(s);
		
		
	}
}
