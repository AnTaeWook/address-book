package assignment.address.service;

import assignment.address.domain.Address;
import assignment.address.dto.RequestAddressDto;
import assignment.address.dto.ResponseAddressDto;
import assignment.address.global.code.UserErrorCode;
import assignment.address.global.exception.NoSuchAddressException;
import assignment.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public Page<ResponseAddressDto> searchAddresses(Pageable pageable, String keyword) {
        return addressRepository.findByNameContaining(pageable, keyword).map(ResponseAddressDto::from);
    }

    public ResponseAddressDto getAddress(Long addressId) {
        return ResponseAddressDto.from(getAddressWithId(addressId));
    }

    @Transactional
    public ResponseAddressDto saveAddress(RequestAddressDto requestAddressDto) {
        return ResponseAddressDto.from(addressRepository.save(Address.of(requestAddressDto.getName(),
                requestAddressDto.getPhoneNumber(),
                requestAddressDto.getResidence())));
    }

    @Transactional
    public ResponseAddressDto updateAddress(Long addressId, RequestAddressDto requestAddressDto) {
        Address address = Address.builder()
                .id(addressId)
                .name(requestAddressDto.getName())
                .phoneNumber(requestAddressDto.getPhoneNumber())
                .residence(requestAddressDto.getResidence())
                .build();
        return ResponseAddressDto.from(addressRepository.save(address));
    }

    @Transactional
    public void deleteAddress(Long addressId) {
        Address address = getAddressWithId(addressId);
        addressRepository.delete(address);
    }

    private Address getAddressWithId(Long addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new NoSuchAddressException(
                UserErrorCode.NO_SUCH_ADDRESS
        ));
    }
}
