#include <stdio.h>
#include <math.h>
#include <stdbool.h>
#define EMP_NUM = 5


void main (){
    //This program rounds a number to the second decimal place using bankers rounding
    //x - the float to round
    //returns the rounded float
    float round_2_even(float x){
        return round(x * 100)/100;
    }

    //This function takes in a numeric input (1-12) and turns it into its respective month
    //x - the integer you want to transalate into a month
    //returns a char* of the translated month
    char* num_2_month(int x){
        switch (x){
            case 1:
                return "JANUARY";
                break;

            case 2:
                return "FEBRUARY";
                break;

            case 3:
                return "MARCH";
                break;
            
            case 4:
                return "APRIL";
                break;
            
            case 5:
                return "MAY";
                break;
            
            case 6:
                return "JUNE";
                break;
            
            case 7:
                return "JULY";
                break;
            
            case 8:
                return "AUGUST";
                break;
            
            case 9:
                return "SEPTEMBER";
                break;
            
            case 10:
                return "OCTOBER";
                break;
            
            case 11:
                return "NOVEMBER";
                break;
            
            case 12:
                return "DECEMBER";
                break;
            
            defualt:
                printf("ERROR: Month out of range");
                break;
        }
    }

    

    //Creating variables
    int cMonth, cYear;
    char myInput[8];
    float salesArray[5];
    float tenureArray[5];
    float monthlySales = 0;
    
    
    //gets user input of the month and year
    printf("Enter the payroll month and year (mm/yyyy): \n");
    fgets(myInput, 8, stdin);
    sscanf(myInput, "%d/%d", &cMonth, &cYear);
    
    //Starting the information entering loop
    for(int i = 0; i < 5; i++){
        float cSales, cTenure;

        printf("Enter the sales and tenure for the next employee: ");
        scanf("%f %f", &cSales, &cTenure);
        
        //This makes sure the user is not trying to stop entering info
        if(cSales != 0 || cTenure != 0){
            salesArray[i] = cSales;
            monthlySales += cSales;
            tenureArray[i] = cTenure;
        }
        //Turning the rest of the slots to 0 if the user is done entering info
        else{
            for(int j = i; j < 6; j++){
                salesArray[j] = 0;
                tenureArray[j] = 0;
            }
            break;
        }
    }
    

    //Outputing the finished information
    printf("MONTHLY STATEMENT (%s %d)\n", num_2_month(cMonth), cYear);
    printf("%*s\n%*s\n%*s", 70, "Bloomington Skating Company", 70, "Bloomington, IN", 70, "Phone: (812)-855-0000\n");
    printf("MONTHLY SALES: $%f\nMONTHLY PROFIT: $%f\n", monthlySales, (monthlySales * 0.45));


}