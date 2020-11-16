package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class JsonParser {

	private static ObjectMapper mapper =
			new ObjectMapper()
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.setSerializationInclusion(JsonInclude.Include.NON_NULL);

	public static String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			LogErrorParsing(e);
			return null;
		}
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			LogErrorParsing(e);
			return null;
		}
	}

	public static <T> T toObject(String json, TypeReference<T> typeReference) {
		try {
			return mapper.readValue(json, typeReference);
		} catch (Exception e) {
			LogErrorParsing(e);
			return null;
		}
	}

	public static List<String> jsonToList(String json) {
		try {
			return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
		} catch (Exception e) {
			LogErrorParsing(e);
			return null;
		}
	}

	private static void LogErrorParsing(Exception e) {
		log.error("Error parsing json: {}", e.getMessage());
	}
}
