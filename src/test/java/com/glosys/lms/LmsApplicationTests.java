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

	@Test
	public void testSaveStudent() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String studentName = "Spring";
		String studentBody = mockMvc.perform(MockMvcRequestBuilders.post("/students")
				.contentType("application/json")
				.content("{\"firstName\":\"" + studentName + "\"}"))
			.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		SavedResource studentResource = objectMapper.readValue(studentBody, SavedResource.class);
		System.out.println("The student id is "+studentResource.getId());
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
