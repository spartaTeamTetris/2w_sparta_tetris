import java.time.LocalDateTime;
import java.util.*;
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
		System.out.println("[ 예약 정보 ]");
		System.out.println("예약 번호를 입력해주세요 : " );
		String bookedNum = scanner.nextLine();

		// 아래 코드에서 inputStringToDate()를 사용하면 예약 번호 입력이 되지 않는 문제 발생.
		// 다른 scanner 객체를 이용해서 그런가..
//		System.out.print("예약 날짜를 입력해주세요(ex 2023-10-10) : ");
//		String date = scanner.nextLine();
		Date date = Functions.inputStringToDate();

		Book findBook = hotel.getBookWithUUID(date, bookedNum);
		if(findBook == null) {
			System.out.println("일치하는 예약 정보가 없습니다.");
			return;
		}

		System.out.println("[ 예약 내역 ]");
		//TODO

		int select = makeSelect(
				1,
				2,
				"[ 선택하세요. ]",
				"1. 확인		2. 예약 취소"
		);

		if(select == 1) return;
		if(select == 2) {
			if(hotel.cancelBook(date, bookedNum)) System.out.println("예약이 취소되었습니다.");
			else System.out.println("예약을 취소하지 못했습니다. 다시 시도해주세요.");
		}
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