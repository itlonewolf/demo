package com.lhy.douban.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.util.JsonReader;

public class Subjects extends BeanBase {

	// subjects: [],
	public ArrayList<Subject> subjects;
	// title: "正在上映的电影-北京"
	public String title;
	
	
	public static Subjects getSubjectsFromStream(InputStream in) throws IOException{
		JsonReader reader = new JsonReader(new InputStreamReader(in));
		
		ArrayList<Subject> subjects = null;
		String title = null;
		
		reader.beginObject() ;
		while (reader.hasNext()) {
			String name = reader.nextName() ;
			if (name.equals("subjects")) {
				subjects = readSubjectsArray(reader) ;
			}else if (name.equals("title")) {
				title = reader.nextString() ;
			}else {
				reader.skipValue();
			}
		}
		reader.endObject() ;
		
		return new Subjects(subjects, title);
		
	}

	private static ArrayList<Subject> readSubjectsArray(JsonReader reader) throws IOException{
		
		ArrayList<Subject> subjects = new ArrayList<Subject>() ;
		reader.beginArray() ;
		while (reader.hasNext()) {
			subjects.add(Subject.readSubject(reader)) ;
		}
		reader.endArray() ;
		return subjects ;
	}

	public Subjects() {
		super();
	}

	public Subjects(ArrayList<Subject> subjects, String title) {
		this.subjects = subjects;
		this.title = title;
	}


}
