package com.example.demo.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

import com.example.demo.model.Address;
import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.serviceimplementation.ParentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ParentControllerTest {
	@InjectMocks
	ParentController parentController;
	@Mock
	ParentServiceImpl parentServiceImpl;

	@Test
	@Description("Adding a Parent using addAChild() method ")
	public void test_addAParent() {
		Parent parent = new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		when(parentServiceImpl.addAParent(parent)).thenReturn("PARENT IS ADDED SUCCESSFULLY");
		String actual = parentController.addAParent(parent);
		String expected = "PARENT IS ADDED SUCCESSFULLY";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	
	@Test
	@Description("Attempting to add a Parent using addAParent() method but civilId is null")
	public void test_addAParent_with_null_civilId() {
		Parent parent = new Parent(null, "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		String actual = parentController.addAParent(parent);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to add a Parent using addAParent() method but firstname is null ")
	public void test_addAParent_with_null_firstName() {
		Parent parent = new Parent("456", null, "mohammed", new Address("2", "CTG", "CTG", "4321"));
		String actual = parentController.addAParent(parent);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
	}

	@Test
	@Description("Attempting to add a Parent using addAParent() method but multiple fields are null ")
	public void test_addAParent_with_null_Multiple_fields() {
		Parent parent = new Parent(null, null, "mohammed", new Address("2", "CTG", "CTG", "4321"));
		String actual = parentController.addAParent(parent);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";

		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
	}
	@Test
	@Description("Getting all parent using getAllChild() method ")
	public void test_getAllParent() {
		Parent parent1 = new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		Parent parent2 = new Parent("486", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		List<Parent> parentList = new ArrayList<>();
		parentList.add(parent1);
		parentList.add(parent2);
		when(parentServiceImpl.getAllParent()).thenReturn(parentList);
		List<Parent> parentList2 = parentServiceImpl.getAllParent();
		Assert.assertEquals(parentList, parentList2);

	}
	@Test
	@Description("Removing a parent using removeAParent() method ")
	public void test_removeAParent() {
		String civilId = "123";
		when(parentServiceImpl.removeAParent("123")).thenReturn("PARENT ID : " + "123" + " REMOVED SUCCESSFULLY");
		String actual = parentController.removeAParent(civilId);
		String expected = "PARENT ID : " + "123" + " REMOVED SUCCESSFULLY";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to remove a parent but Invalid civilId")
	public void test_removeAParent_with_Invalid_civilId() {
		String civilId = "123";
		when(parentServiceImpl.removeAParent("123")).thenReturn("PARENT ID : " + "123" + " IS INVALID");
		String actual = parentController.removeAParent(civilId);
		String expected = "PARENT ID : " + civilId + " IS INVALID";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to remove a parent but null civilId")
	public void test_removeAParent_with_null_civilId() {
		String civilId = null;
		// when(childServiceImpl.removeAChild("123")).thenReturn("CHILD ID : " + "123" +
		// " IS INVALID");
		String actual = parentController.removeAParent(civilId);
		String expected = "INVALID INPUT : NO GIVEN CIVIL-ID OR NULL ID";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Updating a parent")
	public void test_updateAParent() {
		String civilId = "123";
		Parent parent = new Parent("123", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		when(parentServiceImpl.updateAParent(parent,civilId)).thenReturn("PARENT WITH CIVIL_ID : "+"123"+" IS UPDATED SUCCESSFULLY");
		String actual = parentController.updateAParent(parent,civilId);
		String expected = "PARENT WITH CIVIL_ID : "+"123"+" IS UPDATED SUCCESSFULLY";
		//System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

}
