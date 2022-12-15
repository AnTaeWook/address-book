package assignment.address.service;

import assignment.address.domain.Address;
import assignment.address.dto.AddressDto;
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

    public Page<Address> searchAddresses(Pageable pageable, String keyword) {
        if (keyword == null) {
            keyword = "";
        }
        return addressRepository.findByNameContaining(keyword, pageable);
    }

    public Address getAddress(Long addressId) {
        Optional<Address> findAddress = addressRepository.findById(addressId);
        validateAddress(findAddress);
        return findAddress.get();
    }

    public Address saveAddress(AddressDto addressDto) {
        return addressRepository.save(Address.of(addressDto.getName(),
                addressDto.getPhoneNumber(),
                addressDto.getResidence()));
    }

    public Address updateAddress(Long addressId, AddressDto addressDto) {
        Optional<Address> findAddress = addressRepository.findById(addressId);
        validateAddress(findAddress);
        update(addressDto, findAddress.get());
        return findAddress.get();
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    private void validateAddress(Optional<Address> findAddress) {
        if (findAddress.isEmpty()) {
            throw new EntityNotFoundException("해당 ID에 해당하는 주소가 존재하지 않습니다");
        }
    }

    private void update(AddressDto from, Address to) {
        to.setName(from.getName());
        to.setPhoneNumber(from.getPhoneNumber());
        to.setResidence(from.getResidence());
    }
}
