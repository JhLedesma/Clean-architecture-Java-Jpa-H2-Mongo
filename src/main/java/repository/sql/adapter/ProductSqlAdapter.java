package repository.sql.adapter;

import core.exception.ResourcesNotFoundException;
import core.product.domain.Product;
import org.modelmapper.ModelMapper;
import repository.sql.ProductSqlRepository;
import repository.sql.dao.ProductSqlDao;

public class ProductSqlAdapter implements ProductSqlRepository {

	private ProductSqlDao productSqlDao;
	private ModelMapper modelMapper;

	public ProductSqlAdapter(ProductSqlDao productSqlDao, ModelMapper modelMapper) {
		this.productSqlDao = productSqlDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Product findProduct(String type, String brand) {
		return productSqlDao.findByTypeAndBrand(type, brand)
				.map(productSql ->  modelMapper.map(productSql, Product.class))
				.orElseThrow(() -> new ResourcesNotFoundException(404, "Product not found"));
	}
}


