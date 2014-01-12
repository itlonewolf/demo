package com.lhy.douban.ui.fragmnt;

public enum AllFragmnt {
	// yee用到的相关fragment
	CINEMA {

		@Override
		public String toString() {
			return "cinema's viewpager fragment";
		}

	},
	// 李倩倩用到的相关fragment
	MOVIE {
		@Override
		public String toString() {
			return "movie's viewpager fragment";
		}
	},
	// 黄妮用到的相关fragment
	CELEBRITY {
		@Override
		public String toString() {
			return "celebrity's viewpager fragment";
		}
	}

}
