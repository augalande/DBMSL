import java.util.*;
import java.sql.*;

public class asgmt08{
	public static void main(String args[])
	{
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demoasgmt08","root","aruaryan98");
		Statement statement=connection.createStatement(); //VV imp .createStatement()
		
		Scanner in=new Scanner(System.in);
		ResultSet result;
		
		while(true)
		{
			System.out.println("---------------------------------------------------------------");
			System.out.println("MySQL Database Connectivity");
			System.out.println("1) Create a Table");
			System.out.println("2) Insert into Table");
			System.out.println("3) Display Table");
			System.out.println("4) Update Table");
			System.out.println("5) Delete from Table");
			System.out.println("6) Exit");
			System.out.println("Enter Your Choice:");
			System.out.println("---------------------------------------------------------------");
			int c=in.nextInt();
			
			if(c==1)
			{
				String create="create table if not exists data(id int,name varchar(255));";
				statement.executeUpdate(create);
				System.out.println("Table Created!!");
			}
			else if(c==2)
			{
				System.out.println("Enter id and name: ");
				String id,name;
				id=in.next();
				name=in.next();
				
				String insert="insert into data values("+id+","+"'"+name+"');";
				statement.executeUpdate(insert);
				System.out.println("Inserted Sucessfully!!");
			}
			else if(c==3)
			{
				String print="select * from data;";
				result=statement.executeQuery(print);
				
				while(result.next())
				{
					System.out.print("Id: "+result.getString("id"));
					System.out.print(" ");
					System.out.println("Name: "+result.getString("name"));
					System.out.println("Displayed Sucessfully!!");
				}
				
			}
			else if(c==4)
			{
				System.out.println("Enter id to be updated: ");
				String id,name;
				id=in.next();
				System.out.println("Enter New Name: ");
				name=in.next();
				
				String update="update data set name="+"'"+name+"'"+" where id="+id+";";
				
				statement.executeUpdate(update);	
				System.out.println("Updated Sucessfully!!");
			}
			else if(c==5)
			{
				System.out.println("Enter id to be deleted: ");
				String id;
				id=in.next();
				
				String delete="delete from data where id="+id+";";
				statement.executeUpdate(delete);	
				System.out.println("Deleted Sucessfully!!");
			}
			else 
			{
				System.out.println("Exited Sucessfully!!");
				break;
			}
		}
		}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
