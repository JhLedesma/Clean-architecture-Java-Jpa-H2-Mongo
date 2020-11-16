package controller;

import core.product.domain.Product;
import core.contract.domain.input.ContractInput;
import core.contract.domain.output.ContractOutput;
import core.product.service.ProductService;

public class contractController {

	private ProductService productService;

	public contractController(ProductService productService) {
		this.productService = productService;
	}

	private ContractOutput generateContract(ContractInput request) {
		Product product = productService.getProduct(request.getProductId());
	}
}




