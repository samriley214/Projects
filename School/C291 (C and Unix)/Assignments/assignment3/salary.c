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
#define FIRST_COL_WIDTH 20
#define SECOND_COL_WIDTH 16
#define THIRD_COL_WIDTH 14


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

    double round(double x){
        double x1000 = (x  * 1000);
        int temp = (int)x1000 % 10;
        if(temp >= 5){
            x1000 += 10 - temp;
        }
        else{
            x1000 -= temp;
        }
        return x1000 / 1000;
    }
    
    double round_2_even(double x){
        return round(x * 100)/100;
    }



    //Some helpful information on how to enter in data
    printf("The format for entering data should be <Employee_Code> <Data1> <Data2>\nPress Enter when finished entering data to see a table of all the data\n");
    
    
    
    
    //This loop runs until the user terminates it, it takes in the user input and adds the data to the global arrays for each emplyee type
    while(!terminate){
        printf("Enter employee data: ");
        char employeeCode;
        float wage = 0, hoursWorked = 0;
        char salInfo[100] = "";
        //scanf("%s", salInfo);

        //fgets(salInfo, sizeof(salInfo), stdin);
        //sscanf(salInfo, "%c %f %f", &employeeCode, &wage, &hoursWorked);
        scanf(" %c", &employeeCode);

        switch(employeeCode){
            //Administration
            case 'A':
                scanf("%f", &wage);
                adminInstances++;
                adminPayTotal += wage;
                adminMonthlyAvgSal = ((adminPayTotal / MPY) / adminInstances);
                break;

            //Staff
            case 'S':
                scanf("%f", &wage);
                scanf("%f", &hoursWorked);
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
                scanf("%f", &wage);
                scanf("%f", &hoursWorked);
                rfacInstances++;
                rfacTotalPay += wage;
                rfacCreditOverload += hoursWorked;
                rfacMonthlyAvgSal = (rfacTotalPay / 10) / rfacInstances;
                rfacMonthlyPay = rfacMonthlyAvgSal + (rfacCreditOverload / 3 * 8500) / 5;
                break;
            
            //Adjuct Faculty
            case 'J':
                scanf("%f", &wage);
                afacInstances++;
                //if total credit hours is more than 9, set to 9
                if(wage > 9){wage = 9;}
                afacCreditHours += wage;
                afacTotalPay = (afacCreditHours / 3) * 8500;
                afacMonthlyAvgSal = afacTotalPay / 5;
                break;

            
            //Teachers Assistants
            case 'T':
                scanf("%f", &wage);
                scanf("%f", &hoursWorked);
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
                scanf("%f", &wage);
                scanf("%f", &hoursWorked);
                hourlyInstances++;
                hourlyPayRate = wage;
                hourlyHoursWorked = hoursWorked;
                //Calculating overtime hours and making hourlyHoursWorked represent the amount of regular hours worked
                if(hourlyHoursWorked > 20 * WPM){hourlyTotalOvertime = hourlyHoursWorked - 20 * WPM; hourlyHoursWorked -= hourlyTotalOvertime;}
                hourlyMonthlyAvgSal = hourlyPayRate * 20 * WPM;
                hourlyMonthlyPay = (hourlyPayRate * hourlyHoursWorked) + (1.5 * hourlyPayRate * hourlyTotalOvertime); 
                break;
            
            //Finish entering payments
            case 'q':
                terminate = true;
                break;
            
            case 'Q':
                terminate = true;
                break;
            
            //Catches invalid inputs
            default:
                printf("Error: invalid input!");


        }

    }

    adminMonthlyAvgSal = round(adminMonthlyAvgSal);

    //Printing results in a formatted table
    printf("\n%-*s%-*s%-*s\n",
         FIRST_COL_WIDTH,  "EMPLOYEE TYPE",
         SECOND_COL_WIDTH, "AVG_SALARY",
         THIRD_COL_WIDTH,  "AVG_PAY");
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "Administrator",
         SECOND_COL_WIDTH, adminMonthlyAvgSal,
         THIRD_COL_WIDTH,  adminMonthlyAvgSal);
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "Staff",
         SECOND_COL_WIDTH, staffMonthlyAvgSal,
         THIRD_COL_WIDTH,  staffMonthlyPay);
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "Faculty",
         SECOND_COL_WIDTH, rfacMonthlyAvgSal,
         THIRD_COL_WIDTH,  rfacMonthlyPay);
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "Adjunct",
         SECOND_COL_WIDTH, afacMonthlyAvgSal,
         THIRD_COL_WIDTH,  afacMonthlyAvgSal);
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "TA",
         SECOND_COL_WIDTH, taMonthlyAvgSal,
         THIRD_COL_WIDTH,  taMonthlyPay);
    printf("%-*s%-*.2lf%-*.2lf\n",
         FIRST_COL_WIDTH,  "Hourly",
         SECOND_COL_WIDTH, hourlyMonthlyAvgSal,
         THIRD_COL_WIDTH,  hourlyMonthlyPay);
  
        

}
