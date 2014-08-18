package testsX;

public class PrintClass implements java.awt.print.Printable {
	public PrintClass(){
		
	}
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{


		if(page==0){
			g.drawString("abcdefg", 100, 100);
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
	}
}
