package assignment.address.service;

import assignment.address.domain.Address;
import assignment.address.dto.AddressDto;
import assignment.address.repository.AddressRepository;
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
        return null;
    }

    public Address getAddress(Long addressId) {
        return null;
    }

    public Address saveAddress(AddressDto addressDto) {
        return null;
    }

    public Address updateAddress(Long addressId, AddressDto addressDto) {
        return null;
    }

    public void deleteAddress(Long addressId) {
        
    }
}
