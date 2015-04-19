package testAzureSql;

public class MainTestParaConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("start main.");
		
		mycommons.db.connection.ParaConnection paraDBConnection=new mycommons.db.connection.ParaConnection();
		mycommons.db.connection.Connection DBConnection=new mycommons.db.connection.Connection(paraDBConnection);
		System.out.println("connection string is "+paraDBConnection.getConnectionString().getConnectionString());
		System.out.println("db connection is "+DBConnection.toString());
		if(DBConnection.getConnection()==null){
			System.out.println("connection is null.");
		}else{
			System.out.println("connection"+DBConnection.getConnection().toString());
		}
		System.out.println("end main.");
	}

}
