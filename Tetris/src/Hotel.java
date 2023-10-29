import java.util.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class Hotel {

	private List<Room> rooms; //*

	Book book;



	final SetData setData;
	final String name = "데일리 여기 어떤 비앤비 ~ ?";

	// 예약 배열
	private final Map<Date, Book[][]> bookArray = new HashMap<>();

	// 총 5층 , 층마다 5개의 방
	final int roomFloor = 5;
	final int roomNum = 5;

	public Hotel() {
		setData = new SetData();
		setData.setData();
	}

	public List<Room> getRooms() {
		return setData.getRooms();
	}

	public Book getBookWithUUID(Date date, String uuid) {
		Book[][] findBooks = bookArray.get(date);
		int[] idx = findBook(uuid, findBooks);

		if(idx == null) return null;
		else return findBooks[idx[0]][idx[1]];
	}

	public boolean cancelBook(Date date, String uuid) {
		Book[][] findBooks = bookArray.get(date);

		int[] idx = findBook(uuid, findBooks);
		if(idx == null) return false;
		else findBooks[idx[0]][idx[1]] = null;

		//
		return true;
	}

	private int[] findBook(String uuid, Book[][] findBooks) {
		UUID code;
		try {
			code = UUID.fromString(uuid);
		} catch (IllegalArgumentException e) {
			return null;
		}

		for(int i=0; i<findBooks.length; i++) {
			for (int j=0; j<findBooks[i].length; j++) {
				if(findBooks[i][j].getUUID().equals(code)) {
					int[] idx = new int[2];
					idx[0] = i;
					idx[1] = j;
					return idx;

				}
			}
		}

		return null;
	}
}