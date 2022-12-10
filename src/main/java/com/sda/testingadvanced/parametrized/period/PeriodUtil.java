package com.sda.testingadvanced.parametrized.period;

import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class PeriodUtil {

	static final int THRESHOLD_MONTH_HALF = 15;

	/**
	 * When from is not null then
	 * if from is between 1st and 15th then month = that month
	 * if from is after 15th then month = next month
	 * otherwise
	 * if to is between 1st and 15th then month = previous month
	 * if to is after 15th then month = that month
	 *
	 * @param from beginning of the period
	 * @param to   end of the period
	 * @return classified to year-month
	 * @throws java.lang.IllegalArgumentException when both dates are null or to is before from
	 */
	public static YearMonth getPeriod(Instant from, Instant to) {
		if (from == null && to == null) {
			throw new IllegalArgumentException("One of the date should not be null");
		}

		if (from != null) {
			ZonedDateTime zonedDateTime = from.atZone(ZoneOffset.UTC);
			if (zonedDateTime.getDayOfMonth() <= THRESHOLD_MONTH_HALF) {
				return YearMonth.of(zonedDateTime.getYear(), zonedDateTime.getMonth());
			} else {
				ZonedDateTime nextMonth = zonedDateTime.plusMonths(1);
				return YearMonth.of(nextMonth.getYear(), nextMonth.getMonthValue());
			}
		} else {
			ZonedDateTime zonedDateTime = to.atZone(ZoneOffset.UTC);
			if (zonedDateTime.getDayOfMonth() <= THRESHOLD_MONTH_HALF) {
				ZonedDateTime previousMonth = zonedDateTime.minusMonths(1);
				return YearMonth.of(previousMonth.getYear(), previousMonth.getMonthValue());
			} else {
				return YearMonth.of(zonedDateTime.getYear(), zonedDateTime.getMonthValue());
			}
		}
	}

}
