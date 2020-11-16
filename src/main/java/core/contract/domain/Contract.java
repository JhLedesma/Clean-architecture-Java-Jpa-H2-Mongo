package core.contract.domain;

import core.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Contract {

	private String id;
	private String userId;
	private Product product;
}



