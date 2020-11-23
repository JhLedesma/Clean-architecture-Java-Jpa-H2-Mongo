package core.contract.service;

import core.contract.domain.Contract;
import core.product.domain.Product;
import repository.document.ContractDocumentRepository;

import java.util.UUID;

public class ContractService {

	private ContractDocumentRepository contractDocumentRepository;

	public ContractService(ContractDocumentRepository contractDocumentRepository) {
		this.contractDocumentRepository = contractDocumentRepository;
	}

	public Contract createContract(Product product, String userId) {
		final Contract contract = new Contract(UUID.randomUUID().toString(), userId, product);
		return contractDocumentRepository.saveContract(contract);
	}
}






