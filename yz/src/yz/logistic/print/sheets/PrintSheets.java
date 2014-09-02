package yz.logistic.print.sheets;

public class PrintSheets {

	//print sheets by block numbers
	public static void print(Object drawer,mycommons.db.connection.ParaConnection paraDBConnection,yz.logistic.print.sheets.parameters.ByBlock paraBlock){
		/***
		 EXPLANATION
		 drawer...an object of sheet drawer 
		***/
		
		if(paraBlock.getBlockNo_s().length==mycommons.constants.Generic.CS_ZERO_AS_INT){
			System.exit(mycommons.constants.Generic.CS_ZERO_AS_INT);
		}	
		
		//print sheet by a block
		for(int i=0;i<paraBlock.getBlockNo_s().length;i++){
			
			//get target print service
			//create sql string
			//init db db connection and initialize recordset
			
		}
		
	}
}
