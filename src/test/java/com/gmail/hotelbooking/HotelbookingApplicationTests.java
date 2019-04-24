package com.gmail.hotelbooking;

import com.gmail.hotelbooking.controller.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelbookingApplicationTests {

	@Autowired
	private AddressController addressController;

	@Autowired
	private AvailableApartmentController availableApartmentController;

	@Autowired
	private CategoryController categoryController;

	@Autowired
	private OrderController OrderController;

	@Autowired
	private UserController userController;


	@Test
	public void contextLoads() {
		assertThat(addressController).isNotNull();
		assertThat(availableApartmentController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(OrderController).isNotNull();
		assertThat(userController).isNotNull();

	}

}
