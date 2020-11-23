package repository.document.domain;

import core.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "contract")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDocument {
	@Id
	private String id;
	private String userId;
	private Product product;
}




