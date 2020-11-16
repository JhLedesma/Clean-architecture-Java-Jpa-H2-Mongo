package repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.domain.ProductSql;
import java.util.Optional;

@Repository
public interface ProductSqlDao extends CrudRepository<ProductSql, Integer> {

	Optional<ProductSql> findByProductTypeAndProductEntity(String productType, String productEntity);
}


