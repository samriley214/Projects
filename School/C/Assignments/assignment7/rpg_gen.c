#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>

enum Race{
    T = 'T',
    M = 'M',
    S = 'S',
    V = 'V'   
};


struct CISPA{
    int cha;
    int intel;
    int str;
    int psi;
    int agi;
};

struct NETLD{
    int nav;
    int eng;
    int tac;
    int lea;
    int dip;
};

struct crewman{
    char name[21];
    enum Race race;
    
    struct CISPA abilities;
    struct NETLD skills;

    char post[5];
    char rank[5];
    
    struct crewman *captain;

    int serNum;
};

int dieRoll(int maxRoll, int rolls){
    int total = 0;
    for(int i = 0; i < rolls; i++){
        total += rand() % (maxRoll) + 1;
    }
    return total;
}

void crewBonus(struct crewman* Crewman){
    //Yeah this is bad
    int navBonus = (Crewman->abilities.intel + Crewman->abilities.psi)/2;
    int engBonus = (Crewman->abilities.intel + Crewman->abilities.agi)/2;
    int tacBonus = (Crewman->abilities.str + Crewman->abilities.agi)/2;
    int leaBonus = (Crewman->abilities.cha + Crewman->abilities.intel)/2;
    int dipBonus = (Crewman->abilities.cha + Crewman->abilities.psi)/2;

    //Navigation Bonuses
    if(navBonus == 18){
        Crewman->skills.nav += 2;
    }
    else if(navBonus >= 15){
        Crewman->skills.nav += 1;
    }
    else if(navBonus >= 7){
        Crewman->skills.nav += 0;
    }
    else if(navBonus >= 4){
        Crewman->skills.nav -= 1;
    }
    else if(navBonus >= 0){
        Crewman->skills.nav -= 2;
    }

    //Engineering Bonuses
    if(engBonus == 18){
        Crewman->skills.eng += 2;
    }
    else if(engBonus >= 15){
        Crewman->skills.eng += 1;
    }
    else if(engBonus >= 7){
        Crewman->skills.eng += 0;
    }
    else if(engBonus >= 4){
        Crewman->skills.eng -= 1;
    }
    else if(engBonus >= 0){
        Crewman->skills.eng -= 2;
    }

    //Tactics Bonuses
    if(tacBonus == 18){
        Crewman->skills.tac += 2;
    }
    else if(tacBonus >= 15){
        Crewman->skills.tac += 1;
    }
    else if(tacBonus >= 7){
        Crewman->skills.tac += 0;
    }
    else if(tacBonus >= 4){
        Crewman->skills.tac -= 1;
    }
    else if(tacBonus >= 0){
        Crewman->skills.tac -= 2;
    }

    //Leadership Bonuses
    if(leaBonus == 18){
        Crewman->skills.lea += 2;
    }
    else if(leaBonus >= 15){
        Crewman->skills.lea += 1;
    }
    else if(leaBonus >= 7){
        Crewman->skills.lea += 0;
    }
    else if(leaBonus >= 4){
        Crewman->skills.lea -= 1;
    }
    else if(leaBonus >= 0){
        Crewman->skills.lea -= 2;
    }

    //Diplomacy Bonuses
    if(dipBonus == 18){
        Crewman->skills.dip += 2;
    }
    else if(dipBonus >= 15){
        Crewman->skills.dip += 1;
    }
    else if(dipBonus >= 7){
        Crewman->skills.dip += 0;
    }
    else if(dipBonus >= 4){
        Crewman->skills.dip -= 1;
    }
    else if(dipBonus >= 0){
        Crewman->skills.dip -= 2;
    }

    //Race Bonuses

    if( Crewman->race == M){
        Crewman->abilities.str -= 2;
        Crewman->abilities.psi += 2;
        Crewman->abilities.agi += 1;
    }
    else if(Crewman->race == V){
        Crewman->abilities.cha += 1;
        Crewman->abilities.intel -= 1;
        Crewman->abilities.str += 1;
        Crewman->abilities.psi += 1;
        Crewman->abilities.agi -= 1;
    }
    else if(Crewman->race == S){
        Crewman->abilities.cha -= 1;
        Crewman->abilities.intel += 2;
        Crewman->abilities.str -= 1;
        Crewman->abilities.psi += 1;
    }

    //Declaring rank
    int rank = dieRoll(6,2);
    if(rank == 12){
        strcpy(Crewman->rank, "Comm");
    }
    else if(rank == 11){
        strcpy(Crewman->rank, "Lt");
    }
    else if(rank >= 8){
        strcpy(Crewman->rank, "Ens");
    }
    else{
        strcpy(Crewman->rank, "Spcr");
    }


}

void generate(struct crewman* Crewman){
    
    int raceNum = dieRoll(4, 1);
    
    //Deciding race
    if(raceNum == 1){
        Crewman->race = T;
    }
    else if(raceNum == 2){
        Crewman->race = M;
    }
    else if(raceNum == 3){
        Crewman->race = V;
    }
    else if (raceNum == 4){
        Crewman->race = S;
    }

    
    //Lots of repitition, sorry
    Crewman->abilities.cha = dieRoll(6,3);
    Crewman->abilities.intel = dieRoll(6,3);
    Crewman->abilities.str = dieRoll(6,3);
    Crewman->abilities.psi = dieRoll(6,3);
    Crewman->abilities.agi = dieRoll(6,3);

    Crewman->skills.nav = 0;
    Crewman->skills.eng = 0;
    Crewman->skills.tac = 0;
    Crewman->skills.lea = 0;
    Crewman->skills.dip = 0;
   
    //Adding race and skill bonuses, as well as rank name
    crewBonus(Crewman);

    //Making the default post
    strcpy(Crewman->post, "Crew");



    
}

void create(struct crewman** Crewmembers){
    //Make the crewmen, their service number, and generate their stats
    *Crewmembers = malloc(10 * sizeof(struct crewman));
    if(*Crewmembers == NULL){
            printf("Failed to allocate memory to the array");
            exit(1);
    }
    for(int i = 0; i < 10; i++){
        (*Crewmembers)[i].captain = NULL;
        sprintf((*Crewmembers)[i].name, "Crewman%d", i + 1);
        (*Crewmembers)[i].serNum = rand() % (900000) + 100000; //Number between 100000-999999
        generate(&(*Crewmembers)[i]);
        
    }

    fprintf(stderr, "Created crewmembers succesfully");
}

void regenerate(struct crewman* Crewmembers, int servNum){
    int exists = 0;
    for(int i = 0; i < 10; i++){
        if(Crewmembers[i].serNum == servNum){
            generate(&Crewmembers[i]);
            exists = 1;
        }
    }
    if(exists == 0){
        fprintf(stderr, "\nNo crewman with specified service number");
    }
    else{
        fprintf(stderr, "\nRegeneration of %d succesful", servNum);
    }

}

void printCrewman(struct crewman Crewman){
    printf("\n%-6d %-4s %-4s | %-2d %-2d %-2d %-2d %-2d | %-2d %-2d %-2d %-2d %-2d | %c    %s", Crewman.serNum, Crewman.post, Crewman.rank, Crewman.skills.nav, Crewman.skills.eng, Crewman.skills.tac, Crewman.skills.lea, Crewman.skills.dip, Crewman.abilities.cha, Crewman.abilities.intel, Crewman.abilities.str, Crewman.abilities.psi, Crewman.abilities.agi, Crewman.race, Crewman.name);
}

int rankToInt(struct crewman Crewman){
        if(strcmp(Crewman.rank, "Comm") == 0){
            return 5;
        }
        else if(strcmp(Crewman.rank, "Lt") == 0){
            return 4;
        }
        else if(strcmp(Crewman.rank, "Ens") == 0){
            return 3;
        }
        else if(strcmp(Crewman.rank, "Ens") == 0){
            return 2;
        }
        else{
            return 1;
        }
}

int compareByRank(const void *a, const void *b){
    struct crewman *crewA = (struct crewman*)a;
    struct crewman *crewB = (struct crewman*)b;

    int rankA = rankToInt(*crewA);
    int rankB = rankToInt(*crewB);

    return rankB - rankA;
}

void sortCrewByRank(struct crewman *Crewmembers){
    qsort(Crewmembers, 10, sizeof(struct crewman), compareByRank);
}

void output(struct crewman* Crewmembers){
    //sort by rank
    sortCrewByRank(Crewmembers);
    
    //see if there is a captain
    if(Crewmembers[0].captain != NULL){
        printf("\nCaptain : %s", Crewmembers[0].captain->name);
    }
    else{
        printf("\nCaptain : NONE");
    }
        printf("\n                       Skills           Abilities");
        printf("\nSer#   Post Rank | N  E  T  L  D  | C  I  S  P  A  | Race Name");
    //Main body of output
    for (int i = 0; i < 10; i++){
        printCrewman(Crewmembers[i]);
    }
}

void reName(struct crewman* Crewmembers, int servNum, char newName[]){
    int exists = 0;
    for(int i = 0; i < 10; i++){
        if(Crewmembers[i].serNum == servNum){
            strcpy(Crewmembers[i].name, strtok(newName,  "\n"));
            exists = 1;
        }
    }
    if(exists == 0){
        printf("\nNo crewman with specified service number");
    }
    else{
        fprintf(stderr, "\nRenamed %d succesfully", servNum);
    }
}

void rePost(struct crewman Crewmembers[], int servNum, char newPost){
    char postName[4];
    struct crewman* currentCrewman;
    int exists = 0;

    if(newPost == 'C'){
        strcpy(postName, "Com");
    }
    if(newPost == 'N'){
        strcpy(postName, "Nav");
    }
    if(newPost == 'E'){
        strcpy(postName, "Eng");
    }
    if(newPost == 'S'){
        strcpy(postName, "Sec");
    }

    //Find which crewman has the service number
    for(int i = 0; i < 10; i++){
        if(Crewmembers[i].serNum == servNum){
            currentCrewman = &Crewmembers[i];
            exists = 1;
        }
    }
    if(exists == 0){
        printf("\nNo crewman with specified service number");
    }
    else{
        strcpy(currentCrewman->post, postName);
        fprintf(stderr, "\nChanged the post of %d succesfully", servNum);
    }
}

void makeCaptain(struct crewman Crewmembers[], int servNum){
    struct crewman* currentCrewman;
    int maxRank = 1;
    int exists = 0;
    
    //find which crewman has the service number and then get the max rank of all the crewmembers
    for(int i = 0; i < 10; i++){
        if(Crewmembers[i].serNum == servNum){
            currentCrewman = &Crewmembers[i];
            exists = 1;
        }
        if(maxRank < rankToInt(Crewmembers[i])){
            maxRank = rankToInt(Crewmembers[i]);
        }
    }
    if(exists == 0){
        printf("\nNo crewman with specified service number");
    }
    else{
        if(rankToInt(*currentCrewman) < maxRank){
            printf("There is another crewman with a higher rank");
        }
        else{
            strcpy(currentCrewman->post, "Cap");

            for(int i = 0; i < 10; i++){
                Crewmembers[i].captain = currentCrewman;
            }
            fprintf(stderr, "\n%d made Captain succesfuly", servNum);
        }
    }
}

void save2txt(struct crewman* Crewmembers){
    FILE *crewmember_list = fopen("crewmember_list.txt", "w");
    if(Crewmembers[0].captain != NULL){
        fprintf(crewmember_list, "Captain : %s\n", Crewmembers[0].captain->name);
    }
    else{
        fprintf(crewmember_list, "Captain : NONE\n");
    }
        fprintf(crewmember_list, "                       Skills           Abilities\n");
        fprintf(crewmember_list, "Ser#   Post Rank | N  E  T  L  D  | C  I  S  P  A  | Race Name");
    //Main body of output
    for (int i = 0; i < 10; i++){
        fprintf(crewmember_list, "\n%-6d %-4s %-4s | %-2d %-2d %-2d %-2d %-2d | %-2d %-2d %-2d %-2d %-2d | %c    %s", Crewmembers[i].serNum, Crewmembers[i].post, Crewmembers[i].rank, Crewmembers[i].skills.nav, Crewmembers[i].skills.eng, Crewmembers[i].skills.tac, Crewmembers[i].skills.lea, Crewmembers[i].skills.dip, Crewmembers[i].abilities.cha, Crewmembers[i].abilities.intel, Crewmembers[i].abilities.str, Crewmembers[i].abilities.psi, Crewmembers[i].abilities.agi, Crewmembers[i].race, Crewmembers[i].name);
    }

    fclose(crewmember_list);
    fprintf(stderr, "\nSaved crewmembers to crewmember_list.txt");
}

void readFromTxt(struct crewman* Crewmembers, FILE *file){
    if(fopen(file, "r") == NULL){
        fprintf(stderr, "\ncould not open file");
    }
    else{
        fopen(file, "r");
        fseek(file, 0, SEEK_END);
        long filesize = ftell(file);
        rewind(file);
        char *buffer = malloc(filesize + 2);
        
        //[word][char]
        char **words = malloc(filesize + 2);
        
        fread(buffer, 1, filesize, file);
        buffer[filesize] = '\n';
        buffer[filesize + 1] = '\0';

        int start = 0;
        int wordCounter = 0;
        for(int i = 0; i < filesize + 1; i++){
            if(buffer[i] == ' ' || buffer[i] == '\n'){
                for(int j = start; j < i; j++){
                    words[wordCounter][j - start] = buffer[j];
                }
                wordCounter++;
                start = i;
            }
        }

        for (int i = 0; i < 10; i++){
            Crewmembers[i].serNum = atoi(buffer[(i + 1) * 18 + 23 ]);
            Crewmembers[i].abilities.cha = atoi(buffer[(i + 1) * 28 + 23]);
            Crewmembers[i].abilities.intel = atoi(buffer[(i + 1) * 29 + 23]);
            Crewmembers[i].abilities.str = atoi(buffer[(i + 1) * 30 + 23]);
            Crewmembers[i].abilities.psi = atoi(buffer[(i + 1) * 31 + 23]);
            Crewmembers[i].abilities.agi = atoi(buffer[(i + 1) * 32 + 23]);
            Crewmembers[i].race = buffer[(i + 1) * 34  + 23];   
            strcpy(Crewmembers[i].name, buffer[(i + 1) * 35  + 23]);
            crewBonus(&Crewmembers[i]);
        }
        struct crewman *captain;
        for(int i = 0; i < 10; i++){
            if(strcmp(Crewmembers[i].name, buffer[3]) == 0){
                captain = &Crewmembers[i];
            }
        }
        makeCaptain(Crewmembers, captain);
        fclose(file);
        free(buffer);
        free(words);
    }



}




int main(int argc, char * argv[]){
    int randSeed = time(NULL); // Default seed

    //Detect if the user wants to seed the random number generation
    if(argc > 1){
        randSeed = atoi(argv[1]);
    }
    srand(randSeed);
    //Make an array for the crewmembers
    struct crewman* Crewmembers = NULL;


    int endLoop = 0;
    
    //Create and Output the table of crewman
    create(&Crewmembers);
    output(Crewmembers);
    
    //Main loop that takes user input and runs the commands with it
    while(endLoop == 0){
        char userInput[40];
        int userServNum;
        char userThirdInput[21];

        
        
        //Displaying the inut options
        printf("\nCommands:\nD: Display the table of crew members.\nN serv_num name: Provide a name for a crewman identified by the service number.\nC serv_num: Make the specified crewman the captain of the crew. No other crew member should have a higher rank than the captain.\nB serv_num: Assign the specified crewman to a bridge position, by specifying a menu of bridge crew positions. Use single letter to indicate the bridge post assigned:");
        printf("\n\tN - Navigation\n\tC - Communications\n\tS - Security\n\tE - Engineering\nS: Save the crew member list to a file crewmember_list.txt\nR srv_num: Regenerate the specified crewman.\nP: Exit the crew generation program\n");
        
        fgets(userInput, 40, stdin);

        char * tokenPtr = strtok(userInput, " ");
        char userCommand;


        if(tokenPtr != NULL){
            userCommand = (char) *tokenPtr;
            tokenPtr = strtok(NULL, " ");
        }
        if(tokenPtr != NULL){
            userServNum = atoi(tokenPtr);
            tokenPtr = strtok(NULL, " ");
        }
        if(tokenPtr != NULL){
            strcpy(userThirdInput, tokenPtr);
            tokenPtr = strtok(NULL, " ");
        }
        
        

        if(userCommand == 'D'){
            output(Crewmembers);
        }
        else if(userCommand == 'N'){
            if(&userThirdInput == NULL){
                printf("No name given");
            }
            else{
                reName(Crewmembers, userServNum , userThirdInput);
            }
        }
        else if(userCommand == 'C'){
            makeCaptain(Crewmembers, userServNum);
        }
        else if(userCommand == 'B'){
            rePost(Crewmembers, userServNum, *userThirdInput);
        }
        else if(userCommand == 'S'){
            save2txt(Crewmembers);
        }
        else if(userCommand == 'R'){
            if(&userServNum == NULL){
                printf("No service number given");
            }
            else{
                regenerate(Crewmembers, userServNum);
            }
        }
        else if(userCommand == 'P'){
            endLoop = 1;
        }
        else if(userCommand == 'L'){
            
        }
        else{
            printf("Input invalid, please try again!\n");
        }
    }

    free(Crewmembers);
    return 0;
}