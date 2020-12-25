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
import com.example.demo.model.Parent;
import com.example.demo.repository.ParentRepository;

@ExtendWith(MockitoExtension.class)
public class ParentServiceImplTest {
	@InjectMocks
	ParentServiceImpl parentServiceImpl;
	@Mock
	ParentRepository parentRepository;

	@Test
	public void test_getAllParent() {
		Parent parent1 = new Parent("456", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		Parent parent2 = new Parent("458", "golam", "mohammed", new Address("2", "CTG", "CTG", "4321"));
		List<Parent> parentList = new ArrayList<>();
		parentList.add(parent1);
		parentList.add(parent2);
		when(parentRepository.findAll()).thenReturn(parentList);
		List<Parent> parentList2 = parentRepository.findAll();
		Assert.assertEquals(parentList, parentList2);
	}

}
