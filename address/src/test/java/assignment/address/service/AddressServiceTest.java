package assignment.address.service;

import assignment.address.domain.Address;
import assignment.address.dto.AddressDto;
import assignment.address.repository.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressRepository addressRepository;

    @DisplayName("주소록을 조회하면 페이징된 주소록을 리턴받음")
    @Test
    public void readAll() {
        // Given
        addressRepository.save(Address.of("kim", "010-1234-5678", "test-residence-1-11"));
        addressRepository.save(Address.of("park", "011-1234-5678", "test-residence-1-12"));
        addressRepository.save(Address.of("lee", "042-1234-5678", "test-residence-1-13"));

        // When
        PageRequest request = PageRequest.of(0, 10, Sort.by("name"));
        Page<Address> addresses = addressService.searchAddresses(request, null);

        // Then
        assertThat(addresses.getSize()).isEqualTo(3);
    }

    @DisplayName("단일 주소를 조회하면 해당 ID값의 주소를 리턴받음")
    @Test
    public void read() {
        // Given
        Address savedAddress = addressRepository.save(Address.of("kim", "010-1234-5678", "test-residence-1-11"));

        // When
        Address findAddress = addressService.getAddress(savedAddress.getId());

        // Then
        assertThat(findAddress).isEqualTo(savedAddress);
    }

    @DisplayName("주소록을 저장하면 해당 정보를 리턴하며 저장됨")
    @Test
    void create() {
        // Given
        Address savedAddress = addressService.saveAddress(AddressDto.of("kim", "010-1234-5678", "test-residence-11-1"));

        // When & Then
        assertThat(addressRepository.findAll().size()).isEqualTo(1);
        assertThat(savedAddress.getName()).isEqualTo("kim");
    }

    @DisplayName("단일 주소의 ID와 변환 값을 입력받으면 해당 주소를 업데이트함")
    @Test
    void update() {
        // Given
        Address savedAddress = addressRepository.save(Address.of("kim", "010-1234-5678", "test-residence-1-11"));
        AddressDto addressDto = AddressDto.of("kim", "010-1111-2222", "test-residence-1-11");

        // When
        Address updatedAddress = addressService.updateAddress(savedAddress.getId(), addressDto);

        // Then
        assertThat(updatedAddress.getPhoneNumber()).isEqualTo(addressDto.getPhoneNumber());
    }

    @DisplayName("단일 주소의 ID를 통해 주소를 삭제함")
    @Test
    void delete() {
        // Given
        Address savedAddress = addressRepository.save(Address.of("kim", "010-1234-5678", "test-residence-1-11"));

        // When
        addressService.deleteAddress(savedAddress.getId());

        // Then
        assertThat(addressRepository.findAll().size()).isEqualTo(0);
    }
}