package Square;


/**
 *
 * @author alain.janinmanificat
 */
public class Doomsday {
	
	// Begin code
	public String getDayOfWeek(int m, int d, int y, int CalendarSystem)
	{	
		
	     // CalendarSystem = 1 for Gregorian Calendar
//	     if (month < 3)
//	     {
//	           month = month + 12;
//	           year = year - 1;
//	     }
//	     
//	     int val = (day
//	             + (2 * month)
//	             + (int) (6 * (month + 1) / 10)
//	             + year
//	             + (int)(year / 4)
//	             - (int)(year / 100)
//	             + (int)(year / 400)+ CalendarSystem) % 7;
//	     
//	     String res = "";
//	     switch(val){
//	     case 0: res = "Sunday";
//	     case 1: res = "Monday";
//	     case 2: res = "Tuesday";
//	     case 3: res = "Wednesday";
//	     case 4: res = "Thursday";
//	     case 5: res = "Friday";
//	     case 6: res = "Saturday";
//	     }
//	     return res;
		
		
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
	    if (m < 3){
	    	y -=1;
	    }
	    int val = ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
	    System.out.println(val);
	     String res = "";
	     switch(val){
	     case 0: res = "Sunday";break;
	     case 1: res = "Monday";break;
	     case 2: res = "Tuesday";break;
	     case 3: res = "Wednesday";break;
	     case 4: res = "Thursday";break;
	     case 5: res = "Friday";break;
	     case 6: res = "Saturday";break;
	     }
	    return res;
	}

	public static void main (String args[]){
		Doomsday dd = new Doomsday();
		System.out.println(dd.getDayOfWeek(4, 17, 1990, 1));
	}

}