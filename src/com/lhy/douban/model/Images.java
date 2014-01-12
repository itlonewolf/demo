package com.lhy.douban.model;

import java.io.IOException;

import android.util.JsonReader;

public class Images {
	public String small;    // "http://img3.douban.com/view/movie_poster_cover/ipst/public/p2164556643.jpg",
	public String large;    // "http://img3.douban.com/view/movie_poster_cover/lpst/public/p2164556643.jpg",
	public String medium;	// "http://img3.douban.com/view/movie_poster_cover/spst/public/p2164556643.jpg"

	public static Images readImage(JsonReader reader) throws IOException {
		String small = null;
		String large = null;
		String medium = null;
		reader.beginObject();
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equalsIgnoreCase("small")) {
				small = reader.nextString();
			} else if (name.equalsIgnoreCase("large")) {
				large = reader.nextString();
			} else if (name.equalsIgnoreCase("medium")) {
				medium = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		reader.endObject();

		return new Images(small, large, medium);
	}

	public Images(String small, String large, String medium) {
		super();
		this.small = small;
		this.large = large;
		this.medium = medium;
	}

	public Images() {
		super();
	}

}
