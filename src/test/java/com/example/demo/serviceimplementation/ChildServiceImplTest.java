package com.example.demo.serviceimplementation;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Address;
import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.repository.ChildRepository;

@ExtendWith(MockitoExtension.class)
public class ChildServiceImplTest {

	@InjectMocks
	ChildServiceImpl childServiceImpl;
	@Mock
	ChildRepository childRepository;

	@Test
	public void test_getAllChild() {
		Child child1 = new Child("123", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		Child child2 = new Child("123", "moin", "mahmud",
				new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321")));
		List<Child> childList = new ArrayList<>();
		childList.add(child1);
		childList.add(child2);
		when(childRepository.findAll()).thenReturn(childList);
		List<Child> childList2 = childRepository.findAll();
		Assert.assertEquals(childList, childList2);
	}

}
