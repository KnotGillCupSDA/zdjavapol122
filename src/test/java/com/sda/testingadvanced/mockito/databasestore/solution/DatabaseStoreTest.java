package com.sda.testingadvanced.mockito.databasestore.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sda.testingadvanced.mockito.databasestore.DatabaseConnection;
import com.sda.testingadvanced.mockito.databasestore.DatabaseStore;
import com.sda.testingadvanced.mockito.databasestore.SdaException;

@ExtendWith(MockitoExtension.class)
class DatabaseStoreTest {

	private static final String DATA = "some data";
	@Mock
	DatabaseConnection databaseConnection;
	@InjectMocks
	DatabaseStore databaseStore;

	@Test
	void shouldAddDataForOpenedDatabaseConnection() {
		when(databaseConnection.isOpened()).thenReturn(true);

		assertEquals(1, databaseStore.addData(DATA));

		verify(databaseConnection, times(1)).isOpened();
		verify(databaseConnection, never()).open();
	}

	@Test
	void shouldOpenDatabaseConnectionAndAddData() {

		when(databaseConnection.isOpened())
				.thenReturn(false)
				.thenReturn(true);

		//Sprawdź, czy operacja addData się powiodła
		assertEquals(1, databaseStore.addData(DATA));

		//Sprawdź czy zawołano predykat isOpened() dwukrotnie
		verify(databaseConnection, times(2)).isOpened();

		//Zweyfikuj, że zawołano metodę open()
		verify(databaseConnection, times(1)).open();
	}

	@Test
	void shouldThrowExceptionWhenCantOpenDatabaseConnection() {
		//za każdym razem jak wolany jest predykat isOpened to zwróc false
		when(databaseConnection.isOpened()).thenReturn(false);

		//sprawdź, że dodanie czegokolwiek spowoduje rzucenie wyjątku o typie SdaException
		assertThrows(SdaException.class, ()-> databaseStore.addData(DATA));
	}
}