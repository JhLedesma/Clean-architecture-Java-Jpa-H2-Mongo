package repository.sql.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import repository.sql.domain.ProductSql;
import java.util.Optional;







@Repository
public interface ProductSqlDao extends CrudRepository<ProductSql, Integer> {

	Optional<ProductSql> findByTypeAndBrand(String productType, String productEntity);
}




