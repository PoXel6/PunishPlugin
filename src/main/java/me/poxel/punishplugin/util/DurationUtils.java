package me.poxel.punishplugin.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class DurationUtils {


	public static Duration parseString(String input) {

		PeriodFormatter format = new PeriodFormatterBuilder().appendSeconds()
		                                                     .appendSuffix("s")
		                                                     .appendMinutes()
		                                                     .appendSuffix("m")
		                                                     .appendHours()
		                                                     .appendSuffix("h")
		                                                     .appendDays()
		                                                     .appendSuffix("d")
		                                                     .appendWeeks()
		                                                     .appendSuffix("W")
		                                                     .appendMonths()
		                                                     .appendSuffix("M")
		                                                     .appendYears()
		                                                     .appendSuffix("Y")
		                                                     .toFormatter();
		return format.parsePeriod(input).toStandardDuration();
	}
}