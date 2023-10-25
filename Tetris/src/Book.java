import java.util.Date;
import java.util.UUID;

public class Book {

	String name;
	String bookedPhoneNum;
	Date date;
	int roomNum;
	UUID uuid;

	public Book (String name1, String bookedPhoneNum1, int roomNum1) {
		this.name = name1;
		this.bookedPhoneNum = bookedPhoneNum1;
		this.roomNum = roomNum1;

		uuid = setUUID();
	}

	public String phone_format() {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return this.bookedPhoneNum.replaceAll(regEx, "$1-$2-$3");
	}

	private static UUID setUUID () {
		return UUID.randomUUID();
	}

	public String uuidToString (UUID uuid1) {
		return uuid1.toString();
	}

}
