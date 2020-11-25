package controller;

import core.contract.domain.Contract;
import core.contract.service.ContractService;
import core.exception.ResourcesNotFoundException;
import core.product.domain.Product;
import core.contract.domain.input.ContractInput;
import core.contract.domain.output.ContractOutput;
import core.product.domain.Template;
import core.product.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContractController {

	private ProductService productService;
	private ContractService contractService;

	public ContractController(ProductService productService, ContractService contractService) {
		this.productService = productService;
		this.contractService = contractService;
	}

	public ContractOutput generateContract(ContractInput request) {

		Product product = productService.getProduct(request.getProductId());
		Contract contract = contractService.createContract(product, request.getUserId());
		final List<String> templatesNames = contract.getProduct().getTemplates().stream().map(Template::getName).collect(Collectors.toList());
		return new ContractOutput(contract.getId(), templatesNames);
	}
}






