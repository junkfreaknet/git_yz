package testAzureSql;

//import mycommons.db.connection.Connection;

public class TransferFromLocalToAzure {

	//private java.sql.Connection connectionLocal;
	//private java.sql.Connection connectionRemote;
	private mycommons.db.connection.Connection connectionLocal;
	private mycommons.db.connection.Connection connectionRemote;
	
	private mycommons.db.connection.ParaConnection paraLocal;
	private mycommons.db.connection.ParaConnection paraRemote;
	
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
		System.out.println("*****constructor success local connection.*****");
		this.connectionRemote=new mycommons.db.connection.Connection(paraRemote.getConnectionString(),paraRemote);
		System.out.println("*****constructor success remote connection.*****");
		System.out.println("class debugging.");
		//System.out.println("local for name is "+paraLocal.getForName().toStringValue());
		//System.out.println("local password is "+paraLocal.getPassWord().toStringValue());
		this.paraLocal=paraLocal;
		this.paraRemote=paraRemote;
		
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
			System.out.println("local connection string is "+this.paraLocal.getConnectionString().getConnectionString());
			this.statementLocal=this.connectionLocal.getConnection().createStatement();
			//this.statementLocal=con.createStatement();
			System.out.println("***** transfer success local connection.*****");
			this.statementRemote=this.connectionRemote.getConnection().createStatement();
			System.out.println("***** transfer success remote connection.*****");
		}catch(Exception e){

			//System.out.println("Statement for Local DB failed.");
			//System.out.println(""+this.connectionLocal.toString());
			System.out.println("failed in statement.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
	}
	
}
