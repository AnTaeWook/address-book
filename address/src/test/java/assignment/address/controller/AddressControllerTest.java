package assignment.address.controller;

import assignment.address.service.AddressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
@MockBean(JpaMetamodelMappingContext.class)
class AddressControllerTest {

    private final MockMvc mvc;
    @MockBean
    private AddressService addressService;

    AddressControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("GET - 주소록 목록 조회")
    @Test
    void requestAll() throws Exception {
        // Given
        given(addressService.searchAddresses(any(Pageable.class), eq(null))).willReturn(Page.empty());

        // When & Then
        mvc.perform(get("/addresses"))
                .andExpect(status().isOk());

        then(addressService).should().searchAddresses(any(Pageable.class), eq(""));
    }
}