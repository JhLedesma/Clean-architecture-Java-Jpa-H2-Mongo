package repository.document.adapter;

import core.contract.domain.Contract;
import org.modelmapper.ModelMapper;
import repository.document.ContractDocumentRepository;
import repository.document.dao.ContractDocumentDao;
import repository.document.domain.ContractDocument;

public class ContractDocumentAdapter implements ContractDocumentRepository {

	private ContractDocumentDao productSqlDao;
	private ModelMapper modelMapper;

	public ContractDocumentAdapter(ContractDocumentDao productSqlDao, ModelMapper modelMapper) {
		this.productSqlDao = productSqlDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Contract saveContract(Contract contract) {
		final ContractDocument contractDocument = modelMapper.map(contract, ContractDocument.class);
		return modelMapper.map(productSqlDao.save(contractDocument), Contract.class);
	}
}






