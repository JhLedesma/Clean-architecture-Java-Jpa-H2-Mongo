package client;

import core.product.domain.input.ProductIn;

public interface ProductClient {
	ProductIn getProductIn(String productId);
}

