package yz.logistic.print;

public class StandardSheetB4 implements java.awt.print.Printable{

	public static boolean StatusCreate;
	public static boolean StatusRead;
	
	private mycommons.db.SQLString SQL;
	private java.sql.Connection con;
	private java.sql.Statement stmnt;
	static java.sql.ResultSet rst;
	
	//constructor
	public StandardSheetB4(mycommons.db.SQLString in_sql){
		
		//db initiation here.
		//set database statement and result set
		
		StatusCreate=true;
		StatusRead=true;
		
		this.SQL=in_sql.getSQLString();
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String connection_string="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;database=TESTDBJAVA;user=admNoriyuki;password=admnoriyuki";
            String connection_string="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;database=TESTDBJAVA;user=sa;password=sanoriyuki";
            //String connection_string="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=TESTDBJAVA;user=sa;password=sanoriyuki";
            this.con = java.sql.DriverManager.getConnection(connection_string);
            this.stmnt=con.createStatement();
            this.rst=this.stmnt.executeQuery(this.SQL.toString());
            System.out.println("Connecting DB is success.");
            
			//at last...success
			StatusCreate=true;
			
		}catch(Exception e){
			System.out.println(e.toString());
			System.out.println("Connecting DB is failed.");
			//at last...failed
			StatusCreate=false;
		}
		
		//db initiation here end.
		
	}
	//print routine
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		String id,name,buff;
		
		try{
			
			StatusRead=true;
			
			if(this.rst.next()){
				id="";
				id=rst.getString(1);
				name=rst.getString(2);
				buff=id + "," + name;
				System.out.println(buff);
			
				//
				return this.PAGE_EXISTS;
			}else{
				
				//
				return this.NO_SUCH_PAGE;
			}
		}catch(Exception e){
			
			StatusRead=false;
			System.out.println("Reading table is failed.");
			System.out.println(e.toString());
			//
			return this.NO_SUCH_PAGE;
		}
	
	}
	
	//public methods

}
