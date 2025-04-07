package com.lumius.taskTracker;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeAdaptor -- Adaptor used to get gson to work with LocalDateTime objects
 * @author Razvan Rotundu
 */
public class LocalDateTimeAdaptor implements JsonDeserializer<LocalDateTime>, JsonSerializer<LocalDateTime> {

//	Custom date time formatter to convert LocalDateTime to formatted string
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
	
	/**
	 * Converts LocalDateTime object to formatted string according to the formatter
	 */
	@Override
	public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(src));
	}

	/**
	 * Parse a JSON string representing a date into a LocalDateTime object
	 */
	@Override
	public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		return LocalDateTime.parse(json.getAsString(), formatter);
	}

}
