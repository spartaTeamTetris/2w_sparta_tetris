import java.util.*;

public class Hotel {

	private List<Room> rooms; //*



	final SetData setData;
	final String name = "데일리 여기 어떤 비앤비 ~ ?";

	// 예약 배열
	static Map<Date, Book[][]> bookArray = new HashMap<>();
	private


	// 총 5층 , 층마다 5개의 방
	final int roomFloor = 5;
	final int roomNum = 5;

	/*
	* Book이나 Room 객체 안에 Date를 넣는다.
	* 이 Date를 어떻게 저장하나요??
	* Room room -> room.setDate(date);
	*
	* 조회시점
	* readBook(date)
	* for
	* */
	//


//	Map<Date, > book

	public Hotel() {
		setData = new SetData();
		setData.setData();
	}

	public List<Room> getRooms() {
		return setData.getRooms();
	}

	public Book getBookWithUUID(String date, String uuid) {
		//1. 전달받은 data를 혁님, 민성님이 정해놓은 Date format에 맞춰 Date 객체로 변환한다. 힌트 없음 ㅋㅋ
		Date convertDate = Functions.inputStringToDate();


		//2. 전달받은 uuid를 UUID 객체로 변환한다. hint -> UUID.fromString을 이용
		UUID uuid1 = UUID.fromString(uuid);


		//3. 변환한 Date를 key값으로 이용해 bookArray에 접근한다. hint -> bookArray.get() 함수를 이용
		for (Map.Entry<Date, Book[][]> books : bookArray.entrySet()) {
			// bookArray 의 모든 Key-Value를 가져와서 반복한다. entrySet()은 Key-Value 쌍을 담고 있는 Set 을 반환한다.

			Book[][] book1 = books.getValue();

			for (int i = 0; i < book1.length; i++) {
				for (int j = 0; j < book1[i].length; j++) {
					Book book = book1[i][j];

					//4. 변환한 UUID 값으로 접근한 Book[][] 배열에서 UUID값과 일치하는 Book객체를 찾는다.
					if (book.equals(uuid1)) {

						//5. 일치하는 Book 객체가 있다면 반복문을 중단하고 해당 객체를 return 한다.
						return book;
					}
				}
			}
		}
		return null;
	}

	public boolean cancelBook(String date, String uuid) {
		//1. 전달받은 date와 uuid는 getBookWithUUID() 함수와 마찬가지로 변환 해주셔야 해요
		//2. 또, 마찬가지로 해당하는 Book객체를 반복문을 이용해서 찾으시면 됩니다.
		//3. 조건에 맞는 Book 객체가 있다면 그 값을 null로 바꿔주시면 돼요 findBook = null; 이렇게
		//4. 조건에 맞는 Book 객체를 정상적으로 찾아서 삭제했다면 true를 return하고
		//5. 그럴 일은 없겠지만, 과정 중 문제가 발생했다면(ex) 해당 날짜에 조건과 일치하는Book이 없다) false를 return 해주시면 됩니다.
		//화이팅 하세요 유진님!
		// 감사합니다 팀장님 퇴근하셔도 됩니다!
		return false;
	}







}