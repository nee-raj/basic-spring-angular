package org.chikoo.core.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SearchResults {
	@Id @GeneratedValue
	private long id;
	private String searchTerm = "" ;

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	
	
	
}
