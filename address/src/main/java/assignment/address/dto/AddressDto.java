package assignment.address.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String name;
    private String phoneNumber;
    private String residence;

    private AddressDto(String name, String phoneNumber, String residence) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.residence = residence;
    }

    public static AddressDto of(String name, String phoneNumber, String residence) {
        return new AddressDto(name, phoneNumber, residence);
    }
}
