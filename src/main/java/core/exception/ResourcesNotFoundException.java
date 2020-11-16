package core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResourcesNotFoundException extends RuntimeException {

	private Integer code;

	public ResourcesNotFoundException(Integer code, String message) {
		super(message);
		this.code = code;
	}
}
