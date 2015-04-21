package testAzureSql;

//import mycommons.db.connection.Connection;

public class TransferFromLocalToAzure {

	private mycommons.db.connection.Connection connectionLocal=null;
	private mycommons.db.connection.Connection connectionRemote=null;
	
	private java.sql.Statement statementLocal=null;
	private java.sql.Statement statementRemote=null;
	
	private java.sql.ResultSet rstLocal=null;
	
	//constructors
	
	//constructor no.1
	//constructor(para local,para remote)
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){
		this.ConstructorCommon(in_paraLocal, in_paraRemote);
	}
	//constructor no.2
	//constructor(para local,connection string remote,para local)
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ConnectionString in_connectionStringRemote,mycommons.db.connection.ParaConnection in_paraRemote){
		this.ConstructorCommon(in_paraLocal, in_connectionStringRemote, in_paraRemote);
	}
	/***
	public TransferFromLocalToAzure(){

	}
	***/
	//methods private
	
	//constructor common
	private void ConstructorCommon(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_paraRemote);

	}
	private void ConstructorCommon(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ConnectionString in_connectionStringRemote,mycommons.db.connection.ParaConnection in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_connectionStringRemote,in_paraRemote);
	}

	private void TransferCommon(mycommons.db.connection.Connection in_connectionLocal,mycommons.db.connection.Connection in_connectionRemote){
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
	public void Transfer(mycommons.db.Table fromTable,mycommons.db.Table toTable){

		mycommons.routines.db.Manipulate.DeleteTable(this.connectionRemote, toTable);
		
	}
	
}
