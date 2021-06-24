package client;

import core.product.domain.input.ProductIn;
import core.product.domain.output.ProductOutput;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import util.JsonParser;

public class ProductClientImpl implements ProductClient {

	private String riskUrl;
	private RestTemplate restTemplate;

	public ProductClientImpl(String riskUrl, RestTemplate restTemplate) {
		this.riskUrl = riskUrl;
		this.restTemplate = restTemplate;
	}

	public ProductIn getProductIn(String productId) {

		final String json = JsonParser.toJson(new ProductOutput(productId));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);

		return restTemplate.postForObject(riskUrl, entity, ProductIn.class);
	}
}



