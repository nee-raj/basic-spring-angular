package org.chikoo.rest.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.chikoo.core.model.entity.Account;
import org.chikoo.core.model.entity.Blog;
import org.chikoo.core.service.BlogService;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.Module.SetupContext;

public class BlogControllerTest {
	@InjectMocks
	BlogController blogController;
	@Mock
	BlogService blogService;
	MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
	}

	@Test
	public void testGetABlogById() throws Exception {
		Blog blog = new Blog();
		blog.setId(1);
		blog.setAccount((Account) anyObject());
		blog.setTitle("Neeraj's Blog");
		when(blogService.find(1)).thenReturn(blog);
		mockMvc.perform(get("/rest/blog/1")).andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.title", is("Neeraj's Blog")))
		.andExpect( jsonPath("$.id" , is(notNullValue()) ) );
	}
}
