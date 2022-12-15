package assignment.address.dto;

import assignment.address.domain.Address;
import lombok.Data;

@Data
public class ResponseAddressDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String residence;

    public ResponseAddressDto(Long id, String name, String phoneNumber, String residence) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.residence = residence;
    }

    public static ResponseAddressDto from(Address entity) {
        return new ResponseAddressDto(entity.getId(), entity.getName(), entity.getPhoneNumber(), entity.getResidence());
    }

}
