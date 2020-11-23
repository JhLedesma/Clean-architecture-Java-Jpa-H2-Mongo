package core.product.service;

import client.RiskClient;
import core.product.domain.Product;
import core.product.domain.input.ProductIn;
import repository.sql.ProductSqlRepository;

public class ProductService {

	private RiskClient riskClient;
	private ProductSqlRepository productSqlRepository;

	public ProductService(RiskClient riskClient, ProductSqlRepository productSqlRepository) {
		this.riskClient = riskClient;
		this.productSqlRepository = productSqlRepository;
	}

	public Product getProduct(String productId) {
		final ProductIn productIn = riskClient.getProductIn(productId);
		return productSqlRepository.findProduct(productIn.getType(), productIn.getBrand());
	}
}








