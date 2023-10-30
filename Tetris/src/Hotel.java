import java.util.*;

public class Hotel {
	private long asset = 1_000_000_000L;
	public final SetData setData = new SetData();

	public Hotel() {
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
							int roomPrice = rooms.get(i).getRoomPrice();
							user.setMoney(roomPrice);
							this.setAsset(this.getAsset() - roomPrice);
						}
					}
				}
			}

			bookList.remove(idx);
			return true;
		}
	}

	public long getAsset() {
		return asset;
	}
	public void setAsset(long asset) {
		this.asset = asset;
	}
}