package testAzureSql;

public class MainTestIntIsEquals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testing compare integers are equal?
		
		System.out.println(mycommons.routines.generic.Compare.isEqual(0, 0));
		System.out.println(mycommons.routines.generic.Compare.isEqual(1, 0));
		System.out.println(mycommons.routines.generic.Compare.isEqual(1, 1));
		System.out.println(mycommons.routines.generic.Compare.isEqual(0, 1));
	}

}
