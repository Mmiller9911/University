package sis.studentinfo;

import java.util.*;

/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Administrator
 */

public class CourseSession implements Comparable<CourseSession>{
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;
	private static int count;
	private int numberOfCredits;
	
	private CourseSession(String department, String number, Date startDate){
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	/**
	 * Constructs a courseSession starting on a specific date
	 * 
	 * @param startDate = the date on which the courseSession begins
	 */
	public static CourseSession create(String department, String number, Date startDate){
		incrementCount();
     return new CourseSession(department,number,startDate);
	}
	
	public String getDepartment(){
		return department;
	}
	public String getNumber(){
		return number;
	}
	int getNumberOfStudents(){
		return students.size();
		
	}
	public void enroll(Student student){
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	Student get(int index){
		return students.get(index);
	}
	public ArrayList<Student> getAllStudents()
	{
		return students;
	}
	
	/** 
	 * @return the final date of the course
	 */
	Date getEndDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3 ;
		calendar.add(java.util.Calendar.DAY_OF_YEAR, numberOfDays); 
		return calendar.getTime();
	}
	Date getStartDate(){
		return startDate;
	}
    static int getCount(){
    	return count;
    }
    static void resetCount(){
    	count = 0;
    }
    private static void incrementCount(){
    	++count;
    }
    void setNumberOfCredits(int numberOfCredits){
    	this.numberOfCredits = numberOfCredits;
    }
    public int compareTo(CourseSession that){
    	int compare =
    	this.getDepartment().compareTo(that.getDepartment());
    	if(compare==0)
    	compare = this.getNumber().compareTo(that.getNumber());
    	return compare;
    }
    
}
