import java.util.ArrayList;
import java.util.List;

public class SetData {

	private static final List<User> userArrayList = new ArrayList<>();
	private static final List<Room> roomArrayList = new ArrayList<>();

	public void setData() {
		setUser("스폰지밥", "01012345678", 1000000, 1);
		setUser("뚱이", "22223333", 2500000,2 );
		setUser("징징이", "5438555", 5000000,3);

		setRoom(1, 10000, RoomType.SINGLE);
		setRoom( 2, 20000, RoomType.DOUBLE);
		setRoom(3, 30000,RoomType.SUITE);
		setRoom(4, 40000, RoomType.TWIN);
		setRoom( 5, 50000, RoomType.FAMILY);
		setRoom(6, 60000,RoomType.FAMILY);
		setRoom(7, 70000, RoomType.TRIPLE);
		setRoom( 8, 80000, RoomType.SINGLE);
		setRoom(9, 90000,RoomType.SUITE);
	}

	public void setUser(String userName1, String phoneNumber1, int money1, int ownNum1) {
		User user = new User(userName1, phoneNumber1, money1, ownNum1);
		userArrayList.add(user);
	}

	public void setRoom(int roomNum1, int roomPrice1, RoomType roomType1) {
		Room room = new Room(roomNum1,roomPrice1,roomType1);
		roomArrayList.add(room);
	}
	public static List<Room> getRooms() { return roomArrayList; }
	public static List<User> getUsers() {
		return userArrayList;
	}
}
