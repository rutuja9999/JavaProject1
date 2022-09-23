package com.employee;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import com.employee.entity.Employee;
import com.employee.services.EmployeeManagementServices;
import com.employee.utils.ConnectionFactory;

public class App {
    
	public static long getPhoneNumber(Scanner input) {
        try {
            System.out.println("Enter the phone number : ");
            long phoneNumber=Long.parseLong(input.nextLine());
            return phoneNumber;
            
        }
        catch(NumberFormatException e) {
            System.err.println("Phone Number should not contain letters");
            return getPhoneNumber(input);
        }
    }
	
    public static void main( String[] args ){
        Connection connection=ConnectionFactory.getMySqlConnection();
        EmployeeManagementServices services=new EmployeeManagementServices(connection);
        Scanner scan=new Scanner(System.in);
        while(true) {
            System.out.println("Employee Application\n");
            System.out.println("1-->Add Employee Details\n2-->Display List of Employees by the Firstname\n3-->Display List of Employees with Firstname and Phone number\n4-->Update the email and phone number of a particular employee\n5-->Delete details of a particular employee by Firstname\n6-->List of employees with firstname and email address whose birthday falls on the given date\n7-->Get the list of employees with their firstName and phone Number whose Wedding Anniversary falls on the given date\n8)-->Exit\n");
            int choice=0;
            System.out.println("Enter any choice from 1 to 8");
            choice=Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:{
                    System.out.println("1)Add Employee Details");
                    System.out.println("Enter the first name : ");
                    String firstName=scan.nextLine();
                    System.out.println("Enter the last name : ");
                    String lastName=scan.nextLine();
                    System.out.println("Enter the address : ");
                    String address=scan.nextLine();
                    System.out.println("Enter the mail id : ");
                    String emailAddress=scan.nextLine();
                    long phoneNumber=getPhoneNumber(scan);
                    System.out.println("Enter the Date of Birth in (YYYY-MM-DD) Format : ");
                    LocalDate dateOfBirth=LocalDate.parse(scan.nextLine());
                    LocalDate weddingDate=null;
                    System.out.println("Married/UnMarried - YES/NO) : ");
                    String isMarried=scan.nextLine();
                    switch (isMarried) {
                        case "YES":
                        case "yes":
                        	System.out.println("Enter the Wedding date in (YYYY-MM-DD) Format : ");
                            weddingDate = LocalDate.parse(scan.nextLine());
                            break;
                        case "NO":
                        case "no":
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    services.addEmployee(new Employee(firstName, lastName, address, emailAddress, phoneNumber, dateOfBirth, weddingDate));
                    break;
                }    
                case 2:{
                    System.out.println("----------------->2)List of employees by their firstName<-----------------");
                    System.out.println("Enter the first name : ");
                    String firstName=scan.nextLine();
                    services.findByFirstName(firstName);
                    break;
                }
                case 3:{
                    System.out.println("----------------->3)List of employees with FirstName and Phone Number<-----------------");
                    services.displayNameAndPhoneNumber();
                    break;
                }    
                case 4:{
                    System.out.println("----------------->4)Update the email and phoneNumber of a particular employee<-----------------");
                    System.out.println("Enter the mail id : ");
                    String emailAddress=scan.nextLine();
                    System.out.println("Enter the new mail id : ");
                    String newEmailAddress=scan.nextLine();
                    System.out.println("Enter the new phone number : ");
                    long phoneNumber=Long.parseLong(scan.nextLine());
                    services.updateEmailAndPhoneNumber(emailAddress,newEmailAddress,phoneNumber);
                    break;
                }
                case 5:{
                    System.out.println("----------------->5)Delete Details of a Particular employee by firstName<-----------------");
                    System.out.println("Enter the first name : ");
                    String firstName=scan.nextLine();
                    System.out.println("Enter the email : ");
                    String emailAddress=scan.nextLine();
                    services.deleteEmployeeByFirstName(firstName,emailAddress);
                    break;
                }
                case 6:{
                    System.out.println("----------------->6)list of employees with their firstName and emailAddress  whose Birthday falls on the given date<-----------------");
                    System.out.println("Enter the Date in (YYYY-MM-DD) Format : ");
                    LocalDate date=LocalDate.parse(scan.nextLine());
                    services.displayNameAndMail(date);
                    break;
                }
                case 7:{
                    System.out.println("----------------->7)list of employees with their firstName and phone Number whose Wedding Anniversary falls on the given date<-----------------");
                    System.out.println("Enter the Date in (YYYY-MM-DD) Format : ");
                    LocalDate date=LocalDate.parse(scan.nextLine());
                    services.displayNameAndPhoneNumber(date);
                    break;
                }
                case 8:{
                    System.out.println("Exit");
                    scan.close();
                    System.exit(0);
                }
                default:{
                    System.err.println("Give a valid choice");
                    break;
                }
            }
            
        }    
        
    }
}
