import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.jar.JarEntry;

public class HotelApp {

	private final Scanner scanner = new Scanner(System.in);
	private final Hotel hotel = new Hotel();





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

		if(select == 1 ) System.out.println("1. 예약하기");
		if(select == 2) getMyReservation();
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


	public void tmp() {
		System.out.println("예약하기");
		System.out.println("예약을 원하는 날짜를 입력해주세요 ex (20240229");

	}
	public void checkingRooms() {

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
}