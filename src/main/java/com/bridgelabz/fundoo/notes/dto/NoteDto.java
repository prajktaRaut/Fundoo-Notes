package com.bridgelabz.fundoo.notes.dto;

public class NoteDto {

	private String title;

	private String description;

	
	
	public NoteDto() {
		super();
	}

	public NoteDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NoteDto [title=" + title + ", description=" + description + "]";
	}
	
	
	
}
