
public class Vehicle {
	
	private int vehicleNo;

	private VehicleType type;
	
	private STATUS status;
	
	private int slotNo;
	
	public Vehicle(int no, VehicleType type, STATUS status)
	{
		this.type = type;
		this.vehicleNo = no;
		this.setStatus(status);
	}

	public int getVehicleNo() {
		return vehicleNo;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public VehicleType getType() {
		return type;
	}

	@Override
	public String toString() {
		
		return this.vehicleNo+" of type "+this.type+" is available at "+this.slotNo;
	}

}
