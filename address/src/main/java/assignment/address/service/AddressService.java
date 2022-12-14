package assignment.address.service;

import assignment.address.domain.Address;
import assignment.address.dto.RequestAddressDto;
import assignment.address.dto.ResponseAddressDto;
import assignment.address.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
        Address address = getAddressWithId(addressId);
        update(requestAddressDto, address);
        return ResponseAddressDto.from(address);
    }

    @Transactional
    public void deleteAddress(Long addressId) {
        Address address = getAddressWithId(addressId);
        addressRepository.delete(address);
    }

    private Address getAddressWithId(Long addressId) {
        Optional<Address> findAddress = addressRepository.findById(addressId);
        validateAddress(findAddress);
        return findAddress.get();
    }

    private void validateAddress(Optional<Address> findAddress) {
        if (findAddress.isEmpty()) {
            throw new EntityNotFoundException("?????? ID??? ???????????? ????????? ???????????? ????????????");
        }
    }

    private void update(RequestAddressDto from, Address to) {
        to.setName(from.getName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setResidence(from.getResidence());
    }
}
