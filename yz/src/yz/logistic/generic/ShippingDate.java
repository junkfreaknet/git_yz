package yz.logistic.generic;

//import java.lang.*;
//import java.util.Calendar.*;

public class ShippingDate {
	
	private String shippingDateYYYYMMDD;
	private String shippingDateFormTitle;
	private String shippingDateDateFormat;
	private int intWeekday;
	private String weekdayByEnglish;
	private String weekdayByLocale;
	
	//CAUNTION
	//Argument in must to be a yyyymmdd value,
	//or a yyyy/mm/dd value.
	//	
	public ShippingDate(String yyyymmdd){

		this.constructorCommon(yyyymmdd,mycommons.system.Defaults.LOCALE);
		
	}
	public ShippingDate(String yyyymmdd,java.util.Locale locale){
		
		this.constructorCommon(yyyymmdd,locale);
	
	}
	//constructor common
	private void constructorCommon(String yyyymmdd,java.util.Locale locale){
		
		if (yyyymmdd.length()==mycommons.constants.Date.CS_LEN_DATE_DATEFORMAT){
			yyyymmdd=mycommons.routines.generic.Convert.convertDateFormatToYYYYMMDD(yyyymmdd);
			
		}
		
		this.shippingDateYYYYMMDD=yyyymmdd;
		this.shippingDateDateFormat=mycommons.routines.generic.Convert.convertYYYYMMDDToDateFormat(yyyymmdd);
		this.intWeekday=mycommons.routines.generic.Date.getWeekday(yyyymmdd);
		this.weekdayByEnglish=mycommons.routines.generic.Date.getWeekday(yyyymmdd, java.util.Locale.ENGLISH);
		this.weekdayByLocale=mycommons.routines.generic.Date.getWeekday(yyyymmdd, locale);
		this.shippingDateFormTitle=this.shippingDateDateFormat+"("+this.weekdayByLocale+")";
		
	}
	
	//public methods
	public yz.logistic.generic.ShippingDate get(){
		return this;
	}
	public String getYYYYMMDD(){
		return this.shippingDateYYYYMMDD;
	}
	public String getDateFormat(){
		return this.shippingDateYYYYMMDD;
	}
	public String getAsFormTitle(){
		return this.shippingDateFormTitle;
	}
	public int getWeekday(){
		return this.intWeekday;
	}
	public String getWeekdayEnglish(){
		return this.weekdayByEnglish;
	}
	public String getWeekdayByLocale(){
		return this.weekdayByLocale;
	}
}
