import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Functions {

	static Scanner scanner = new Scanner(System.in);

	public static Date inputStringToDate () {

		// scanner 를 갖고 있음.
		// Str ( 000000 ) -> Date
		// 예외 처리 탑재
		// return Date

		String date;
		Date returnDate;

		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		format.setLenient(false);
		while (true) {
			date = scanner.nextLine();
			try {
				returnDate = format.parse(date);
				return returnDate;
			} catch (ParseException e) {
				System.out.println("날짜를 다시 입력해주세요.");
			}
		}
	}

	public static int inputStringToInt () {

		// scanner 를 갖고 있음.
		// Str -> Int
		// 예외 처리 탑재
		// return Int

		String inputStr;
		int returnInt;

		while (true) {
			inputStr = scanner.nextLine();
			try {
				returnInt = Integer.parseInt(inputStr);
				if (0 < returnInt && returnInt < 100) {
					return returnInt;
				}
				else
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				System.out.println("범위 내의 숫자만 입력해주세요.");
			}
		}
	}




	// Date type을 String으로 변환
	public String returnDateToString(Date date){
		SimpleDateFormat a = new SimpleDateFormat("yyyyMMdd");
		String str;
		str = a.format(date);
		return str;
	}



}
