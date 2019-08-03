package com.glosys.lms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.glosys.lms.rest.SavedResource;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
		ObjectMapper objectMapper = new ObjectMapper();

		String courseCategoryName = "Spring Category";
		String courseCategoryBody = mockMvc.perform(MockMvcRequestBuilders.post("/courseCategories")
					.contentType("application/json")
					.content("{\"name\":\"" + courseCategoryName + "\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		SavedResource courseCategoryResource = objectMapper.readValue(courseCategoryBody, SavedResource.class);
		int courseCategoryId = courseCategoryResource.getId();


		String courseId = mockMvc
				.perform(MockMvcRequestBuilders.post("/courses")
						.contentType("application/json")
						.content("{\"name\":\"Spring Boot\",\"courseCategory\":{\"id\":" + courseCategoryId + ",\"name\":\"" + courseCategoryName + "\"}}"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		SavedResource savedResource = objectMapper.readValue(courseId, SavedResource.class);
		int savedCourseId = savedResource.getId();
		mockMvc.perform(MockMvcRequestBuilders.get("/courses/"+savedCourseId))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name",CoreMatchers.equalTo("Spring Boot")));
	}
}
				/*{"id":3,"name":"DATA STRUCTURES AND APPLICATION DEVELOPMENT USING C","code":"AD15","syllabus":"C Environment,
				 Basics of C, Decision Making, Loops, Arrays, Strings, Functions, Scope Rules, Structures, Unions, Pointers,
				  Memory Management, Bit Fields, Error Handling, Interaction with Files, Doubly Linked List, Tree Operations,
				  Data base Integration, SQL Operations, Standarad Template Libraries, Algorithms Complexity, Linux Scripting\r\n\r\n\r\n\r\n",
				  "courseCategory":{"id":7,"name":"Artificial Intelligence and Data Science "},"workshopEligibility":false,
				  "researchTrainingEligibility":true,"inplantTrainingEligibility":true,"corporateTrainingEligibility":true}
				  }
				  */
