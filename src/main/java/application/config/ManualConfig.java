package application.config;

import client.ProductClientImpl;
import controller.ContractController;
import core.contract.service.ContractService;
import core.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import repository.document.ContractDocumentRepository;
import repository.document.adapter.ContractDocumentAdapter;
import repository.document.dao.ContractDocumentDao;
import repository.sql.ProductSqlRepository;
import repository.sql.adapter.ProductSqlAdapter;
import repository.sql.dao.ProductSqlDao;

import java.time.Duration;

public class ManualConfig {

	private String riskUrl = null;

	public ProductSqlDao productSqlDao() {
		return null;
	}

	public ContractDocumentDao contractDocumentDao() {
		return null;
	}

	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
	}

	public ProductSqlRepository productSqlRepository() {
		return new ProductSqlAdapter(productSqlDao(), modelMapper());
	}

	public ProductClientImpl riskClient() {
		return new ProductClientImpl(riskUrl, restTemplate());
	}

	public ProductService productService() {
		return new ProductService(riskClient(), productSqlRepository());
	}

	public ContractDocumentRepository contractDocumentRepository() {
		return new ContractDocumentAdapter(contractDocumentDao(), modelMapper());
	}

	public ContractService contractService() {
		return new ContractService(contractDocumentRepository());
	}

	public ContractController contractController() {
		return new ContractController(productService(), contractService());
	}

}
