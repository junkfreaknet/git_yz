package testAzureSql;

import mycommons.db.connection.DataBase;
import mycommons.db.connection.Host;
import mycommons.db.connection.ParaConnection;
import mycommons.net.tcp.Port;

public class MainTransferfromLocalToAzure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//TransferFromLocalToAzure toAzure;
		mycommons.db.connection.ParaConnection paraLocal=new mycommons.db.connection.ParaConnection();
		mycommons.db.connection.ParaConnection paraRemote=new mycommons.db.connection.ParaConnection();
	
		//start message
		System.out.println("start program.");
		//start message end
		
		paraLocal.setDataBase(new mycommons.db.connection.DataBase("TESTDBJAVA"));
		paraLocal.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraLocal.setHost(new mycommons.db.connection.Host("127.0.0.1"));
		paraLocal.setInstance(new mycommons.db.connection.Instance("SQLEXPRESS"));
		paraLocal.setPassWord(new mycommons.db.connection.Password("sanoriyuki"));
		paraLocal.setPort(new mycommons.net.tcp.Port("1433"));
		//local.setServer(new mycommons.db.connection.Server(source));
		paraLocal.setUser(new mycommons.db.connection.User("sa"));
		
		paraRemote.setDataBase(new mycommons.db.connection.DataBase("junkdb"));
		paraRemote.setForName(new mycommons.db.connection.ForName(mycommons.constants.DB.MS_SQL_SERVER_FOR_NAME));
		paraRemote.setHost(new mycommons.db.connection.Host("m5hmrx2k6x.database.windows.net"));
		//remote.setInstance(source);
		paraRemote.setPassWord(new mycommons.db.connection.Password("Noriyuki6403@@"));
		paraRemote.setPort(new mycommons.net.tcp.Port("1433"));
		//remote.setServer(source);
		paraRemote.setUser(new mycommons.db.connection.User("junk.freak.net@gmail.com"));
		
		String connectionString="jdbc:sqlserver://m5hmrx2k6x.database.windows.net:1433;database=junkdb;user=junkfreaknet@m5hmrx2k6x;password=Noriyuki6403@@;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
		paraRemote.setConnectionString(new mycommons.db.connection.ConnectionString(connectionString));
		
		//test start
		System.out.println("main debugging.");
		//System.out.println("local database is "+paraLocal.getDataBase().toStringName());
		//System.out.println("local connection string is "+paraLocal.getConnectionString().getConnectionString());
		//System.out.println("remote connection string is "+paraRemote.getConnectionString().toString());
		System.out.println("main debugging end.");
		//test end
		
		//transfer database start
		//TransferFromLocalToAzure toAzure=new TransferFromLocalToAzure(paraLocal,paraRemote);
		//toAzure.Transfer(new mycommons.db.Table("dbo.tbl_outfile"));
		TransferFromLocalToAzure toAzure=new TransferFromLocalToAzure();
		toAzure.Transfer(paraLocal, paraRemote);
		//transfer database end
		
		//end message
		System.out.println("end program.");
		//end message end
	}

}
