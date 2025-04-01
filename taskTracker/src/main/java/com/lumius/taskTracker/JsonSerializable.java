package com.lumius.taskTracker;

/**
 * Interface for converting an object to and from JSON
 * @author Razvan Rotundu
 * @param <T> The object to be serialized/deserialized
 */
public interface JsonSerializable<T> {

	public String toJson();
	
	public T fromJson(String s);
}
