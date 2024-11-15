package co.edu.unbosque.viajesglobalback.util;

import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import co.edu.unbosque.viajesglobalback.model.dto.CustomerDTO;
import co.edu.unbosque.viajesglobalback.model.enums.NotificationTypeEnum;

import java.util.HashSet;
import java.util.Set;

public class CustomerMapper {
	public static CustomerDTO toDto(Customer entity) {
		try {
			Set<NotificationTypeEnum> notificationTypeEnumSet = new HashSet<>();
			String[] aux = entity.getNotificationPreference().split(",");
			for (String s : aux) {
				notificationTypeEnumSet.add(NotificationTypeEnum.valueOf(s.strip()));
			}
			return new CustomerDTO(
					entity.getCustomerId(),
					entity.getFirstName(),
					entity.getLastName(),
					entity.getEmail(),
					entity.getPhone(),
					entity.getCountry(),
					entity.getCity(),
					notificationTypeEnumSet,
					entity.getRegistrationDate()
			);
		} catch (Exception e) {
			System.err.println("Error Mapping Customer to DTO!");
			e.printStackTrace();
			return null;
		}
	}
	
	public static Customer toEntity(CustomerDTO dto) {
		try {
			String notificationPreference = dto.getNotificationPreference().toString().substring(1, dto.getNotificationPreference().toString().length() - 1);
			Customer entity = new Customer();
			entity.setCustomerId(dto.getCustomerId());
			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setPhone(dto.getPhone());
			entity.setCountry(dto.getCountry());
			entity.setCity(dto.getCity());
			entity.setNotificationPreference(notificationPreference);
			entity.setRegistrationDate(dto.getRegistrationDate());
			return entity;
		} catch (Exception e) {
			System.err.println("Error Mapping Customer to Entity!");
			e.printStackTrace();
			return null;
		}
	}
}
