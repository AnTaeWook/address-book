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
        Optional<Address> findAddress = addressRepository.findById(addressId);
        validateAddress(findAddress);
        return ResponseAddressDto.from(findAddress.get());
    }

    @Transactional
    public ResponseAddressDto saveAddress(RequestAddressDto requestAddressDto) {
        return ResponseAddressDto.from(addressRepository.save(Address.of(requestAddressDto.getName(),
                requestAddressDto.getPhoneNumber(),
                requestAddressDto.getResidence())));
    }

    @Transactional
    public ResponseAddressDto updateAddress(Long addressId, RequestAddressDto requestAddressDto) {
        Optional<Address> findAddress = addressRepository.findById(addressId);
        validateAddress(findAddress);
        update(requestAddressDto, findAddress.get());
        return ResponseAddressDto.from(findAddress.get());
    }

    @Transactional
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    private void validateAddress(Optional<Address> findAddress) {
        if (findAddress.isEmpty()) {
            throw new EntityNotFoundException("해당 ID에 해당하는 주소가 존재하지 않습니다");
        }
    }

    private void update(RequestAddressDto from, Address to) {
        to.setName(from.getName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setResidence(from.getResidence());
    }
}
