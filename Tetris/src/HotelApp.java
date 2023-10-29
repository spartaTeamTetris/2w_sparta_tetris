import java.time.LocalDateTime;
import java.util.*;
import java.util.jar.JarEntry;
import java.text.SimpleDateFormat;

public class HotelApp {


	private final Hotel hotel = new Hotel();

	static Scanner scanner = new Scanner(System.in);





	public void hotelApp() {
		while (true) {
			int select = makeSelect(
					1,
					2,
					"사용자를 선택해주세요.",
					"1. 고객		2. 관리자"
			);

			if(select == 1) userScreen();
			if(select == 2) adminScreen();
		}
	}

	private void userScreen() {
		int select = makeSelect(
					1,
					2,
					"[ 선택하세요 ]",
					"1. 예약하기		2. 예약조회하기"
				);

		if(select == 1 ){
			System.out.println("1. 예약하기");
			makeReservation(userSelect());
		}
		if(select == 2) getMyReservation();
	}


	// 유저를 선택합니다.
	private int userSelect() {

		System.out.println("사용하실 유저를 선택해주세요.");

		int ownNum;

		for (User user : hotel.setData.getUsers()) {
			System.out.println( "번호: " + user.getOwnNum() +
					" | 이름: " + user.getUserName() +
					" | 전화번호: " + user.getPhoneNumber() +
					" | 가진 돈: " + user.getMoney());
		}
		ownNum = Functions.inputStringToInt();

		return ownNum;
	}

	private void getMyReservation() {
		// 예약 번호를 받고 예약 번호를 메서드에 전달해서 uuid랑 일치하는 book 객체를 찾아서 예약 내역을 반환
		// 예약 번호는 숫자만 됨(int bookedNum;)
		System.out.println("[ 예약 정보 ]");
		System.out.println("예약 번호를 입력해주세요 : " );
		String bookedNum = scanner.nextLine(); // 예약 번호 받기

		System.out.print("예약 날짜를 입력해주세요(ex 2023-10-10) : ");
		String date = scanner.nextLine(); // 예약 날짜 받기

		System.out.println("[ 예약 내역 ]\n" + hotel.getBookWithUUID(date, bookedNum));
		// 사용자가 입력한 예약 번호(bookedNum=파라미터)를 getBookWithUUID 메서드로 전달해서
		// UUID와 일치하는 book 객체를 찾아서 반환한다.
		// book 객체 를 받아와서.. 어쩌구저쩌구 get을 사용해서 book.getUsername

		// 1. hotel.getBookWithUUID() 함수를 이용해서 Book객체를 받아온다.
		// 2. 받아온 Book 객체에서 getter를 이용해 출력에 필요한 정보를 저장한다.
		// 3. [예약내역]으로 출력되는 아래줄에 유저에게 제공해야할 정보를 출력한다.
		// 4. 다음 마지막으로, select 로직을 구현한다.

		int select = makeSelect(
				1,
				2,
				"[ 선택하세요. ]",
				"1. 확인		2. 예약 취소"
		);

		if(select == 1) return;
//		if(select == 2) Hotel.cancelBook(); // uuid를 전달해줘야 합니다. -> 어떻게 전달해줘요...? -> cancelBook에서 요구하는 매개변수를 한 번 보고 오심 좋아요
	}

	private void adminScreen() {
		/**
		 * 전체예약조회()
		 * 호텔 현재 상황 조회
		 * */
	}

	//ownNum을 통해 해당 유저의 데이터를 들고감
	public void makeReservation(int ownNum) {
		System.out.println("예약하기");
		System.out.println("예약을 원하는 날짜를 입력해주세요 ex (20240229)");

		Date date = Functions.inputStringToDate();

		System.out.println("숙박 인원을 입력해주세요 ( 최대 8인 )");

		int guest = Functions.inputStringToInt();

		scanner.nextLine();

		showMatchRoom(guest, date);

		//예외 처리로 5명 로직

		// Hotel.showUnoccupiedRooms(date);

		System.out.println("예약을 원하는 방 번호를 입력해주세요.");

		// int 예약하고 싶은 방 넣기 int type

		int roomNum = Functions.inputStringToInt();

		//예약 가능한 방 출력

		payMoney (ownNum, getPrice(roomNum));

		// 이름 번호,

		if (!checkMoney(ownNum, roomNum)) {
			return; // 돈이 부족하면 메서드를 종료합니다.
		}

		String userName = getUserName(ownNum);


		String userPhoneNum = getUserNumber(ownNum);



		makeBook(userName, userPhoneNum, roomNum, date);

		// HOTEL.예약하기 return UUID

		UUID retUUID;

		retUUID= Book.getUUID (date, userName , userPhoneNum);

		System.out.println("고객님의 예약 정보 UUID는 : " + retUUID );
		System.out.println("예약이 완료되었습니다. 초기화면으로 돌아갑니다." + '\n');

	}


	/**
	 * [makeSelect]
	 * sIdx: 첫 선택지 번호
	 * eIdx: 마지막 선택지 번호
	 * title: 선택지 설명
	 * option: 선택지 목록
	 * */
	private int makeSelect(int sIdx, int eIdx, String title, String option) {
		int select;
		while(true) {
			System.out.println(title);
			System.out.println(option + "\n");

			try {
				select = scanner.nextInt();
				if (select < sIdx || select > eIdx) throw new Exception();
				else break;
			} catch (Exception e) {
				System.out.println("다시 입력해주세요!");
			}
		}

		return select;
	}



	private void makeBook(String userName, String userPhoneNum, int roomNum1, Date date1)
	{
		Book newBook = new Book(userPhoneNum, userName, roomNum1, date1);
	}

	private String getString() {

		String str;
		str = scanner.nextLine();
		return str;

	}

	private String getUserName(int ownNum1) {

		for (User user : hotel.setData.getUsers()) {
			if (user.getOwnNum() == ownNum1) {
				return user.getUserName();
			}
		}
		return null; // 일치
}

	private int getUserMoney(int ownNum1) {

		for (User user : hotel.setData.getUsers()) {
			if (user.getOwnNum() == ownNum1) {
				return user.getMoney();
			}
		}
		return -1;
	}


	private String getUserNumber(int ownNum1) {

		for (User user : hotel.setData.getUsers()) {
			if (user.getOwnNum() == ownNum1) {
				return user.getPhoneNumber();
			}
		}
		return null; // 일치
	}

	// 룸 전체를 순회하면서,                   해당 방번호를 출력해줌.
	private void showMatchRoom(int guest, Date date) {
		for (Room room : SetData.getRooms()) {
			if (isRoomAvailableAndSuitable(room, date, guest)) {
				System.out.println("방 번호 : " + room.getRoomNum());
			}
		}
	}

	// 룸 하나당 북 전체를 순회 하면서, 해당 북의 날짜와 방번호가 일치하지 않는다면
	private boolean checkBookOnDate(int roomNum, Date date) {
		for (Book book : Book.getBookList()) {
			if (book.getDate().equals(date) && book.getRoomNumber() == roomNum)
				return true;
		}
		return false;
	}

	// 그 방이 게스트의 숫자보다 수용인원이 높다면
	private boolean isRoomAvailableAndSuitable(Room room, Date date, int guest) {

		if (!checkBookOnDate(room.getRoomNum(), date)) {

			return room.getCapacity() >= guest;
		}
		return false;
	}

	private boolean checkMoney (int ownNum, int roomNum) {

		if ( getUserMoney(ownNum) < getPrice(roomNum)	) {
			System.out.println("헉,,, 돈이 부족하네영");
			return false;
		} else
			return true;
	}

	private int getPrice(int roomNum1) {

		for (Room room : hotel.setData.getRooms()) {
			if (room.getRoomNum() == roomNum1) {
				return room.getRoomPrice();
			}
		}
		return -1;
	}

	private void payMoney (int ownNum, int roomPrice) {

		for (User user : SetData.getUsers()) {
			if (user.getOwnNum() == ownNum)
				user.setMoney((roomPrice) * -1);
		}

	}

}