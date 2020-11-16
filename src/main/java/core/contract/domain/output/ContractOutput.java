package core.contract.domain.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data @AllArgsConstructor
public class ContractOutput {

	private String id;
	private List<String> templatesNames;
}











