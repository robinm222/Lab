package com.mycompany.exam;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
public static void main(String args[]){

    ArrayList<Student> students = new ArrayList<Student>();
    String oddStudents = "";
    String evenStudents = "";
    
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter no. of students : ");
    int count = scanner.nextInt();
    
    System.out.println("Please enter student details : ");
    for(int i = 0;i<count;i++){
        
        System.out.println("Enter student id :");
        int id = scanner.nextInt();
        System.out.println("Enter student name :");
        String name = scanner.next();
        System.out.println("Enter student course :");
        String course = scanner.next();
        
        Student student = new Student(id,name,course);
        students.add(student);
    }
    
    for(int i = 0;i<count;i++){
    int id = students.get(i).id;
    
    if(id%2==0)
    {
        oddStudents = oddStudents + id + " " + students.get(i).name + " " + students.get(i).course + " \n";
    }
    else
    {
        evenStudents = evenStudents + id + " " + students.get(i).name + " " + students.get(i).course + " \n"; 
    }
    
    }
    
    try
    {
        FileWriter fileWriter = new FileWriter("odd.txt",true);
        fileWriter.write(oddStudents);
        fileWriter.close();
        
        FileWriter fileWriter2 = new FileWriter("even.txt",true);
        fileWriter2.write(evenStudents);
        fileWriter2.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    
    
    
}     
}

     
