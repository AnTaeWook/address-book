package assignment.address.controller;

import assignment.address.dto.RequestAddressDto;
import assignment.address.dto.ResponseAddressDto;
import assignment.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/addresses")
@RestController
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public Page<ResponseAddressDto> addresses(@PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
                                              @RequestParam(required = false, defaultValue = "") String keyword) {
        return addressService.searchAddresses(pageable, keyword);
    }

    @GetMapping("/{addressId}")
    public ResponseAddressDto address(@PathVariable Long addressId) {
        return addressService.getAddress(addressId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseAddressDto create(RequestAddressDto addressDto) {
        return addressService.saveAddress(addressDto);
    }

    @PutMapping("/{addressId}")
    public ResponseAddressDto edit(@PathVariable Long addressId, RequestAddressDto addressDto) {
        return addressService.updateAddress(addressId, addressDto);
    }

    @DeleteMapping("/{addressId}")
    public void remove(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
    }

}
