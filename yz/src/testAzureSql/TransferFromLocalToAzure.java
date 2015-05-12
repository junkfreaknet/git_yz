package testAzureSql;

import mycommons.db.FieldLength;
import mycommons.db.FieldName;
import mycommons.db.FieldType;
import mycommons.db.IsFieldNullable;

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
			
			java.util.ArrayList<mycommons.db.Field> fields=mycommons.routines.db.Generic.getFields(rstLocal);
			
			// test fields start
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
			//test fields end
			
			//create remote table at here
			mycommons.db.SQLString sqlobj=mycommons.routines.db.Definition.createSqlStringCreateTable(toTable, fields);
			//System.out.println(sqlobj.toString());
			statementRemote.execute(sqlobj.toString());
			// add records to remote
			int i=0;
			
			while(rstLocal.next()){

				
				i=i++;
				if(i>100){
					break;
				}
			}

			// at last. end.
			mycommons.logging.Logging.info("ok");
		}catch(Exception e){

			mycommons.logging.Logging.severe("failed in trasfering from local to remote.stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			
		}		
	}
	private mycommons.db.SQLString createSQLInsert(mycommons.db.Table table_Target,java.sql.ResultSet rst_Source,java.util.ArrayList<mycommons.db.Field> fields){
		
		String buff=mycommons.constants.Generic.CS_SPACE;
		
		//insert command
		buff=buff+mycommons.constants.db.sql.ddl.Commands.COMMAND_INSERT_INTO;
		buff=buff+mycommons.constants.Generic.CS_ONE_BLANK+table_Target.getName()+mycommons.constants.Generic.CS_ONE_BLANK;
		
		//fields
		buff=buff+mycommons.constants.db.sql.ddl.Commands.FIELDS_START;
		//java.sql.ResultSetMetaData mtd=rst_Source.getMetaData();
		
		buff=buff+mycommons.constants.db.sql.ddl.Commands.FIELDS_END;
		
		//values
		buff=buff+mycommons.constants.db.sql.ddl.Commands.VALUES+mycommons.constants.db.sql.ddl.Commands.FIELDS_START;
		
		buff=buff+mycommons.constants.db.sql.ddl.Commands.FIELDS_END;
		//at last
		return new mycommons.db.SQLString(buff);
		
	}

	//*****
	//***** private methods end
	//*****
	/***
	private java.util.ArrayList<mycommons.db.Field> getFields(java.sql.ResultSet in_resultset){
		
		java.util.ArrayList<mycommons.db.Field> rv=new java.util.ArrayList<mycommons.db.Field>();
		
		try{
			java.sql.ResultSetMetaData rstMD=in_resultset.getMetaData();
			//System.out.println("column count is "+rstMD.getColumnCount());
			for(int i=mycommons.constants.DB.RESULTSET_INDEX_START_VALUE;i<=rstMD.getColumnCount();i++){
				//System.out.println("i is "+i);
				//System.out.println("column type is "+rstMD.getColumnTypeName(i));
				mycommons.db.Field fld=new mycommons.db.Field();
				fld.setName(new mycommons.db.FieldName(rstMD.getColumnName(i)));
				fld.setType(new mycommons.db.FieldType(rstMD.getColumnType(i)));
				fld.setLength(new mycommons.db.FieldLength(rstMD.getColumnDisplaySize(i)));
				fld.setIsNullable(new mycommons.db.IsFieldNullable(rstMD.isNullable(i)));
				//System.out.println("lengt is "+rstMD.getColumnDisplaySize(i));
				rv.add(fld);
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe("failed in get result set meta data. stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
	***/
	
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
