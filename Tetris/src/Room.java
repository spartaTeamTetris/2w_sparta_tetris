import java.util.HashMap;
import java.util.Map;

public class Room {

	private int roomNum;
	private int roomPrice;
	private RoomType roomType;
	public Room (int roomNum1, int roomPrice1, RoomType roomType1) {

		this.roomNum = roomNum1;
		this.roomPrice = roomPrice1;
		this.roomType = roomType1;

	}
	
	public int getRoomNum() {
		return roomNum;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomNum(int roomNum1) {
		this.roomNum = roomNum1;
	}

	public void setRoomPrice(int roomPrice1) {
		this.roomPrice = roomPrice1;
	}

	public void setRoomType(RoomType roomType1) {
		this.roomType = roomType1;
	}

	public int getCapacity() {	return roomType.getCapacity();	}





}
