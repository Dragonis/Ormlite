package com.test.ormlite;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;

public class Note {
	
	@DatabaseField(generatedId=true)
	int id;
	
	@DatabaseField
	String subject;
	
	@DatabaseField
	String text;
	
	@DatabaseField
	Date date;
	
	public Note(){
		
	}

	public Note(String subject, String text) {
		super();
		this.subject = subject;
		this.text = text;
		this.date = new Date(System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", subject=" + subject + ", text=" + text
				+ ", date=" + date + "]";
	}
	
}
