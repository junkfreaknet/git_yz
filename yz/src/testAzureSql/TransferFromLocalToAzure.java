package testAzureSql;

//import mycommons.db.connection.Connection;

public class TransferFromLocalToAzure {

	//private java.sql.Connection connectionLocal;
	//private java.sql.Connection connectionRemote;
	private mycommons.db.connection.Connection connectionLocal=null;
	private mycommons.db.connection.Connection connectionRemote=null;
	
	private mycommons.db.connection.ParaConnection paraLocal=null;
	private mycommons.db.connection.ParaConnection paraRemote=null;
	
	private java.sql.Statement statementLocal=null;
	private java.sql.Statement statementRemote=null;
	
	private java.sql.ResultSet rstLocal=null;
	
	//constructors
	
	//constructor no.1
	//get paramaters for connecting to local and remote db servers.
	//and initialize connection.
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){
		this.ConstructorCommon(in_paraLocal, in_paraRemote);
	}
	public TransferFromLocalToAzure(){

	}
	//methods private
	
	//constructor common
	private void ConstructorCommon(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_paraRemote.getConnectionString(),in_paraRemote);
		this.paraLocal=in_paraLocal;
		this.paraRemote=in_paraRemote;
		
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
	public void Transfer(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){

		
		mycommons.db.connection.Connection connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		mycommons.db.connection.Connection connectionRemote=new mycommons.db.connection.Connection(in_paraRemote.getConnectionString(), in_paraRemote);
		
		if(connectionLocal.getConnection()==null){
			System.out.println("local connection is null.");
		}
		if(connectionRemote.getConnection()==null){
			System.out.println("remote connection is null.");
		}
		if(connectionLocal.getConnection()==null || connectionRemote.getConnection()==null){
			System.out.println("exit program.");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		try{
			this.statementLocal=connectionLocal.getConnection().createStatement();
			this.statementRemote=connectionRemote.getConnection().createStatement();
			this.rstLocal=this.statementLocal.executeQuery("select * from dbo.tbl_outfile;");
			while(rstLocal.next()){
				
			}
			//this.statementRemote.execute("");
			System.out.println("ok");
		}catch(Exception e){
			System.out.println("ng");
			System.out.println(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			
		}
	}
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
