package textsXPrint;

public class PrintClass implements java.awt.print.Printable {
	static int ppp=0;
	
	public PrintClass(){
		
	}
	public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException{


		if(page==0){
			String buff="abcdefg";
			g.drawString(buff, 100, 100);
			g.drawLine(100, 100, 400, 100);
			//line #2
			java.awt.Font font=g.getFont();
			java.awt.FontMetrics fm=g.getFontMetrics();
			//java.awt.font.FontRenderContext frc=g.getFontMetrics().getFontRenderContext();
			java.awt.font.LineMetrics lm=fm.getLineMetrics(buff, g);
			g.drawLine(100, 100-(int)lm.getHeight(), 400, 100-(int)lm.getHeight());
			System.out.println("font name on print is "+font.getName()+" "+Integer.toString(page)+" "+Integer.toString(ppp));
			ppp++;
			return java.awt.print.Printable.PAGE_EXISTS;
		}else{
			return java.awt.print.Printable.NO_SUCH_PAGE;
		}
	}
}
