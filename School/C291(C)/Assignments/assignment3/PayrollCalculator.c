/*Sam Riley
PayrollCalculator.c
This program will take the input of an employee type label, followed by relevant pay information, either their pay, hours worked, or both 
and then return a table of the employee types with their average pay and their avg salary.
*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

//Months per year
#define MPY      12
#define WPM      4
#define HPW      40


int main(void){


    //Creating variables for each employee type.
    bool terminate = false;
    bool helpDone = false;
    
    float adminMonthlyAvgSal = 0, adminInstances = 0, adminPayTotal = 0;
    
    float staffMonthlyAvgSal = 0, staffMonthlyPay = 0, staffInstances = 0, staffPayTotal = 0, staffOT = 0;
    
    float hourlyMonthlyAvgSal = 0, hourlyMonthlyPay = 0, hourlyInstances = 0, hourlyHoursWorked = 0, hourlyTotalOvertime = 0, hourlyPayRate = 0;
   
    float afacMonthlyAvgSal = 0, afacInstances = 0, afacTotalPay = 0, afacCreditHours = 0;
    
    float rfacMonthlyAvgSal = 0, rfacMonthlyPay = 0, rfacInstances = 0, rfacTotalPay = 0, rfacCreditOverload = 0;
    
    float taMonthlyAvgSal = 0, taMonthlyPay = 0, taInstances = 0, taTotalPay = 0, taTotalHours = 0, taTotalCourses = 0, taHourlyPay = 0, taTotalOvertime = 0;


    //Some helpful information on how to enter in data
    printf("The format for entering data should be <Employee_Code> <Data1> <Data2>\nPress Enter when finished entering data to see a table of all the data");
    
    
    
    
    //This loop runs until the user terminates it, it takes in the user input and adds the data to the global arrays for each emplyee type
    while(!terminate){
        printf("\nEnter employee data: ");
        char employeeCode;
        float wage = 0, hoursWorked = 0;
        char salInfo[100] = "";
        //scanf("%s", salInfo);

        fgets(salInfo, sizeof(salInfo), stdin);
        sscanf(salInfo, "%c %f %f", &employeeCode, &wage, &hoursWorked);
        switch(employeeCode){
            //Administration
            case 'A':
                adminInstances++;
                adminPayTotal += wage;
                adminMonthlyAvgSal = (adminPayTotal / MPY) / adminInstances;
                break;

            //Staff
            case 'S':
                //if overtime is more than 10 hours, set to 10 hours
                if(hoursWorked > 10){hoursWorked = 10;}
                staffInstances++;
                staffPayTotal += wage;
                staffOT += hoursWorked;
                staffMonthlyAvgSal = (staffPayTotal / MPY) / staffInstances;
                staffMonthlyPay = staffMonthlyAvgSal + ((staffMonthlyAvgSal / WPM) / HPW * staffOT / staffInstances * 1.5);
                break;
                
            //Regular Faculty
            case 'R':
                rfacInstances++;
                rfacTotalPay += wage;
                rfacCreditOverload += hoursWorked;
                rfacMonthlyAvgSal = (rfacTotalPay / 10) / rfacInstances;
                rfacMonthlyPay = rfacMonthlyAvgSal + (rfacCreditOverload / 3 * 8500) / 5;
                break;
            
            //Adjuct Faculty
            case 'J':
                afacInstances++;
                //if total credit hours is more than 9, set to 9
                if(wage > 9){wage = 9;}
                afacCreditHours += wage;
                afacTotalPay = (afacCreditHours / 3) * 8500;
                afacMonthlyAvgSal = afacTotalPay / 5;
                break;

            
            //Teachers Assistants
            case 'T':
                taInstances++;
                taTotalCourses += wage;
                taTotalHours += hoursWorked;
                taHourlyPay = ((taTotalCourses * 2500) / WPM) / 10;
                taTotalPay = taTotalHours * taHourlyPay;
                taMonthlyAvgSal = taHourlyPay * WPM ;
                taMonthlyPay = taTotalPay / 10;


                break;
            
            //Hourly
            case 'H':
                hourlyInstances++;
                hourlyPayRate = wage;
                hourlyHoursWorked = hoursWorked;
                //Calculating overtime hours and making hourlyHoursWorked represent the amount of regular hours worked
                if(hourlyHoursWorked > 20 * WPM){hourlyTotalOvertime = hourlyHoursWorked - 20 * WPM; hourlyHoursWorked -= hourlyTotalOvertime;}
                hourlyMonthlyAvgSal = hourlyPayRate * 20 * WPM;
                hourlyMonthlyPay = (hourlyPayRate * hourlyHoursWorked) + (1.5 * hourlyPayRate * hourlyTotalOvertime); 
                break;
            
            //Finish entering payments
            case '':
                terminate = true;
                break;
            
            //Catches invalid inputs
            default:
                printf("Error: invalid input!");


        }

    }

    //Printing results in a formatted table
    printf("%-16s%-14s%s\n%-16s%-14.2f%.2f\n%-16s%-14.2f%.2f\n%-16s%-14.2f%.2f\n%-16s%-14.2f%.2f\n%-16s%-14.2f%.2f\n%-16s%-14.2f%.2f\n","Employee Code", "Avg Salary", "Avg Pay", "Administrator", adminMonthlyAvgSal, adminMonthlyAvgSal, "Staff", staffMonthlyAvgSal, staffMonthlyPay, "Faculty", rfacMonthlyAvgSal, rfacMonthlyPay, "Adjuct", afacMonthlyAvgSal, afacMonthlyAvgSal, "TA",taMonthlyAvgSal , taMonthlyPay, "Hourly", hourlyMonthlyAvgSal, hourlyMonthlyPay);


}