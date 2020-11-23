package application.config;

import client.RiskClient;
import controller.ContractController;
import core.contract.service.ContractService;
import core.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import repository.document.ContractDocumentRepository;
import repository.document.adapter.ContractDocumentAdapter;
import repository.document.dao.ContractDocumentDao;
import repository.sql.ProductSqlRepository;
import repository.sql.adapter.ProductSqlAdapter;
import repository.sql.dao.ProductSqlDao;
import java.time.Duration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages= {"repository"})
public class SpringConfig {

	@Value("${risk.url}")
	private String riskUrl;
	@Autowired
	private ProductSqlDao productSqlDao;
	@Autowired
	private ContractDocumentDao contractDocumentDao;


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
	}

	@Bean
	public ProductSqlRepository productSqlRepository() {
		return new ProductSqlAdapter(productSqlDao, modelMapper());
	}

	@Bean
	public RiskClient riskClient() {
		return new RiskClient(riskUrl, restTemplate());
	}

	@Bean
	public ProductService productService() {
		return new ProductService(riskClient(), productSqlRepository());
	}

	@Bean
	public ContractDocumentRepository contractDocumentRepository() {
		return new ContractDocumentAdapter(contractDocumentDao, modelMapper());
	}

	@Bean
	public ContractService contractService() {
		return new ContractService(contractDocumentRepository());
	}

	@Bean
	public ContractController contractController() {
		return new ContractController(productService(), contractService());
	}
}
