package core.product.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data @AllArgsConstructor
public class Product {
	private String type;
	private String brand;
	private List<Template> templates;
}



