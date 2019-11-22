package ma.nory.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessingOnTheDate {

	public static String getDateNow() {
		DateFormat formatter = DateFormat.getInstance();
		String dateStr = formatter.format(new Date());

		return dateStr;
	}

	@SuppressWarnings("deprecation")
	public static String formattDate(String dateInString) {
		System.out.println(dateInString);
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date(dateInString);
		return ft.format(date);
	}
}
