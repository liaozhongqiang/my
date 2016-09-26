package jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test1 {
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		//String str="{ \"identifier\": \"myIdentifier\", \"parameters\":{ \"param1\": [\"value1\", \"value2\"] } }";
		
		String str="{ \"identifier\": \"myIdentifier\", \"parameters\":{ \"param1\": \"values\" } }";
		
		ObjectMapper obj=new ObjectMapper();
		obj.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		MyDTO myDTO=obj.readValue(str, MyDTO.class);
		System.out.println(myDTO);
	}

}
