package sis.studentinfo;

import java.util.ArrayList;

public class Student
{
	private String name; //private instance variable of this student
	private int credits;
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String state ="";
	enum Grade {A, B, C, D, F};
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	
	public Student (String name){
		this.name = name;  //assign name from method call (this local variable)// to the// instance variable object of name 
		credits = 0;		
	}
	
	
	public String getName(){
	return name;	//return the instance variable of this student
	}
    boolean isFullTime (){
    	return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }
    
    int getCredits(){
    	return credits;
    }
	void addCredits(int credits){
		this.credits += credits;
	}
	boolean isInState(){
		return state.equals(Student.IN_STATE);
	}
	void setState(String state){
		this.state = state.toUpperCase();
	}
	void addGrade(Grade grade){
	 grades.add(grade);	
	}
	double getGPA(){
		if (grades.isEmpty())
		return 0.0;
		double total = 0.0;
		for (Grade grade: grades)
			total += gradingStrategy.getGradePointsFor(grade);
		return total / grades.size();
	}

	void setGradingStrategy(GradingStrategy gradingStrategy){
		this.gradingStrategy = gradingStrategy;
	}
	}