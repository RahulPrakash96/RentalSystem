
public class RentedVehicle implements Comparable<RentedVehicle>{
	
	private int time;
	private Vehicle vehicle;
	private User user;
	
	@Override
	public int compareTo(RentedVehicle o) {
		
		return Integer.compare(this.time, o.time);
	}
	
	
	public RentedVehicle(int time,Vehicle vehicle, User user)
	{
		this.time = time;
		this.vehicle = vehicle;
		this.user = user;
	}
	
	public int getTime()
	{
		return this.time;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}
}
