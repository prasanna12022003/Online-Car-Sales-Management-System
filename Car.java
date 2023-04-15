package project;
import java.sql.ResultSet;
public class Car extends Customer{
	void cardisp() throws Exception
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
	}
	void buycar() throws Exception
	{
		System.out.println("\nEnter The Car Id: ");
		String ci=sc.nextLine();
		String query="select Car_name from car where Car_id='"+ci+"'";
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			String cna=rs.getString(1);
			System.out.println("Congrats You have Bought "+cna+" Car SuccessFully ");
			String query1="Delete from car where Car_id='"+ci+"'";
			st.executeUpdate(query1);
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Customer obj=new Customer ();
		//obj.customerlogin();	
	}
}