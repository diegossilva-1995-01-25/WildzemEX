package wildzem.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import wildzem.model.StaffPosition;
import wildzem.persistence.GenericDAO;
import wildzem.persistence.StaffPositionDAO;

@Converter
public class StaffPositionConverter implements AttributeConverter<StaffPosition, String>{

	@Override
	public String convertToDatabaseColumn(StaffPosition staffPosition) {
		
		return staffPosition.getCode();
	}

	@Override
	public StaffPosition convertToEntityAttribute(String key) {
		
            GenericDAO<StaffPosition, String> dao = new StaffPositionDAO();
		StaffPosition staffPosition = dao.select(key);
		
		return staffPosition;
	}

}
