import java.util.*;

public class Hotel {
	final SetData setData;

// 	예약 배열
//	private final Map<Date, Book[][]> bookArray = new HashMap<>();

	public Hotel() {
		setData = new SetData();
		setData.setData();
	}

	public Book getBookWithUUID(String uuid) {
		UUID code;
		try {
			code = UUID.fromString(uuid);
		} catch (IllegalArgumentException e) {
			return null;
		}

		for (Book book : Book.getBookList()) {
			if(book.getThisUUID().equals(code)) {
				return book;
			}
		}

		return null;
	}

	public boolean cancelBook(String uuid, int ownNum) {
		UUID code;
		try {
			code = UUID.fromString(uuid);
		} catch (IllegalArgumentException e) {
			return false;
		}

		List<Book> bookList = Book.getBookList();
		int idx = -1;
		for (int i = 0; i < bookList.size(); i++) {
			if(bookList.get(i).getThisUUID().equals(code)) {
				idx = i;
				break;
			}
		}
		
		if(idx == -1) return false;
		else {
			Book findBook = bookList.get(idx);
			List<Room> rooms = SetData.getRooms();
			int roomNumber = findBook.getRoomNumber();
			for (int i = 0; i < rooms.size(); i++) {
				if(rooms.get(i).getRoomNum() == roomNumber) {
					for (User user : SetData.getUsers()) {
						if(user.getOwnNum() == ownNum) {
							//user money 올려주고
							user.setMoney(rooms.get(i).getRoomPrice());
							//hotel 예산 내리고
							//TODO
						}
					}
				}
			}

			bookList.remove(idx);
			return true;
		}
	}
}