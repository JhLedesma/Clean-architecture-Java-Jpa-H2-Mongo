package core.contract.domain;

import core.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Contract {

	private String id;
	private String userId;
	private Product product;
}



