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
import com.example.demo.serviceimplementation.ChildServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ChildControllerTest {

	@InjectMocks
	ChildController childController;
	@Mock
	ChildServiceImpl childServiceImpl;


	@Test
	@Description("Adding a Child using addAChild() method ")
	public void test_addAChild() {
		Child child = new Child("123", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		when(childServiceImpl.addAChild(child)).thenReturn("CHILD IS ADDED SUCCESSFULLY");
		String actual = childController.addAChild(child);
		String expected = "CHILD IS ADDED SUCCESSFULLY";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to add a Child using addAChild() method but civilId is null")
	public void test_addAChild_with_null_child_civilId() {
		Child child = new Child(null, "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		String actual = childController.addAChild(child);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to add a Child using addAChild() method but parent's civilId is null")
	public void test_addAChild_with_null_parent_civilId() {
		Child child = new Child("123", "moin", "mahmud",
				new Parent(null, "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		String actual = childController.addAChild(child);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
	}

	@Test
	@Description("Attempting to add a Child using addAChild() method but firstname is null ")
	public void test_addAChild_with_null_Child_firstName() {
		Child child = new Child("123", null, "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		String actual = childController.addAChild(child);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";
		// System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
	}

	@Test
	@Description("Attempting to add a Child using addAChild() method but multiple fields are null ")
	public void test_addAChild_with_null_Multiple_fields() {
		Child child = new Child("123", null, "mahmud",
				new Parent(null, null, "mohammed", new Address("2", "CTG", "CTG", "4321")));
		String actual = childController.addAChild(child);
		String expected = "INVALID INPUT : ONE OR MORE INPUT FIELDS ARE NULL";

		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));
	}

	@Test
	@Description("Getting all child using getAllChild() method ")
	public void test_getAllChild() {
		Child child1 = new Child("123", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		Child child2 = new Child("234", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		List<Child> childList = new ArrayList<>();
		childList.add(child1);
		childList.add(child2);
		when(childServiceImpl.getAllChild()).thenReturn(childList);
		List<Child> childList2 = childServiceImpl.getAllChild();
		Assert.assertEquals(childList, childList2);

	}

	@Test
	@Description("Removing a child using removeAChild() method ")
	public void test_removeAChild() {
		String civilId = "123";
		when(childServiceImpl.removeAChild("123")).thenReturn("CHILD ID : " + "123" + " REMOVED SUCCESSFULLY");
		String actual = childController.removeAChild(civilId);
		String expected = "CHILD ID : " + "123" + " REMOVED SUCCESSFULLY";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to remove a child but Invalid civilId")
	public void test_removeAChild_with_Invalid_civilId() {
		String civilId = "123";
		when(childServiceImpl.removeAChild("123")).thenReturn("CHILD ID : " + "123" + " IS INVALID");
		String actual = childController.removeAChild(civilId);
		String expected = "CHILD ID : " + civilId + " IS INVALID";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Attempting to remove a child but null civilId")
	public void test_removeAChild_with_null_civilId() {
		String civilId = null;
		// when(childServiceImpl.removeAChild("123")).thenReturn("CHILD ID : " + "123" +
		// " IS INVALID");
		String actual = childController.removeAChild(civilId);
		String expected = "INVALID INPUT : NO GIVEN CIVIL-ID OR NULL ID";
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}

	@Test
	@Description("Updating a child")
	public void test_updateAChild() {
		String civilId = "123";
		Child child = new Child("123", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		when(childServiceImpl.updateAChild(child,civilId)).thenReturn("CHILD WITH CIVIL_ID : "+"123"+" IS UPDATED SUCCESSFULLY");
		String actual = childController.updateAChild(child,civilId);
		String expected = "CHILD WITH CIVIL_ID : "+"123"+" IS UPDATED SUCCESSFULLY";
		System.out.println(actual);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(actual, expected));

	}
}
