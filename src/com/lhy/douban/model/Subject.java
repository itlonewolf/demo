package com.lhy.douban.model;

import java.io.IOException;
import java.util.ArrayList;

import android.util.JsonReader;

public class Subject {
	// public enum Sub {
	// RATING {
	// @Override
	// public String toString() {
	// return "rating";
	// }
	// },
	// TITLE {
	// @Override
	// public String toString() {
	// return "title";
	// }
	// },
	// MAINLAND_PUBDATE {
	// @Override
	// public String toString() {
	// return "mainland_pubdate";
	// }
	// },
	// IMAGES {
	// @Override
	// public String toString() {
	// return "images";
	// }
	// },
	// COLLECT_COUNT {
	// @Override
	// public String toString() {
	// return "collect_count";
	// }
	// },
	// ORIGINAL_TITL {
	// @Override
	// public String toString() {
	// return "original_titl";
	// }
	// },
	// SUBTYPE {
	// @Override
	// public String toString() {
	// return "subtype";
	// }
	// },
	// YEAR {
	// @Override
	// public String toString() {
	// return "year";
	// }
	// },
	// PUBDATES {
	// @Override
	// public String toString() {
	// return "pubdates";
	// }
	// },
	// ALT {
	// @Override
	// public String toString() {
	// return "alt";
	// }
	// },
	// ID {
	// @Override
	// public String toString() {
	// return "id";
	// }
	// }
	// }

	public Rating rating;// rating:
	public String title; // : "安德的游戏",
	public String mainland_pubdate; // : "2014-01-07",
	public Images images;// images;
	public String collect_count; // : 7414,
	public String original_titl; // e: "Ender's Game",
	public String subtype; // : "movie",
	public String year; // : "2013",
	public ArrayList<String> pubdates;// pubdates
	public String alt; // : "http://movie.douban.com/subject/5323957/",
	public String id; // : "5323957"

	public static Subject readSubject(JsonReader reader) throws IOException {
		Rating rating = null;// rating:
		String title = null;
		String mainland_pubdate = null;
		Images images = null;
		String collect_count = null;
		String original_titl = null;
		String subtype = null;
		String year = null;
		ArrayList<String> pubdates = null;
		String alt = null;
		String id = null;
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals("rating")) {
				rating = Rating.readRating(reader);
			} else if (name.equals("title")) {
				title = reader.nextString() ;
			} else if (name.equals("mainland_pubdate")) {
				mainland_pubdate = reader.nextString() ;
			} else if (name.equals("images")) {
				
				//FIXME
				images = Images.readImage(reader) ;
			} else if (name.equals("collect_count")) {
				collect_count = reader.nextString() ;
			} else if (name.equals("original_titl")) {
				original_titl = reader.nextString() ;
			} else if (name.equals("subtype")) {
				subtype = reader.nextString() ;
			} else if (name.equals("year")) {
				year = reader.nextString() ;
			} else if (name.equals("pubdates")) {
				//FIXME
				pubdates = readStringArray(reader) ;
			} else if (name.equals("alt")) {
				alt = reader.nextString() ;
			} else if (name.equals("id")) {
				id = reader.nextString() ;
			} else {
				reader.skipValue();
			}
		}

		reader.endObject();
		return new Subject(rating, title, mainland_pubdate, images,
				collect_count, original_titl, subtype, year, pubdates, alt, id);
	}

	
	   public static ArrayList<String> readStringArray(JsonReader reader) throws IOException {
		   ArrayList<String> strings = new ArrayList<String>();

		     reader.beginArray();
		     while (reader.hasNext()) {
		    	 strings.add(reader.nextString());
		     }
		     reader.endArray();
		     return strings;
		   }
	
	public Subject() {
		super();
	}

	public Subject(Rating rating, String title, String mainland_pubdate,
			Images images, String collect_count, String original_titl,
			String subtype, String year, ArrayList<String> pubdates,
			String alt, String id) {
		this.rating = rating;
		this.title = title;
		this.mainland_pubdate = mainland_pubdate;
		this.images = images;
		this.collect_count = collect_count;
		this.original_titl = original_titl;
		this.subtype = subtype;
		this.year = year;
		this.pubdates = pubdates;
		this.alt = alt;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Subject [rating=" + rating + ", title=" + title
				+ ", mainland_pubdate=" + mainland_pubdate + ", images="
				+ images + ", collect_count=" + collect_count
				+ ", original_titl=" + original_titl + ", subtype=" + subtype
				+ ", year=" + year + ", pubdates=" + pubdates + ", alt=" + alt
				+ ", id=" + id + "]";
	}

}
