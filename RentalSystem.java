import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class RentalSystem {
	
	private static RentalSystem rentalSystem;
	
	public static RentalSystem getInstance()
	{
		if(rentalSystem == null)
		{
			rentalSystem = new RentalSystem();
		}
		
		return rentalSystem;
	}
	private RentalSystem()
	{
		availableVehicles = Repository.addVehicles();
		members = Repository.addUsers();
		parkingSlots = Repository.addSlots();
	}
	
	HashMap<Integer,Vehicle> availableVehicles;
	
	HashMap<Integer,User> members;
	
	List<Integer> parkingSlots;
	
	PriorityQueue<RentedVehicle> rentedVehicles;
	
	
	public void showAvailableVehicles()
	{
		
		int currentTime = 0;// Getting current time and pull back all the available vehicles back to the list;
			
		
		while(currentTime > rentedVehicles.peek().getTime())
		{
			Vehicle v = rentedVehicles.poll().getVehicle();
			v.setStatus(STATUS.AVAILABLE);
	
			int slotNumber = parkingSlots.get(parkingSlots.size()-1);
			parkingSlots.remove(parkingSlots.size()-1);
			
			v.setSlotNo(slotNumber);
			
			availableVehicles.put(v.getVehicleNo(), v);
		}
		
		for(Vehicle v : availableVehicles.values())
		{
			System.out.println(v);
		}
	}
	
	public boolean BookVehicle(int id, int from, int timeFrame, int userId)
	{
		Vehicle vehicle = availableVehicles.get(id);
		User user = members.get(userId);
		if(vehicle == null)
		{
			System.out.println("Please check the available vehicles list in the catalog");
			return false;
		}
		
		if(user == null)
		{
			System.out.println("Invalid User Credentials");
			return false;
		}
		addToRentedVehicles(from+timeFrame, vehicle, user);
		
		return true;
	}
	
	private void addToRentedVehicles(int time, Vehicle vehicle, User user)
	{
		rentedVehicles.add(new RentedVehicle(time,vehicle,user));
		parkingSlots.add(vehicle.getSlotNo());
		vehicle.setStatus(STATUS.NOT_AVAILABLE);	
	}

	public int calculatePrice(int vehicleNo, int fromTime, int toTime) {
		// TODO Auto-generated method stub
		return availableVehicles.get(vehicleNo).getType().getRate()*(toTime - fromTime);
	}
	
	

}
