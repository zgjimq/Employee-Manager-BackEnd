package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.makerminds.javaweb.controller.DepartamentController;
import org.makerminds.javaweb.entity.Department;
import org.makerminds.javaweb.service.DepartmentService;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
class Demo22ApplicationTests {
//kjo ka me zavendesu pjesen e serverit
	
// nuk po ekzekutohet mire me errora 
/*perdorimi qka per me tregu qka ka me ndodh kur metoda departmentService  ka me u thirr
 prsh kur dojna me i validu te dhenat ato nuk ndodhin sepse nuk ka server qe e ben at @Valid
 	 qka ka menaxhu kjo osht departmentcontroller e ky controlleri do e perdor servisin
 */
private MockMvc mockMvc;
@MockBean
private DepartmentService departmentService;


/* object mapper kthen rezultate java object, kthen json format ose anasjelltas
shendrrimi i te dhenave*/
private ObjectMapper objectMapper;


/*
 * Ka me i pergadit kto per me u perdor prej test
 * MockBean perdoret per me e be departmentservice nje mock
 */
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); 
		mockMvc = MockMvcBuilders.standaloneSetup(new DepartamentController(departmentService)).build();
		objectMapper = new ObjectMapper();
	}
	
	

//kjo metod do te ekzekutohet para te tjerave dmth e para prej cdo metode testuese
	@Test
	void testGetDepartments()throws Exception{
		Department department1= new Department();
		department1.setId(1L);
		department1.setName("Department1");
		Department department2= new Department();
		department2.setId(2L);
		department2.setName("Department2");
		when(departmentService.getDepartments()).thenReturn(Arrays.asList(department1, department2));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/departaments/getAll"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("department1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
		.andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("department2"));
	}
}
