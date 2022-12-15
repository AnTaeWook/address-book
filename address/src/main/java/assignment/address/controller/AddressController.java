package assignment.address.controller;

import assignment.address.dto.RequestAddressDto;
import assignment.address.dto.ResponseAddressDto;
import assignment.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/addresses")
@RestController
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public Page<ResponseAddressDto> addresses(Pageable pageable, @RequestParam(required = false, defaultValue = "") String keyword) {
        return null;
    }

    @GetMapping("/{addressId}")
    public ResponseAddressDto address(@PathVariable Long addressId) {
        return null;
    }

    @PostMapping
    public ResponseAddressDto create(RequestAddressDto addressDto) {
        return null;
    }

    @PutMapping("/{addressId}")
    public ResponseAddressDto edit(@PathVariable Long addressId, RequestAddressDto addressDto) {
        return null;
    }

    @DeleteMapping("/{addressId}")
    public void remove(@PathVariable Long addressId) {

    }

}
