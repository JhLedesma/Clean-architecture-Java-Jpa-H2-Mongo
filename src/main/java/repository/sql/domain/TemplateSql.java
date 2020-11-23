package repository.sql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_template")
@Data @NoArgsConstructor @AllArgsConstructor
public class TemplateSql {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	@Column(name="name")
	private String name;

	@ManyToMany(mappedBy = "templates")
	private List<ProductSql> products;

}

