package yz.logistic.print.sheets;

public class PrintSheetsFromDB {

	//print sheets by block numbers
	public void print(Object drawer,yz.logistic.print.sheets.PrintParameter paraPrintParameter,yz.logistic.print.sheets.parameters.ByBlock paraBlock){
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
			this.printCore(drawer, paraPrintParameter);
			
		}
		
	}
	private void printCore(Object drawer,yz.logistic.print.sheets.PrintParameter paraPrintParameter){
		
	}
}
