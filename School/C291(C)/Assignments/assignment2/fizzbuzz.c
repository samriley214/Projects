/* Sam Riley
Fizzbuzz
This program will simulate playing the game Fizzbuzz, where the user inputs an integer that the program counts up to, but multiples of 3 are replaced with fizz, multiples of 5 with buzz, and multiple of both with fizzbuzz
*/

#include <stdio.h>

int main(void){

int targetNumber = 0;
int counter = 0;
printf("Enter the number you would like to count to\n");
scanf("%d", &targetNumber);

while(counter <= targetNumber){
    printf("\n");
    if(counter == 0){
        printf("0");
    }
    else if((counter % 3 == 0) && (counter % 5 == 0)){
        printf("fizzbuzz");
    }
    else if(counter % 3 == 0){
        printf("fizz");
    }
    else if (counter % 5 == 0){
        printf("buzz");
    }
    else{
        printf("%d", counter);
    }
    counter++;
}
}