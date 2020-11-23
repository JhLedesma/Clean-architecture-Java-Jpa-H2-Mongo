package repository.document.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import repository.document.domain.ContractDocument;

@Repository
public interface ContractDocumentDao extends MongoRepository<ContractDocument, String> {

	ContractDocument save(ContractDocument contractDocument);
}







