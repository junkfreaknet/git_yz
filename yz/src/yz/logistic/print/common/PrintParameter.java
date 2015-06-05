package yz.logistic.print.common;

import mycommons.print.Printer;

public class PrintParameter {

	private mycommons.print.Printer printer;
	private mycommons.print.PaperOrientation paperOrientation;
	private mycommons.print.PaperSize paperSize;
	private mycommons.print.Sheet sheet;
	
	//constructor
	public PrintParameter(){
		this.printer=new mycommons.print.Printer();
		this.paperOrientation=new mycommons.print.PaperOrientation();
		this.paperSize=new mycommons.print.PaperSize();
		this.sheet=new mycommons.print.Sheet();
	}
	public PrintParameter(mycommons.print.Printer inPrinter,mycommons.print.PaperOrientation inPaperOrientation,mycommons.print.PaperSize inPaperSize,mycommons.print.Sheet inSheet){
		this.printer=inPrinter;
		this.paperSize=inPaperSize;
		this.paperOrientation=inPaperOrientation;
		this.sheet=inSheet;
	}
	public PrintParameter(String inPrinter,String inPaperOrientation,String inPaperSize,String inSheet){
		this.printer=new mycommons.print.Printer(inPrinter);
		this.paperOrientation=new mycommons.print.PaperOrientation(inPaperOrientation);
		this.paperSize=new mycommons.print.PaperSize(inPaperSize);
		this.sheet=new mycommons.print.Sheet(inSheet);
	}
	//public methods
	//set
	public void setPrinter(mycommons.print.Printer inPrinter){
		this.printer=inPrinter;
	}
	public void setPaperOrientation(mycommons.print.PaperOrientation inPaperOrientation){
		this.paperOrientation=inPaperOrientation;
	}
	public void setPaperSize(mycommons.print.PaperSize inPaperSize){
		this.paperSize=inPaperSize;
	}
	public void setSheet(mycommons.print.Sheet inSheet){
		this.sheet=inSheet;
	}
	//public methods
	//get
	public mycommons.print.Printer getPrinter(){
		return this.printer;
	}
	public mycommons.print.PaperOrientation getPaperOrientation(){
		return this.paperOrientation;
	}
	public mycommons.print.PaperSize getPeperSize(){
		return this.paperSize;
	}
	public mycommons.print.Sheet getSheet(){
		return this.sheet;
	}
	//private methods
	
}
