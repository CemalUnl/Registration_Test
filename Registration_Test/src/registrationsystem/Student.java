/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Student {
     
    public String firstName,lastName, streetAddress, city, postalCode, program;
    public int yearBorn, yearEnrolled, studentNo,grade;
    public LocalDate birthday, startDate;
    public boolean goodStanding = true;
    public Course courseCode;
    
    
    
    Student (String firstName, String lastName, String streetAddress, String city, String postalCode, String program, int studentNo, LocalDate startDate, LocalDate birthday){
     
     this.firstName = firstName;
     this.lastName = lastName;
     this.streetAddress = streetAddress;
     this.city = city;
     this.postalCode = postalCode;
     this.program = program;
     this.studentNo = studentNo;
     this.startDate = startDate;
     this.birthday = birthday;
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

 public String getAddress(){
       return getStreetAddress() + " "+ getCity() +" "+ getPostalCode();

    }
    
 public void changeAddress(String streetAddress, String city, String postalCode) {
    this.streetAddress = streetAddress;
    this.city = city;
    this.postalCode = postalCode;
   
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

  public int getAge() throws IllegalArgumentException{
      
      if( ( Period.between(birthday, LocalDate.now()).getYears())>=100){
      
      throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
  }
      else {
          int age = Period.between(birthday, LocalDate.now()).getYears();    
          return age;
              }
    }
 
    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    public int getYearEnrolled() {
        return startDate.getYear();
    }

    public void setYearEnrolled(int yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }

    public int getStudentNo() {
        return studentNo;
    }
 

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        
        if(Period.between(birthday, LocalDate.now()).getYears()<100){
            
            this.birthday = birthday;
        }
        else {
            
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    public boolean inGoodStanding() {
        if(goodStanding == false){
            return false;
        }
        
        else{
            return true;
        }
    }
      
    
    public void suspendStudent(){
        goodStanding = false;
    }
      
         public void reinstateStudent(){
        goodStanding = true;
    }
         
  


@Override
 public String toString (){
     return firstName+" "+lastName+ ", "+"student number:"+" "+studentNo;
 }
    
    
   
     public void addCompletedCourse(Course courseCode,int grade){
         if(grade >= 0 && grade <=100){
      Student.this.grade=grade;
     }
     else {
            
            throw new IllegalArgumentException(" grade must be 0-100 inclusive");
        }}
 
     public String getCompletedCourses(){
      return "[COMP1008-Intro to OOP grade="+grade+"]";
     }
    
    
    
    
    
    
    
    
    
}