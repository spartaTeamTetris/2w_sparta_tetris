import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Date dateToday;


		System.out.println(inputStringToDate());

	}

	public static Date inputStringToDate () {

		Scanner scanner = new Scanner(System.in);
		String date;
		Date returnDate;

		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		format.setLenient(false);
		while (true) {
			System.out.println('\n' + "날짜를 입력해주세요:");
			date = scanner.nextLine();
			try {
				returnDate = format.parse(date);
				return returnDate;
			} catch (ParseException e) {
				System.out.println("날짜를 다시 입력해주세요.");
			}
		}
	}

}