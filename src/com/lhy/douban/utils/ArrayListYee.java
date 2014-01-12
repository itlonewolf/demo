package com.lhy.douban.utils;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListYee<E> extends ArrayList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7758460669469012216L;

	@Override
	public String toString() {
		 if (isEmpty()) {
	            return "is null";
	        }

	        StringBuilder buffer = new StringBuilder(size() * 16);
	        Iterator<?> it = iterator();
	        while (it.hasNext()) {
	            Object next = it.next();
	            if (next != this) {
	                buffer.append(next);
	            } else {
	                buffer.append("(this Collection)");
	            }
	            if (it.hasNext()) {
	                buffer.append(",");
	            }
	        }
	        return buffer.toString();
	}
}
