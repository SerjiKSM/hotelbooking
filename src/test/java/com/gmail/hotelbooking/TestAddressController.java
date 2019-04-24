package com.gmail.hotelbooking;

import com.gmail.hotelbooking.controller.AddressController;
import com.gmail.hotelbooking.model.Address;
import com.gmail.hotelbooking.service.AddressService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestAddressController {

    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOne() {
        Address newAddress = new Address();
        newAddress.setId(2l);
        when(addressService.findOne(2l)).thenReturn(Optional.ofNullable(newAddress));

        Optional<Address> address = addressController.findOne(2l);

        verify(addressService).findOne(2l);

        assertEquals(2l, address.get().getId().longValue());
    }

    @Test
    public void testAddressList() {
        List<Address> addresses = addressService.addressList();
        assertThat(addresses.size(), Matchers.is(greaterThanOrEqualTo(0)));
    }


}
