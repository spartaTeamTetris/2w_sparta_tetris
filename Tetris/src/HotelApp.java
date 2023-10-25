import java.util.List;

public class HotelApp {

	public static void hotelApp() {
		SetData setData = new SetData();
		setData.setData();

		User spongebob = null;
		for (User user : setData.getUsers()) {
			if (user.getUserName().equals("스폰지밥")) {
				spongebob = user;
				break;
			}
		}
		System.out.println(spongebob.phone_format());
	}

}
