package yz.logistic.print;

public class StandardSheetB4FromDB implements java.awt.print.Printable{

	public static boolean StatusCreate;
	public static boolean StatusRead;
	
	private java.sql.Connection con;
	static java.sql.Statement stmnt;
	static java.sql.ResultSet rst;
	
	//constructor
	public StandardSheetB4FromDB(mycommons.db.connection.ParaConnection in_para,mycommons.db.SQLString in_sql){
		
		//db initiation here.
		//set database statement and result set
		
		StatusCreate=true;
		StatusRead=true;
		
		
		try{
			/***
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connection_string="jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;database=TESTDBJAVA;user=sa;password=sanoriyuki";
            this.con = java.sql.DriverManager.getConnection(connection_string);
            ***/
			mycommons.db.connection.Connection myconnection=new mycommons.db.connection.Connection(in_para);
			this.con=myconnection.getConnection();
            this.stmnt=con.createStatement();
            this.rst=this.stmnt.executeQuery(in_sql.toString());
            
			//at last...success
			
		}catch(Exception e){
			System.out.println(e.toString());
			System.out.println("Connecting DB is failed.");
			//at last...failed
			StatusCreate=false;
		}
		
	}
	//print routine
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{

		String buff;
		//String id,name,buff;
		
		try{
			
			StatusRead=true;
			
			if(this.rst.next()){
				buff=rst.getString("haibun_mad")+","+rst.getString("ad_ten_no")+","+rst.getString("haiso_course")+","+rst.getString("haiso_order");//+","+rst.getString("ten_nm_kanji");
				
				g.drawString(buff, 100, 100);
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
