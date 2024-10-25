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
    float totalNet = 0;
    float totalFed = 0;
    float totalState = 0;
    float totalFica = 0;
    float totalCommission = 0;
    float totalBonus = 0;
    float totalProfit = 0;
    
    
    
    float netPayArray[5];
    float ficaArray[5];
    float stateTaxArray[5];
    float fedTaxArray[5];
    float commissionArray[5];
    float bonusArray[5];
    float salesArray[5];
    float tenureArray[5];
    float monthlySales = 0;
    
    
    //gets user input of the month and year
    printf("Enter the payroll month and year (mm/yyyy): ");
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

    //This part calculates bonuses, commisions, and taxes for each employee
    
    totalProfit = monthlySales * 0.45;
    
    //Commission
    for (int i = 0; i < 5; i++){
        commissionArray[i] = salesArray[i] * 0.125;
        totalCommission += commissionArray[i];
    }

    //Bonuses
    for (int i = 0; i < 5;i ++){
        //calculating tenure
        int tenureDecades = tenureArray[i] / 10;

        bonusArray[i] = totalProfit * (.10 + (tenureDecades * 0.05));
        totalBonus += bonusArray[i];
    }

    //Taxes
    for (int i = 0; i < 5; i++){
        float grossPay = commissionArray[i] + bonusArray[i];
        fedTaxArray[i] = grossPay * 0.15;
        totalFed += fedTaxArray[i];
        stateTaxArray[i] = grossPay * 0.05;
        totalState += stateTaxArray[i];
        ficaArray[i] = grossPay * 0.075;
        totalFica += ficaArray[i];

        //Deducting taxes from total

        netPayArray[i] = grossPay - (fedTaxArray[i] + stateTaxArray[i] + ficaArray[i]);
        totalNet += netPayArray[i];
    }

    

    //Outputing the finished information
    //Header
    printf("MONTHLY STATEMENT (%s %d)\n", num_2_month(cMonth), cYear);
    printf("%*s\n%*s\n%*s", 78, "Bloomington Skating Company", 78, "Bloomington, IN", 79, "Phone: (812)-855-0000\n");
    printf("MONTHLY SALES: $%.2f\nMONTHLY PROFIT: $%.2f\n", monthlySales, totalProfit);
    printf("===============================================================================\n");
    //Data
    printf("%-11s%-13.2s%-12.2s%-13.2s%-12.2s%-10.2s%-.2s\n", "Name", "Commission", "Bonus", "Fed W.", "ST W.", "FICA", "Net Pay");
    printf("-------------------------------------------------------------------------------\n");
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl: A", commissionArray[0], bonusArray[0], fedTaxArray[0], stateTaxArray[0], ficaArray[0], netPayArray[0]);
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl: B", commissionArray[1], bonusArray[1], fedTaxArray[1], stateTaxArray[1], ficaArray[1], netPayArray[1]);
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl: C", commissionArray[2], bonusArray[2], fedTaxArray[2], stateTaxArray[2], ficaArray[2], netPayArray[2]);
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl: D", commissionArray[3], bonusArray[3], fedTaxArray[3], stateTaxArray[3], ficaArray[3], netPayArray[3]);
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Empl: E", commissionArray[4], bonusArray[4], fedTaxArray[4], stateTaxArray[4], ficaArray[4], netPayArray[4]);
    printf("-------------------------------------------------------------------------------\n");
    printf("%-11s%-13.2lf%-12.2lf%-13.2lf%-12.2lf%-10.2lf%-.2lf\n", "Total", totalCommission, totalBonus, totalFed, totalState, totalFica, totalNet);
    printf("-------------------------------------------------------------------------------\n");

    //Footer
    printf("Net Profit (Profit - Bonus): %.2f", (totalProfit) - totalBonus);

}