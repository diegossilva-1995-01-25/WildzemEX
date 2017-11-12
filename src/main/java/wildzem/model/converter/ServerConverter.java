package wildzem.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import wildzem.model.Server;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.ServerDAO;

@Converter(autoApply = true)
public class ServerConverter implements AttributeConverter<Server, String>{

	@Override
	public String convertToDatabaseColumn(Server server) {
		
		return server.getCode();
	}

	@Override
	public Server convertToEntityAttribute(String key) {
		
		GenericDAO<Server, String> dao = new ServerDAO();
		Server server = dao.select(key);
		
		return server;
	}

}
