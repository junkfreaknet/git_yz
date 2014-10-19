package yz.logistic.print.statics;

public class connectionToDB {

	static String host;
	static String server;
	static String instance;
	static String database;
	static String user;
	static String password;
	
	//getters and setters
	//
	//HOST
	public static void setHost(mycommons.db.connection.Host in_host){
		host=in_host.toStringName();
	}
	public static mycommons.db.connection.Host getHost(){
		return new mycommons.db.connection.Host(host);
	}
	//SERVER
	public static void setServer(mycommons.db.connection.Server in_server){
		server=in_server.toStringName();
	}
	public static mycommons.db.connection.Server getServer(){
		return new mycommons.db.connection.Server(server);
	}
	//INSTANCE
	public static void setInstance(mycommons.db.connection.Instance in_instance){
		instance=in_instance.toStringName();
	}
	public  static mycommons.db.connection.Instance getInstance(){
		return new mycommons.db.connection.Instance(instance);
	}
}
