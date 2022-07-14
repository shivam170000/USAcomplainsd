package Javaminiproject;

import java.util.Scanner;

public class Bankdetector {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		displayFunctions dis = new displayFunctions();
		dis.loadData();
		System.out.println("Welcome to Complaints DashBoard!");
		System.out.println("Enter your option between 1 to 6");
		System.out.println("1.Display all the complaints based on the year provided by the user ");
		System.out.println("2.Display all the complaints based on the name of the bank provided by the user");
		System.out.println("3.Display complaints based on the complaint id provided by the user ");
		System.out.println("4.Display number of days took by the Bank to close the complaint ");
		System.out.println("5.Display all the complaints closed/closed with explanation ");
		System.out.println("6.Display all the complaints which received a timely response ");
		
		int option = sc.nextInt();
		sc.nextLine();
		switch (option){
			case 1 :
				System.out.println("Enter the year");
				String year = sc.nextLine();
				dis.basedOnYear(year);
				break;
		case 2:
			System.out.println("Enter the name");
			String name = sc.nextLine();
			dis.basedOnCompany(name);
			break;
		case 3:
			System.out.println("Enter the id");
			String id = sc.nextLine();
			dis.basedOnComplaintID(id);
			break;
		case 4:
			System.out.println("Enter the id");
			String compid = sc.nextLine();
			dis.NoOfDaysTOCloseComplaint(compid);
			break;
		case 5 :
			System.out.println("displaying the closed complaints");
			dis.complaintsClosed();
			break;
		case 6:
			System.out.println("displaying complaints which receive a timely response");
			dis.ReceivingTimelyResponse();
			break;
		default:
			System.out.println("invalid choice");
			
	}
		sc.close();

}
}
