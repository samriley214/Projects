#include <stdio.h>
#include <math.h>
#include <math.h>
#include <stdbool.h>
#define EMP_NUM = 5
//This function takes in a numeric input (1-12) and turns it into its respective month
//x - the integer you want to transalate into a month
//returns a char* of the translated month
 char *num_2_month(int x){
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
            
            default:
                printf("ERROR: Month out of range");
                return "";
                break;
        }
    }

//This program rounds a number to the second decimal place using bankers rounding
//x - the double to round
//returns the rounded double
double round_2_even(double x){
    return round(x * 100) / 100;
}
int main (){



   

    //Creating variables
    int cMonth, cYear;
    char myInput[8];
    double totalNet = 0;
    double totalFed = 0;
    double totalState = 0;
    double totalFica = 0;
    double totalCommission = 0;
    double totalBonus = 0;
    double totalProfit = 0;
    double monthlySales = 0;
    
    //Creating Arrays
    double netPayArray[5];
    double ficaArray[5];
    double stateTaxArray[5];
    double fedTaxArray[5];
    double commissionArray[5];
    double bonusArray[5];
    double salesArray[5];
    double tenureArray[5];    
    
    //gets user input of the month and year
    printf("Enter the payroll month and year (mm/yyyy): ");
    fgets(myInput, 8, stdin);
    sscanf(myInput, "%d/%d", &cMonth, &cYear);
    
    //Starting the information entering loop
    for(int i = 0; i < 5; i++){
        double cSales, cTenure;

        printf("Enter the sales and tenure for the next employee: ");
        scanf("%lf %lf", &cSales, &cTenure);
        
        //This makes sure the user is not trying to stop entering info
        if(cSales != 0 || cTenure != 0){
            salesArray[i] = cSales;
            monthlySales += cSales;
            tenureArray[i] = cTenure;
        }
        //Turning the rest of the slots to 0 if the user is done entering info
        else{
            for(int j = i; j < 5; j++){
                salesArray[j] = 0;
                tenureArray[j] = 0;
            }
            break;
        }
    }

    //This part calculates bonuses, commisions, and taxes for each employee
    
    totalProfit = monthlySales * 0.45;
    
    //Commission
    for (int i = 0; i < 5; i++){
        commissionArray[i] = salesArray[i] * 0.125;
        totalCommission += round_2_even(commissionArray[i]);
    }

    //Bonuses
    for (int i = 0; i < 5;i ++){
        //calculating tenure
        int tenureDecades = tenureArray[i] / 10;

        bonusArray[i] = totalProfit * (.10 + (tenureDecades * 0.05));
        totalBonus += round_2_even(bonusArray[i]);
    }

       //Taxes
    for (int i = 0; i < 5; i++){
        double grossPay = commissionArray[i] + bonusArray[i];
        fedTaxArray[i] = grossPay * 0.15;
        totalFed += round_2_even(fedTaxArray[i]);
        stateTaxArray[i] = grossPay * 0.05;
        totalState += round_2_even(stateTaxArray[i]);
        ficaArray[i] = grossPay * 0.075;
        totalFica += round_2_even(ficaArray[i]);
        

        //Deducting taxes from total

        netPayArray[i] = grossPay - (fedTaxArray[i] + stateTaxArray[i] + ficaArray[i]);
        totalNet += round_2_even(netPayArray[i]);
    }


    //Outputing the finished information
    //Header
    printf("\nMONTHLY STATEMENT (%s %d)\n", num_2_month(cMonth), cYear);
    printf("%*s\n%*s\n%*s", 78, "Bloomington Skating Company", 78,
           "Bloomington, IN", 79, "Phone: (812)-855-0000\n");
    printf("MONTHLY SALES: $%.2f\nMONTHLY PROFIT: $%.2f\n", monthlySales,
           totalProfit);
    printf("==================================================================="
           "============\n");

    // Data
    printf("%-11s%-13.2s%-12.2s%-13.2s%-12.2s%-10.2s%-.2s\n", "Name",
           "Commission", "Bonus", "Fed W.", "ST W.", "FICA", "Net Pay");
    printf("-------------------------------------------------------------------"
           "------------\n");
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl A:",
           round_2_even(commissionArray[0]), round_2_even(bonusArray[0]), round_2_even(fedTaxArray[0]), round_2_even(stateTaxArray[0]),
           round_2_even(ficaArray[0]), round_2_even(netPayArray[0]));
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl B:",
           round_2_even(commissionArray[1]), round_2_even(bonusArray[1]), round_2_even(fedTaxArray[1]), round_2_even(stateTaxArray[1]),
           round_2_even(ficaArray[1]), round_2_even(netPayArray[1]));
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl C:",
           round_2_even(commissionArray[2]), round_2_even(bonusArray[2]), round_2_even(fedTaxArray[2]), round_2_even(stateTaxArray[2]),
           round_2_even(ficaArray[2]), round_2_even(netPayArray[2]));
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl D:",
           round_2_even(commissionArray[3]), round_2_even(bonusArray[3]), round_2_even(fedTaxArray[3]), round_2_even(stateTaxArray[3]),
           round_2_even(ficaArray[3]), round_2_even(netPayArray[3]));
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl E:",
           round_2_even(commissionArray[4]), round_2_even(bonusArray[4]), round_2_even(fedTaxArray[4]), round_2_even(stateTaxArray[4]),
           round_2_even(ficaArray[4]), round_2_even(netPayArray[4]));
    printf("-------------------------------------------------------------------"
           "------------\n");
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Total",
           totalCommission, totalBonus,
           totalFed, totalState,
           totalFica, totalNet);
    printf("-------------------------------------------------------------------"
           "------------\n");

    // Footer
    printf("Net Profit (Profit - Bonus): %.2f\n",
           (totalProfit)-totalBonus);
}
