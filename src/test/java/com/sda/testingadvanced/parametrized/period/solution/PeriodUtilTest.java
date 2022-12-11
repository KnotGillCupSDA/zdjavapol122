package com.sda.testingadvanced.parametrized.period.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.sda.testingadvanced.parametrized.period.PeriodUtil;

class PeriodUtilTest {

	@ParameterizedTest
	@MethodSource
	void shouldReturnExpectedMonth(Instant instantFrom, Instant instantTo, YearMonth expectedMonth) {
		assertEquals(expectedMonth, PeriodUtil.getPeriod(instantFrom, instantTo));
	}

	public static Stream<Arguments> shouldReturnExpectedMonth() {
		return Stream.of(
				Arguments.of(
						getInstant(2021, 6, 12),
						getInstant(2021, 7, 11),
						YearMonth.of(2021, 6)
				),

				Arguments.of(
						getInstant(2021, 6, 12),
						null,
						YearMonth.of(2021, 6)
				),

				Arguments.of(
						getInstant(2021, 6, 16),
						getInstant(2021, 7, 11),
						YearMonth.of(2021, 7)
				),

				Arguments.of(
						null,
						getInstant(2021, 7, 11),
						YearMonth.of(2021, 6)
				),
				Arguments.of(
						null,
						getInstant(2021, 7, 16),
						YearMonth.of(2021, 7)
				),
				Arguments.of(
						getInstant(2021, 12, 16),
						getInstant(2022, 1, 14),
						YearMonth.of(2022, 1)
				),

				Arguments.of(
						null,
						getInstant(2022, 1, 14),
						YearMonth.of(2021, 12)
				)

		);
	}

	@Test
	void shouldThrowExceptionWhenBothDatesAreNull() {
		Assertions.assertThrows(RuntimeException.class, () -> PeriodUtil.getPeriod(null, null));
		//Assertions.assertThrowsExactly(RuntimeException.class, () -> PeriodUtil.getPeriod(null, null));
	}

	private static Instant getInstant(int year, int month, int dayOfMonth) {
		return LocalDate.of(year, month, dayOfMonth).atStartOfDay().toInstant(ZoneOffset.UTC);
	}

}