import java.io.DataInput;

public class MyDate {
 private int year;
 private int month;
 private int day;
 public int objectNumber;
 public static  int objectCounter;
 public static  String[] strMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};

 public MyDate() {
	this.year =1900;
	this.month = 1;
	this.day = 1;
	objectCounter ++;
	this.objectNumber = objectCounter ;
	
}
public MyDate(int aYear, int aMonth, int aDay) {
	this.year = aYear;
	this.month = aMonth;
	this.day = aDay;
	objectCounter ++;
	this.objectNumber = objectCounter ;
}
public static int yearDiff(MyDate start, MyDate end) {
	int year = ((end.getDay())-(start.getDay())+(end.getMonth()*30)-(start.getMonth()*30)
				+((end.getYear()*365)-(start.getYear()*365)));
		
	return year/365;

}
public int getObjectNumber() {
	return this.objectNumber;
}

public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getDay() {
	return day;
}
public void setDay(int aYear,int aMonth,int aDay) {
	this.year = aYear;
	this.month = aMonth;
	this.day = aDay;
}
public String toString() {
	return day+" "+ strMonths[month-1] + " " + year;
}
public static boolean isLeapYear(int year) {
	if(year%4!=0) return false;
	else if(year%100!=0) return true;
	else if(year%400!=0) return false;
	else return true;
}
public MyDate nextDay() {
	if(month == 12 && day == 31) {
		year += 1;
		month = 1;
		day = 1;
	}else {
		if(month==4 || month==6 || month==9 || month == 11) {
			if(day==30) {
				month +=1;
				day =1;
			}else {
				day +=1;
			}
		}else if( month != 2) {
			if(day == 31) {
				month += 1;
				day = 1;
			}else day +=1;
			
		}else {
			if(isLeapYear(year) == true && day == 29) {
				month +=1;
				day = 1;
			}else if (isLeapYear(year)== false && day == 28) {
				month += 1;
				day = 1;
			}else day +=1;
		}
	}
	return this;
}
public MyDate nextMonth() {
	month ++;
	if(month == 13) {
		month = 1;
		year ++;
	}
	return this;
}
public MyDate nextYear() {
	year ++ ; 
	return	 this;
}
public MyDate previousDay() {
	if(month == 1 && day == 1) {
		year -=1;
		month = 12;
		day =31;
	}else {
		if(month == 5 || month == 7 || month == 12) {
			if(day == 1) {
				month -= 1;
				day = 30;
			}else day -= 1;
		}else if(month != 3) {
			if(day == 1) {
				month -= 1;
				day = 31;
			}else day -= 1;
		}else {
			if(isLeapYear(year) == true && day == 1) {
				month -= 1;
				day = 29;
			}else if (day == 1) {
				month  -= 1;
				day = 28;
				
			}else day -= 1;
		}
	}
	return this;
}
public MyDate previousMonth() {
	month --;
	if(month == 0) {
		month = 12;
		year --;
	}
	return this;
}
public MyDate previousYear() {
	year --;
	return this;
}

}

class Person {
	public String firstname;
	public String lastname;
	MyDate birthday = new MyDate();

	public Person(String aFirstname, String aLastname) {
		this.firstname = aFirstname;
		this.lastname = aLastname;
	}
	public Person(String aFirstname, String aLastname, int aYear, int aMonth, int aDay){
		this.firstname = aFirstname;
		this.lastname = aLastname;
		birthday.setDay(aYear, aMonth, aDay);
	}
	
	public int getAge(MyDate aDate) {
		int age = MyDate.yearDiff(birthday, aDate);
		return age;
	}
	public boolean isEligible(MyDate elecDate) {
			if(getAge(elecDate)>=18){
				return true;
			}
			return false ;
	}
	public void printPersonInfo() {
		System.out.println("Person: "+firstname+" "+lastname);
		System.out.println("Birthday: "+ birthday.getDay()+" "+MyDate.strMonths[birthday.getMonth()-1]+" "+birthday.getYear());
		
	}

	


}
