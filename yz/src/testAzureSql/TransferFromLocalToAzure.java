package testAzureSql;

import mycommons.db.FieldName;
import mycommons.db.FieldType;

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
	
	//constructor common no.1.
	private void ConstructorCommon(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ParaConnection in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_paraRemote);

	}
	//constructor commons no.2
	private void ConstructorCommon(mycommons.db.connection.ParaConnection in_paraLocal,mycommons.db.connection.ConnectionString in_connectionStringRemote,mycommons.db.connection.ParaConnection in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_connectionStringRemote,in_paraRemote);
	}

	//*****
	//***** private methods start
	//*****
	
	//common transfer table common.
	private void TransferCommon(mycommons.db.Table fromTable,mycommons.db.Table toTable){
		try{
			this.statementLocal=connectionLocal.getConnection().createStatement();
			this.statementRemote=connectionRemote.getConnection().createStatement();
			this.rstLocal=this.statementLocal.executeQuery("select * from "+fromTable.getName());
			
			java.util.ArrayList<mycommons.db.Field> fields=this.getFields(rstLocal);
			//
			for(int i=0;i<fields.size();i++){
				mycommons.db.Field fld=new mycommons.db.Field();
				fld=fields.get(i);
				System.out.println("name is "+fld.getName().getName());
				System.out.println("type is "+fld.getType().getType());
			}
			//
			int i=0;
			
			while(rstLocal.next()){

				
				i=i++;
				if(i>100){
					break;
				}
			}
			//this.statementRemote.execute("");
			mycommons.logging.Logging.info("ok");
		}catch(Exception e){
			//System.out.println("ng");	//*****
			//***** public methods end
			//*****
			//System.out.println(e.toString());
			mycommons.logging.Logging.severe("failed in trasfering from local to remote.stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			
		}		
	}

	//*****
	//***** private methods end
	//*****
	
	private java.util.ArrayList<mycommons.db.Field> getFields(java.sql.ResultSet in_resultset){
		
		java.util.ArrayList<mycommons.db.Field> rv=new java.util.ArrayList<mycommons.db.Field>();
		
		try{
			java.sql.ResultSetMetaData rstMD=in_resultset.getMetaData();
			//System.out.println("column count is "+rstMD.getColumnCount());
			for(int i=mycommons.constants.DB.RESULTSET_INDEX_START_VALUE;i<=rstMD.getColumnCount();i++){
				//System.out.println("i is "+i);
				System.out.println("name is "+rstMD.getColumnTypeName(i));
				mycommons.db.Field fld=new mycommons.db.Field();
				fld.setName(new mycommons.db.FieldName(rstMD.getColumnName(i)));
				fld.setType(new mycommons.db.FieldType(rstMD.getColumnType(i)));
				rv.add(fld);
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe("failed in get result set meta data. stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
	
	
	//*****
	//***** public methods start
	//*****
	
	//transfer table.
	public void Transfer(mycommons.db.Table fromTable,mycommons.db.Table toTable){

		mycommons.routines.db.Manipulate.DeleteTable(this.connectionRemote, toTable);
		this.TransferCommon(fromTable, toTable);
	}
	
	//*****
	//***** public methods end
	//*****
}
