
public enum VEHICLE_TYPE {
	
	SUV(1000),SEDAN(100),MOTOR_CYCLE(10),MPV(1500),TRUCK(3000),VAN(2000);
	
	private int rate;
	
	private VEHICLE_TYPE(int rate)
	{
		this.rate = rate;
	}
	
	public int getRate()
	{
		return this.rate;
	}

}
