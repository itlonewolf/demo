package com.lhy.douban.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeanBase implements Parcelable {
	public int count;
	public int total;
	public int start;
	

	public BeanBase() {
		super();
	}
	
	private BeanBase(Parcel in) {
		count = in.readInt();
		total = in.readInt();
		start = in.readInt();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(count);
		out.writeInt(total);
		out.writeInt(start);
	}

	public static final Parcelable.Creator<BeanBase> CREATOR = new Parcelable.Creator<BeanBase>() {
		public BeanBase createFromParcel(Parcel in) {
			return new BeanBase(in);
		}

		public BeanBase[] newArray(int size) {
			return new BeanBase[size];
		}
	};


}