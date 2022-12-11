package com.sda.testingadvanced.mockito.user.solution;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sda.testingadvanced.mockito.user.User;
import com.sda.testingadvanced.mockito.user.UserRepository;
import com.sda.testingadvanced.mockito.user.UserService;
import com.sda.testingadvanced.mockito.user.UserValidator;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserValidator userValidator;

	@InjectMocks
	private UserService userService;

	@Test
	void shouldGetUserById() {
		//given
		final long userId = 7L;
		User user = new User(userId, "Tomasz", "Woźniak");

		when(userRepository.findById(userId)).thenReturn(Optional.of(user));

		//when
		User userById = userService.getUserById(userId);

		//then
		assertNotNull(userById);
		assertEquals(user, userById);
		verify(userRepository, times(1)).findById(anyLong());
		verify(userValidator, never()).isUserValid(any());
		verifyNoInteractions(userValidator);
	}
}