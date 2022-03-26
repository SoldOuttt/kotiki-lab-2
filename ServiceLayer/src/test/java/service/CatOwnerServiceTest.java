package service;

import dao.CatOwnerDAO;
import entity.Cat;
import entity.CatOwner;
import entity.additional_info.CatColor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.Calendar;

import static org.mockito.BDDMockito.given;

class CatOwnerServiceTest {

	@Mock
	private CatOwnerDAO catOwnerDAO;
	private CatOwnerService catOwnerService;

	@org.junit.jupiter.api.BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		catOwnerService = new CatOwnerService(catOwnerDAO);
	}

	@Test
	@SneakyThrows
	void findCatOwnerById() {
		Cat cat = Cat.builder()
				.name("vim")
				.dayOfBirth(new Date(121, Calendar.MARCH, 1))
				.color(CatColor.BLACK)
				.breed("ha")
				.build();
		CatOwner catOwner = CatOwner.builder()
				.fullName("Ma")
				.dayOfBirth(new Date(121, Calendar.MARCH, 1))
				.cat(cat)
				.build();
		given(catOwnerDAO.findById(1L)).willReturn(catOwner);
		CatOwner returnedOwner = catOwnerService.findById(1L);
		Assertions.assertEquals(returnedOwner, catOwner);
	}
}