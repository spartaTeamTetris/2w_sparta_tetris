import java.util.Date;
import java.util.UUID;

public class Book {

	private String name;
	private String bookedPhoneNum;
	private Date date;
	private int roomNum;
	private UUID uuid;
	private int bookedNum;

	public Book (String name1, String bookedPhoneNum1, int roomNum1, int bookedNum1) {
		this.name = name1;
		this.bookedPhoneNum = bookedPhoneNum1;
		this.roomNum = roomNum1;
		this.bookedNum = bookedNum1;
 		this.uuid = UUID.randomUUID();
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public String phone_format() {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return this.bookedPhoneNum.replaceAll(regEx, "$1-$2-$3");
	}

	public String uuidToString (UUID uuid1) {
		return uuid1.toString();
	}
}