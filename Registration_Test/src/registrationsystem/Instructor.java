/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;

public class Instructor {
   
    
    private String firstName, lastName, streetAddress, city, postalCode;
    private int employeeNum;
    private LocalDate birthday, startDate;
    private int hireDate;
    private ArrayList<String> courses = new ArrayList<>();

    
    Instructor (String firstName, String lastName, int employeeNum, String streetAddress, String city, String postalCode, LocalDate startDate, LocalDate birthday){
     
     this.firstName = firstName;
     this.lastName = lastName;
     this.employeeNum = employeeNum ;
     this.streetAddress = streetAddress;
     this.city = city;
     this.postalCode = postalCode;
     this.startDate = startDate;
     setStartDate (startDate);
     setBirthday(birthday);
     
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        
        if(Period.between(birthday, LocalDate.now()).getYears()<100){
            
            this.birthday = birthday;
        }
        else {
            
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startdate) {
        
        if(Period.between(startDate, LocalDate.now()).getYears()<80){
            
            this.startDate = startdate;
        }
        else {
            
            throw new IllegalArgumentException("1910-08-22 as a hire date would mean Anita started working over 80 years ago");
        }
        
    }
     public int yearsAtCollege(){
         int yearsAtCollege = Period.between(startDate, LocalDate.now()).getYears();
         return yearsAtCollege;
     }

     
    public String getAddress(){
       return getStreetAddress() +", "+ getCity()+", "+ getPostalCode();

    }
     
      public void changeAddress(String streetAddress,String city, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.postalCode = postalCode;
   
    }
     
    public String listOfSubjectsCertifiedToTeach() {
        if(courses.isEmpty()){
           
            
          return ("not qualified to teach courses yet.");
            
        }
        
        else{
           
              return (""+courses+"");
       
        }
     }
    
    public void addCourseToAbilities(String course){
             if(!course.isEmpty()){
            
            
            courses.add(course.toUpperCase());
            
         
        }
        else{
            throw new IllegalArgumentException("Nothing to add to instructor's courses.");
        }
    }
  
     
    public boolean canTeach(String course){
        boolean canTeach = false;
        
        for (String courseName : courses){
            if (courseName.equalsIgnoreCase(course)){
                canTeach = true;
            }                
        }
        
        return canTeach;
    }
     
     
         
     
       
    
    
    @Override
     public String toString(){
         return firstName + " " + lastName;
     }
    
    
        public int getAgeInYears(){
        int age = Period.between(birthday, LocalDate.now()).getYears();
        return age;
    }
    
           public int YearsAtCollege(){
        LocalDate hireDate = null;
         int yearsAtCollege = Period.between(hireDate, LocalDate.now()).getYears();
         return yearsAtCollege;
     }
      
           
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
}
