package org.chikoo.rest.web.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.chikoo.core.entity.SearchResults;
import org.chikoo.core.service.SearchService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class HomeControllerTest {
	
	@InjectMocks
	private HomeController controller;

	@Mock
	private SearchService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void theURLExists() throws Exception {
		mockMvc.perform(get("/home")).andDo(print());
	}
	
	@Test
	public void test() throws Exception {
		SearchResults searchResults = new SearchResults();
		searchResults.setId(1L);
		searchResults.setSearchTerm("Neeraj");
		
		Mockito.when(service.find(1L)).thenReturn(searchResults);
		
		mockMvc.perform(get("/rest/search-results/1"))
		.andExpect(jsonPath("$.searchTerm" , is(searchResults.getSearchTerm())))
		.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/search-results/1"))))
		.andExpect(status().isOk());
	}
	
	
}
