package jackson;

import java.util.List;
import java.util.Map;



public class MyDTO {
	
	private String identifier;
	
	private Map<String,List<String>> parameters;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Map<String, List<String>> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, List<String>> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		return "{\"identifier\":"+this.identifier+",\"parameters\":"+this.parameters+"}";
	}

}
