package com.app;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTimeSerializer>{
	
	@Override
	public void serialize(LocalDateTimeSerializer arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException {
		arg1.writeString(arg0.toString());
		
	}
}
