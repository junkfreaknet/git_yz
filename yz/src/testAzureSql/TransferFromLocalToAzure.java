package testAzureSql;

//import mycommons.db.connection.Connection;

public class TransferFromLocalToAzure {

	//private java.sql.Connection connectionLocal;
	//private java.sql.Connection connectionRemote;
	private mycommons.db.connection.Connection connectionLocal;
	private mycommons.db.connection.Connection connectionRemote;
	
	private java.sql.Statement statementLocal;
	private java.sql.Statement statementRemote;
	
	//constructors
	
	//constructor no.1
	//get paramaters for connecting to local and remote db servers.
	//and initialize connection.
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection paraLocal,mycommons.db.connection.ParaConnection paraRemote){
		this.ConstructorCommon(paraLocal, paraRemote);
	}
	
	//methods private
	
	//constructor common
	private void ConstructorCommon(mycommons.db.connection.ParaConnection paraLocal,mycommons.db.connection.ParaConnection paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(paraRemote.getConnectionString(),paraRemote);
		System.out.println("class debugging.");
		System.out.println("local for name is "+paraLocal.getForName().toStringValue());
		System.out.println("local password is "+paraLocal.getPassWord().toStringValue());
		System.out.println("class debugging end.");
	}
	//initiate connection to database
	/***
	private void initDB(){
		
	}
	**/
	
	//methods public
	
	//transfer table
	//local ---> azure
	public void Transfer(mycommons.db.Table fromTable){
	
		try{
		
			//java.sql.Connection con=this.connectionLocal.getConnection();
			this.statementLocal=this.connectionLocal.getConnection().createStatement();
			this.statementRemote=this.connectionRemote.getConnection().createStatement();
		
		}catch(Exception e){

			System.out.println("Statement for Local DB failed.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
	}
	
}
