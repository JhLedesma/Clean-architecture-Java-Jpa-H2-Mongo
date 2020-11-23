package repository.sql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductSql {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	@Column(name="product_type")
	private String type;

	@Column(name="product_brand")
	private String brand;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "product_x_product_template",
			joinColumns = { @JoinColumn(name = "product_id") },
			inverseJoinColumns = { @JoinColumn(name = "product_template_id") }
	)
	private List<TemplateSql> templates;
}






