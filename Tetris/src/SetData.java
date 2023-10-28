import java.util.ArrayList;
import java.util.List;

public class SetData {

	private final List<User> userArrayList = new ArrayList<>();
	private final List<Room> roomArrayList = new ArrayList<>();

	public void setData() {
		setUser("스폰지밥", "01012345678", 1000000);
		setUser("뚱이", "22223333", 2500000);
		setUser("징징이", "5438555", 5000000);

		setRoom(1, 1, 50000, RoomType.SINGLE);
		setRoom(2, 2, 100000, RoomType.DOUBLE);
		setRoom(1, 3, 300000,RoomType.SUITE);
	}

	public void setUser(String userName1, String phoneNumber1, int money1) {
		User user = new User(userName1, phoneNumber1, money1);
		userArrayList.add(user);
	}

	public void setRoom(int roomfloor1, int roomNum1, int roomPrice1, RoomType roomType1) {
		Room room = new Room(roomfloor1, roomNum1, roomPrice1, roomType1);
		roomArrayList.add(room);
	}
	public List<Room> getRooms() { return roomArrayList; }
	public List<User> getUsers() {
		return userArrayList;
	}
}
