import java.util.PrimitiveIterator;

public class User {

	private String userName;
	private String phoneNumber;
	private int Money;

	private int ownNum;

	public User (String userName1, String phoneNumber1, int Money1, int ownNum1) {
		this.userName = userName1;
		this.phoneNumber = phoneNumber1;
		this.Money = Money1;
		this.ownNum= ownNum1;
	}

	//폰번호 ( 000-0000-0000 출력 메서드 )
	public String phone_format() {
		String regEx = "(\\d{3})(\\d{3,4})(\\d{4})";
		return this.phoneNumber.replaceAll(regEx, "$1-$2-$3");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName1) {
		this.userName = userName1;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber1) {
		this.phoneNumber = phoneNumber1;
	}

	public int getMoney() {
		return Money;
	}
	public int getOwnNum() {
		return ownNum;
	}

	public void setMoney(int money1) {
		Money += money1;
	}
}
