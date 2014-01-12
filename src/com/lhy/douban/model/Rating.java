package com.lhy.douban.model;

import java.io.IOException;

import android.util.JsonReader;

public class Rating {
	public String max; // : 10,
	public String average; // : 7.2,
	public String stars; // : "40",
	public String min; // : 0

	public Rating(String max, String average, String stars, String min) {
		super();
		this.max = max;
		this.average = average;
		this.stars = stars;
		this.min = min;
	}

	public static Rating readRating(JsonReader reader) throws IOException {
		String max = null; // : 10,
		String average = null; // : 7.2,
		String stars = null; // : "40",
		String min = null; // : 0

		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equalsIgnoreCase("max")) {
				max = reader.nextString();
			} else if (name.equalsIgnoreCase("average")) {
				average = reader.nextString();
			} else if (name.equalsIgnoreCase("stars")) {
				stars = reader.nextString();
			} else if (name.equalsIgnoreCase("min")) {
				min = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();

		return new Rating(max, average, stars, min);
	}

}
