package com.glosys.lms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LmsApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetCourse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/courses").content("{\"name\":\"Spring Boot\",\"courseCategory\":{\"id\":7,\"name\":\"Artificial Intelligence and Data Science \"}}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name","Spring Boot",));

		mockMvc.perform(MockMvcRequestBuilders.get("/courses?id=3"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name","DATA STRUCTURES AND APPLICATION DEVELOPMENT USING C",));
				/*{"id":3,"name":"DATA STRUCTURES AND APPLICATION DEVELOPMENT USING C","code":"AD15","syllabus":"C Environment,
				 Basics of C, Decision Making, Loops, Arrays, Strings, Functions, Scope Rules, Structures, Unions, Pointers,
				  Memory Management, Bit Fields, Error Handling, Interaction with Files, Doubly Linked List, Tree Operations,
				  Data base Integration, SQL Operations, Standarad Template Libraries, Algorithms Complexity, Linux Scripting\r\n\r\n\r\n\r\n",
				  "courseCategory":{"id":7,"name":"Artificial Intelligence and Data Science "},"workshopEligibility":false,
				  "researchTrainingEligibility":true,"inplantTrainingEligibility":true,"corporateTrainingEligibility":true}*/

	}

}
