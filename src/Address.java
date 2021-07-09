
public class Address {
	

	private String streetName;
	
	private int doorNo;
	
	private int PIN_CODE;
	
	private String district;
	
	Address(int doorNo, String streetName, int pin, String district)
	{
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.district = district;
		this.PIN_CODE = pin;
	}
	

}
