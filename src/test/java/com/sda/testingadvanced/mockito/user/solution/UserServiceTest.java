package com.sda.testingadvanced.mockito.user.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sda.testingadvanced.mockito.user.User;
import com.sda.testingadvanced.mockito.user.UserRepository;
import com.sda.testingadvanced.mockito.user.UserService;
import com.sda.testingadvanced.mockito.user.UserValidator;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	private static final Long USER_ID = 1234L;
	private static final User USER = new User(USER_ID, "Jan", "Kowalski");

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserValidator userValidator;
	@InjectMocks
	private UserService userService;

	@Test
	void shouldGetUserById() {
		when(userRepository.findById(USER_ID)).thenReturn(Optional.of(USER));

		assertEquals(USER, userService.getUserById(USER_ID));
	}

	@Test
	void shouldThrowExceptionWhenUserNotFound() {
		assertThrows(NoSuchElementException.class, () -> userService.getUserById(1L));
	}

	@Test
	void shouldAddValidUser() {
		//given
		when(userValidator.isUserValid(USER)).thenReturn(true);

		//when
		userService.addUser(USER);

		//then
		//verify that user repository add method has been called
		verify(userRepository, times(1)).addUser(USER);
	}

	@Test
	void shouldThrowExceptionAndNotCallRepositoryWhenAddingInvalidUser() {
		//given
		when(userValidator.isUserValid(USER)).thenReturn(false);

		//when
		assertThrows(IllegalArgumentException.class, () -> userService.addUser(USER));

		//verifyNoInteractions(userRepository);
		verify(userRepository, never()).addUser(USER);
	}
}