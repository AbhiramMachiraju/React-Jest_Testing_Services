package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.service.model.BioDataTO;
import com.example.service.repo.BioDao;
import com.example.service.services.impl.BioServiceImpl;

/*@RunWith(MockitoJUnitRunner.class) : Invokes the class MockitoJUnitRunner to run the tests instead of running in the standard built in class.
@Mock : Used to simulate the behavior of a real object, in this case, our repository
@InjectMocks : Creates an instance of the class and injects the mock created with the @Mock annotation into this instance
@Test : Tells JUnit that the method to which this annotation is attached can be run as a test case*/

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BioDataTest {

	@Mock
	private BioDao daoLayer;

	@InjectMocks
	private BioServiceImpl serviceLayer;


	/*
	 * @BeforeEach void setUp() { daoLayer = Mockito.mock(BioDao.class);
	 * serviceLayer = new BioServiceImpl(); }
	 */

	/*
	 * @BeforeEach void setMockOutput() {
	 * when(daoLayer.get()).thenReturn("Hello Mockito From Repository"); }
	 */

	@Test
	@Order(1)
	@DisplayName("TEST_1 :: fetchAll Bio Data ")
	void testFindAll() {

	}

	@Test
	@Order(2)
	@DisplayName("TEST_2 :: Save Bio Data ")
	void testFindById() {
		BioDataTO to = new BioDataTO();
		to.setName("TEST_NAME");
		to.setAge(5);
		to.setCountry("TETS_COUN");
		to.setMobile("00000000000");
		to.setState("TEST_STATE");
		to.setAdrs("TEST_ADRS12123124243242342343423");
		when(daoLayer.save(to)).thenReturn(to).getMock();
	}

	@Test
	@Order(2)
	@DisplayName("TEST_3 :: Find by  Bio Data autoId ")
	// @Rollback(value = false)
	public void deleteEmployeeTest() {

		long l = 4L;
		doNothing().when(serviceLayer).deleteById(l);
	}

}
