package testAzureSql;

//import mycommons.db.FieldLength;
//import mycommons.db.FieldName;
//import mycommons.db.FieldType;
//import mycommons.db.IsFieldNullable;

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
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection para_in_paraLocal,mycommons.db.connection.ParaConnection para_in_paraRemote){
		this.ConstructorCommon(para_in_paraLocal, para_in_paraRemote);
	}
	//constructor no.2
	//constructor(para local,connection string remote,para local)
	public TransferFromLocalToAzure(mycommons.db.connection.ParaConnection para_in_paraLocal,mycommons.db.connection.ConnectionString para_in_connectionStringRemote,mycommons.db.connection.ParaConnection para_in_paraRemote){
		this.ConstructorCommon(para_in_paraLocal, para_in_connectionStringRemote, para_in_paraRemote);
	}
	/***
	public TransferFromLocalToAzure(){

	}
	***/
	//methods private
	
	//constructor common no.1.
	private void ConstructorCommon(mycommons.db.connection.ParaConnection para_in_paraLocal,mycommons.db.connection.ParaConnection para_in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(para_in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(para_in_paraRemote);

	}
	//constructor commons no.2
	private void ConstructorCommon(mycommons.db.connection.ParaConnection para_in_paraLocal,mycommons.db.connection.ConnectionString in_connectionStringRemote,mycommons.db.connection.ParaConnection para_in_paraRemote){
		
		this.connectionLocal=new mycommons.db.connection.Connection(para_in_paraLocal);
		this.connectionRemote=new mycommons.db.connection.Connection(in_connectionStringRemote,para_in_paraRemote);
	}

	//*****
	//***** private methods start
	//*****
	
	//common transfer table common.
	private void TransferCommon(mycommons.db.Table para_fromTable,mycommons.db.Table para_toTable){
		try{
			
			this.statementLocal=connectionLocal.getConnection().createStatement();
			this.statementRemote=connectionRemote.getConnection().createStatement();
			this.rstLocal=this.statementLocal.executeQuery("select * from "+para_fromTable.getName());
			
			//get fields
			java.util.ArrayList<mycommons.db.Field> fields=mycommons.routines.db.Generic.getFields(rstLocal);
			//create table
			//mycommons.routines.db.Manipulate.DeleteTable(connectionRemote, para_toTable);
			//mycommons.routines.db.Definition.createTable(statementRemote, para_toTable, fields);
			mycommons.routines.db.Definition.createTable(connectionRemote, para_toTable, fields);
			// test fields start
			/***
			for(int i=0;i<fields.size();i++){
				mycommons.db.Field fld=new mycommons.db.Field();
				fld=fields.get(i);
				System.out.println((i+1)+" name is "+fld.getName().getName());
				System.out.println("type is "+fld.getType().getType());
				System.out.println("length is "+fld.getLength().getLength());
				System.out.println("type sql is "+fld.getTypeSQL().getTypeSQLString(fld.getType()));
				String buff=mycommons.constants.Generic.CS_SPACE;
				if(fld.getIsNullable().getIsNullale()==java.sql.ResultSetMetaData.columnNoNulls){
					buff="null not abelable.";
				}
				if(fld.getIsNullable().getIsNullale()==java.sql.ResultSetMetaData.columnNullable){
					buff="null is ok.";
				}
				if(fld.getIsNullable().getIsNullale()==java.sql.ResultSetMetaData.columnNullableUnknown){
					buff="ok or not is unknown.";
				}
				System.out.println(buff);
			}
			***/
			//test fields end
			
			//create remote table at here
			//mycommons.db.SQLString sqlobj=mycommons.routines.db.Definition.createSqlStringCreateTable(para_toTable, fields);
			//System.out.println(sqlobj.toString());
			//statementRemote.execute(sqlobj.toString());

			// add records to remote
			int i=0;
			//Integer j=1;
			while(rstLocal.next()){

				//mycommons.routines.db.Manipulate.insertRecord(statementRemote, para_toTable, fields, rstLocal);
				mycommons.routines.db.Manipulate.insertRecord(statementRemote, para_toTable, rstLocal);				
				
				i=i+1;
				
				if((i%1000)==0){
					System.out.println("add "+Integer.toString(i));
				}				
				//if(mycommons.routines.generic.Compare.isEqual(i, 0)){
				
				
				if(i==10000){	
					System.out.println("exit program. cause by limiter.");
					break;
				}
				//459803
				

			}

			// at last. end.
			mycommons.logging.Logging.info("ok");
		}catch(Exception e){

			mycommons.logging.Logging.severe("failed in trasfering from local to remote.stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			
		}		
	}

	
	//*****
	//***** public methods start
	//*****
	
	//transfer table.
	public void Transfer(mycommons.db.Table fromTable,mycommons.db.Table toTable){

		//mycommons.routines.db.Manipulate.DeleteTable(this.connectionRemote, toTable);
		this.TransferCommon(fromTable, toTable);
	}
	
	//*****
	//***** public methods end
	//*****
}
