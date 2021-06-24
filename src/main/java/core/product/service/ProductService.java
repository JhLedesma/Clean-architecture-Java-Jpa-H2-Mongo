package core.product.service;

import client.ProductClient;
import core.product.domain.Product;
import core.product.domain.input.ProductIn;
import repository.sql.ProductSqlRepository;

public class ProductService {

	private ProductClient productClient;
	private ProductSqlRepository productSqlRepository;

	public ProductService(ProductClient productClient, ProductSqlRepository productSqlRepository) {
		this.productClient = productClient;
		this.productSqlRepository = productSqlRepository;
	}

	public Product getProduct(String productId) {
		final ProductIn productIn = new ProductIn("LOANS", "MANGO"); //productClient.getProductIn(productId);
		return productSqlRepository.findProduct(productIn.getType(), productIn.getBrand());
	}
}








