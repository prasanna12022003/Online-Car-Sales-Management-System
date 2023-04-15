package project;
import java.sql.ResultSet;
import java.util.*;
public class Admin extends Customer{
	String id="001";
	String pass="12345";
	void login() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id");
		String id=sc.nextLine();
		System.out.println("Enter your Password");
		String pass=sc.nextLine();
		if(id.equals(this.id) && pass.equals(this.pass)) 
		{
			Admin ob=new Admin();
			ob.menu();
		}
		else
		{
			System.out.println("Invalid Login.....");
			Customer cs=new Customer();
			cs.mainlogin();
		}
		sc.close();
	}
	void menu() throws Exception
	{
			Admin a=new Admin();
			System.out.print("--------------------");
	    	System.out.println("\n1.Add Car ");
			System.out.println("2.View All Car ");
			System.out.println("3.Exit ");
			System.out.println("--------------------");
			System.out.print("Enter your choice: ");
			int num=sc.nextInt();
			if(num==1)
			{
				System.out.println("Total Number Of Cars To Be Added : ");
				int num1=sc.nextInt();
				sc.nextLine();
				for(int i=1;i<=num1;i++)
				{
					System.out.println("Enter Car Name : ");
					String cname=sc.nextLine();
					System.out.println("Enter Car Model : ");
					String mod=sc.nextLine();
					System.out.println("Enter No.of Owner : ");
					String own=sc.nextLine();
					System.out.println("Enter Km_Driven : ");
					String km=sc.nextLine();
					System.out.println("Enter Car Price : ");
					String pri=sc.nextLine();
					String query="Insert into car (Car_name,Model,OwnerShip,Km_Driven,Price)values('"+cname+"','"+mod+"','"+own+"','"+km+"','"+pri+"')";
					st.executeUpdate(query);
				}
				System.out.println("New Car Added Succeccfully.....");
				a.menu();
			}
			else if(num==2)
			{
				String query="Select * from car";
				ResultSet rs=st.executeQuery(query);
				System.out.println("Car Id:\t\tCar Name:\tCar Model:\tCar OwnwerShip:\t Car Km_Driven:\t Car Price:");
				while(rs.next())
				{
					String cid=rs.getString(1);
					String cn=rs.getString(2);
					String cm=rs.getString(3);
					String co=rs.getString(4);
					String ck=rs.getString(5);
					String cp=rs.getString(6); 
					System.out.println(cid+"\t\t"+cn+"\t\t"+cm+"\t\t"+co+"\t\t "+ck+"\t\t "+cp);
				}
				System.out.println("Available Car Has Been Displayed.....");
				a.menu();
			}
			else if(num==3)
			{
				Customer cs=new Customer();
				cs.mainlogin();
			}
		}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Admin obj1=new Admin();
		obj1.login();
	}

}