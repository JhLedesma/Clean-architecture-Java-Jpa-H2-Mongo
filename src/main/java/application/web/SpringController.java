package application.web;

import controller.ContractController;
import core.contract.domain.input.ContractInput;
import core.contract.domain.output.ContractOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SpringController {

	@Autowired
	private ContractController contractController;

	@PostMapping(path = "/contract")
	public ResponseEntity<ContractOutput> generateContract(@RequestBody ContractInput contractInput) {
		final ContractOutput contractOutput = contractController.generateContract(contractInput);
		return new ResponseEntity<>(contractOutput, HttpStatus.OK);
	}
}


