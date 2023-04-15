package project;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Customer extends Connection_Establishment {
	Scanner sc = new Scanner(System.in);
	String pass;
	int id;
	void customerlogin() throws Exception{
		Car obj2=new Car();
		System.out.println("\nEnter your ID");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your password");
		String pass = sc.nextLine();
		String query = "Select*from customer where id='"+id+"' AND password ='"+pass+"'";
		try {
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				this.id=id;
				this.pass=pass;
				System.out.print("----------------------------------------------------------------------------------------\n");
				obj2.cardisp();
				System.out.print("----------------------------------------------------------------------------------------");
				System.out.println("\nEnter 1 to Buy Car or Enter 0 to exit.......");
				System.out.print("Enter your choice: ");
				int cho=sc.nextInt();
				sc.nextLine();
				if(cho==1)
				{
					obj2.buycar();
				}
				else {
					System.out.print("ThankYou Vist Again.......");
				}
			}
		}catch(SQLException e) {
		
		}
	}void customersignup() throws Exception{
			System.out.println("Enter Your Name");
			String name1=sc.nextLine();
			System.out.println("Enter Your PhoneNumber");
			String phno1=sc.nextLine();
			if(phno1.length()!=10)
			{
				System.out.println("Invalid PhoneNumber....");
				customersignup();
			}
			System.out.println("Enter Your Password");
			String pass1=sc.nextLine();
			if(pass1.length()<8)
			{
				System.out.println("Password is Weak.....");
				customersignup();
			}
			String query="Insert into customer (Name,PhoneNumber,Password)values('"+name1+"','"+phno1+"','"+pass1+"')";
			int res=st.executeUpdate(query);
			if(res==1) {
				System.out.print("--------------------");
				System.out.println("\nSignup Successfull");
				String query1="Select * from customer where PhoneNumber='"+phno1+"' and name='"+name1+"'";
				System.out.println("Note Your ID and PassWord Carefully");
				ResultSet rs1=st.executeQuery(query1);
				if(rs1.next())
				{
					System.out.println("Your ID is "+rs1.getInt(1));
					System.out.println("Your PassWord is "+rs1.getString(4));
					System.out.print("--------------------");
					customerlogin();
				}
			}
			else {
				System.out.println("Invalid signup");
				customersignup();
			}
		}
		void mainlogin() throws Exception
		{
			System.out.print("--------------------");
	    	System.out.println("\n1.Admin ");
			System.out.println("2.Login ");
			System.out.println("3.Signup ");
			System.out.println("--------------------");
			System.out.print("Enter your choice: ");
			int num=sc.nextInt();
			if(num==1)
			{
				Admin obj1=new Admin();
				obj1.login();
			}
			else if(num==2)
			{
				Customer obj1=new Customer();
				obj1.customerlogin();
			}
			else if(num==3) 
			{
				Customer obj1=new Customer();
				obj1.customersignup();
			}
			sc.close();
		}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection_Establishment obj=new Connection_Establishment ();
		obj.connect();
		Customer cs=new Customer();
		cs.mainlogin();
		sc.close();
	}
}