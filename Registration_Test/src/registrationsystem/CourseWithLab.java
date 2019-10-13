/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 *
 * @author cemal
 */
public class CourseWithLab extends Course {
    private Instructor labguy;
    private LocalTime labTime;
    private DayOfWeek labDay;
    private String labName;
    public CourseWithLab(Instructor firstName, String courseCode, String courseName, String classroom, DayOfWeek day, LocalTime time, int totalHours,Instructor labguy,String labName,DayOfWeek labDay, LocalTime labTime){
     super(firstName,courseCode,courseName,classroom,day,time,totalHours);
      LocalTime start = LocalTime.parse( "07:59" );
      LocalTime stop = LocalTime.parse(  "17:59" );   
       if(labTime.isAfter(start) &&labTime.isBefore(stop)){
           if(super.getInstructor().listOfSubjectsCertifiedToTeach()!=("not qualified to teach courses yet." )){
               
               
           this.labDay = labDay;
           this.labTime = labTime;
           this.labguy=labguy;
           this.labName=labName;
              }
                      
            else{
            throw new IllegalArgumentException("Professor Alec Tricity is not qualified to teach COMP2008");
        }
           
       }
            else{
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        
    
    }

    @Override
    public String toString() {
        return super.getCourseCode()+"-"+super.getCourseName()+" with lab" ;
    }

  
    public String getLabClassAndTime(){
     return "room: "+ labName +", "+ labDay+ " starting at "+labTime;
    
    
    
    }
    
    
    
    public String getLabTech(){
     return labguy.toString();
    
    }
    
   
    
    

}

