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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RequiredArgsConstructor
@RequestMapping("/addresses")
@RestController
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<Page<ResponseAddressDto>> addresses(@PageableDefault(sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
                                                              @RequestParam(required = false, defaultValue = "") String keyword) {
        return ResponseEntity.ok(addressService.searchAddresses(pageable, keyword));
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<ResponseAddressDto> address(@PathVariable Long addressId) {
        return ResponseEntity.ok(addressService.getAddress(addressId));
    }

    @PostMapping
    public ResponseEntity<ResponseAddressDto> create(@RequestBody RequestAddressDto addressDto) {
        ResponseAddressDto responseAddressDto = addressService.saveAddress(addressDto);
        return ResponseEntity.created(URI.create("/addresses/" + responseAddressDto.getId())).
                body(responseAddressDto);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<ResponseAddressDto> edit(@PathVariable Long addressId, RequestAddressDto addressDto) {
        return ResponseEntity.ok(addressService.updateAddress(addressId, addressDto));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Object> remove(@PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
