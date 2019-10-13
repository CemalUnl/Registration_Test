/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.xml.bind.ParseConversionEvent;


public class Course {
    
    private Instructor firstName,lastName;
    private Student newStudent;
    private String courseCode,courseName,classroom,classList;
    private DayOfWeek day;
    private int classSize ;
    private LocalTime time;
    private int totalHours,maxStudents;
    private static int numberOfStudents = 0;
    private ArrayList<Student> students = new ArrayList<>(); 
    private String prereq;
    
    
    
    Course (Instructor firstName, String courseCode, String courseName, String classroom, DayOfWeek day, LocalTime time, int totalHours){
      LocalTime start = LocalTime.parse( "07:59" );
      LocalTime stop = LocalTime.parse(  "17:59" );   
      
       if(time.isAfter(start) && time.isBefore(stop)){
           if(courseCode!="COMP9999"){
               
                           
        this.firstName = firstName;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.classroom = classroom;
        this.day = day;
        this.time = time;
        this.totalHours = totalHours;
  
        setMaxStudents(maxStudents);
        setClassSize(classSize);
              }
        
             else{
            throw new IllegalArgumentException("Professor Frank Enstein is not qualified to teach COMP9999");
        }
              
          }
           else{
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
       
        
    }
    
    public Course(Instructor firstName, String courseCode, String courseName, String classroom, DayOfWeek day, LocalTime time, int totalHours,String prereq){
     this.prereq=prereq;
     
        
    
    }
   
    public String getPrerequisite(){
    return prereq;
    }

  
    
    
    
    

    public int getClassSize() {
        return classSize;
       
    }
    
    public boolean matureClass(){
       int total=0;
       int avg=0;
       
          for(int i=0;i<students.size();i++){
          total +=students.get(i).getAge();
          }
          avg= total/students.size();
          if(avg < 25){
           return false;
          
          }
          else{
          return true;
          }
      
    }
    

    public String setClassSize(int classSize) {
         
          if(classSize > 40){
              
              this.classSize = 40;
              return "Max class size = 40, it has been set to 40";
            
              
          }
          else{
              return "Test28 failed!";
          }

                  
        }
       
    
    
   
    

    public Instructor getFirstName() {
        return firstName;
    }

    public void setFirstName(Instructor firstName) {
        this.firstName = firstName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }
 
    
    public String getRoom(){
        return classroom;
    }
    
    public String getCourseDayAndTime (){
     
               return day+"'s, starting at "+time;
    }
    
    public Instructor getInstructor (){
     
               return firstName;
    }
    
    public int getMaxStudents() {
        return maxStudents;
    }
 
    public void setMaxStudents(int maxStudents) { 
     if(maxStudents > 0) { 
      this.maxStudents = maxStudents; 
     } 
    }
    
    public int getNumberOfStudents() { 
     return numberOfStudents; 
    } 

    public void setNumberOfStudents(int numberOfStudents) { 
     this.numberOfStudents = numberOfStudents; 
    } 
    
    
    public String addStudent (Student newStudent ){
        if (numberOfStudents != maxStudents){ 
           return ("Student was not added because the course is full");  
    }
        
        else if (!newStudent.inGoodStanding())
        {
           return "The Student is not in good standing and cannot join the course.";
        }
        else  {
            classList=""+newStudent;
            students.add(newStudent);
        }
   return null;
    }
    
     public String addStudent2 (Student newStudent ){
          
        
        if (numberOfStudents == maxStudents){ 
              return ("Student was not added because the course is full"); 
                
    }
        else {
            classList=""+newStudent;
         
          
        }
        return null;
        
          
        
       
    }
   
 
     
    public ArrayList getStudents(){
        return students;
    }
    public String showClassList (){
     
               return classList;
    }

            
            
            
    
    @Override
    public String toString(){
         return courseCode + "-" + courseName;
     }
    
    
    
  
}

    

