import java.security.PublicKey;
import java.util.*;

public class Book {
	String userName;
	String bookedPhoneNum;
	int roomNum;
	Date date;
	Room room;
	UUID uuid;

	private static List<Book> bookList = new ArrayList<>();


	// 1. 날짜
	// 2. 사용자 이름
	// 3. 사용자의 핸드폰 번호
	// 4.


	public Book (String bookedPhoneNum1, String userName1, int roomNum1, Date date1) {
		this.userName = userName1;
		this.bookedPhoneNum = bookedPhoneNum1;
		this.roomNum = roomNum1;
		this.uuid = makeUUID();
		this.date = date1;

		bookList.add(this);
	}

	public String phone_format() {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return this.bookedPhoneNum.replaceAll(regEx, "$1-$2-$3");
	}

	public String uuidToString (UUID uuid1 ) {
		return uuid1.toString();
	}

	private UUID makeUUID () {
		UUID retUUID;
		retUUID = UUID.randomUUID();
		return  retUUID;
	}

	public static UUID getUUID(Date date1, String name1, String bookedPhoneNum1, int roomNum) {
		for (Book book : bookList) {
			if (book.userName.equals(name1) && book.bookedPhoneNum.equals(bookedPhoneNum1) && book.date.equals(date1) && book.roomNum == roomNum) {
					return book.uuid;
			}
		}
		return null;
	}

	public UUID getThisUUID() {
		return this.uuid;
	}

	public static List<Book> getBookList() {
		return bookList;
	}

	public Date getDate() {
		return date;
	}

	public int getRoomNumber() {
		return roomNum;
	}
}
