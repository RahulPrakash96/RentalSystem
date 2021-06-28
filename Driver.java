import java.util.Scanner;

public class Driver {

	public static void main()
	{
		boolean alive = true;
		int option;
		RentalSystem rentalSystem = RentalSystem.getInstance();
		Scanner sc = new Scanner(System.in);
		while(alive)
		{
			System.out.print("1. Show Available Vehicle");
			System.out.print("2. Rent Vehicle");
			System.out.print("3. Exit");
			
			option = sc.nextInt();
			
			switch(option)
			{
			case 1 : rentalSystem.showAvailableVehicles(); break;
			case 2 : System.out.println("Enter the vehicle number");
					 int vehicleNo = sc.nextInt();
					 System.out.println("Enter the User Id");
					 int userId = sc.nextInt();
					 System.out.println("Enter from time");
					 int fromTime = sc.nextInt();
					 System.out.println("Enter to time");
					 int toTime = sc.nextInt();
					 int amountToPay = rentalSystem.calculatePrice(vehicleNo,fromTime,toTime);
					 
					 // If the amount is paid then we can call BookVehicle method;
					 boolean status = rentalSystem.BookVehicle(vehicleNo, fromTime, toTime, userId);
					 if(status)
					 {
						 System.out.print("Vehilce booked sucessfully");
					 }
					 else
					 {
						 System.out.print("Unable to handle your request");
					 }
					 break;
			case 3 : alive = false; break;
					 
			}
		}
	}
}
