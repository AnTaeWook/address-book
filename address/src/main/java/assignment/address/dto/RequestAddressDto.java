package assignment.address.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestAddressDto {

    @NotBlank
    private String name;

    @NotBlank
    private String phoneNumber;

    @NotBlank
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
