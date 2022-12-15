package assignment.address.dto;

import lombok.Data;

@Data
public class RequestAddressDto {

    private String name;
    private String phoneNumber;
    private String residence;

    private RequestAddressDto(String name, String phoneNumber, String residence) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.residence = residence;
    }

    public static RequestAddressDto of(String name, String phoneNumber, String residence) {
        return new RequestAddressDto(name, phoneNumber, residence);
    }
}
