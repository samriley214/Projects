#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define BUFFER_CHUNK 40 //The amount of data to dynamically resize the input buffer by
#define WORD_CHUNK 2 //The amount of data to dyamically resize the word array by
#define DELIM " \t\n\r" //What the delimiters are
#define PDELIM " \t\n\r,./?:;!"

//process the stdin into the buffer for processing
void processInput(char **inputBuffer, size_t *inputCharCount, size_t * inputBufferSize, int debug){

    //Start by adding 40 bytes to the input buffer
    if(*inputBuffer == NULL){
        *inputBuffer = malloc(BUFFER_CHUNK);
            if(*inputBuffer == NULL){
                if(debug){fprintf(stderr, "DEBUG    FAILED TO ALLOCATE MEMORY TO THE INPUT BUFFER\n");}
                exit(1);
            }
        *inputBufferSize = BUFFER_CHUNK;
    }

    //start going through the data and resizing the input buffer when neccessary
    while(1){
        
        //Resizing when needed
        if (*inputBufferSize == *inputCharCount){
            if(debug){fprintf(stderr, "DEBUG    REALLOCATING MEMORY\n");}
            *inputBuffer = realloc(*inputBuffer, *inputBufferSize + BUFFER_CHUNK);
            if(*inputBuffer == NULL){
                if(debug){fprintf(stderr, "DEBUG    FAILED TO RESIZE INPUT BUFFER\n");}
                exit(1);
            }
            *inputBufferSize += BUFFER_CHUNK;
        }

        //reading the info
        size_t sizeRead = fread(*inputBuffer + *inputCharCount, sizeof(char),BUFFER_CHUNK, stdin);
        *inputCharCount += sizeRead;

        //If it reads less than a chunk, that means that there is no more data left to read
        if (sizeRead < BUFFER_CHUNK){
            (*inputBuffer)[*inputCharCount] = '\0';
            break;
        }
    }
}

//find the amount of lines
size_t findLines(const char *inputBuffer, size_t inputCharCount) {
    size_t lineCount = 0;
    for (size_t i = 0; i < inputCharCount; i++) {
        if (inputBuffer[i] == '\n') {
            lineCount++;
        }
    }
    return lineCount;
}

char** findWords(char *inputBuffer, size_t *wordCount, int **repeatWords, int debug, int *uniqueWordCounter){


    //initialize the first token
    char * tokenPtr = strtok(inputBuffer, DELIM);
    size_t wordArraySize = WORD_CHUNK;
    size_t repeatArraySize = WORD_CHUNK;
    
    //allocate memory to the arrays
    char **wordArray = malloc(wordArraySize * sizeof(char*));
    *repeatWords = calloc(repeatArraySize, sizeof(int));
    
    
    if(wordArray == NULL){
        if(debug){fprintf(stderr, "DEBUG    FAILED TO ALLOCATE MEMORY TO THE WORD ARRAY");}
        exit(1);
    }

    //Set all pointers to NULL incase they arent used (IDK)
    memset(wordArray, 0, wordArraySize * sizeof(char *)); 

    
    while(tokenPtr != NULL){
        //skip any empty tokens
        if(strlen(tokenPtr) < 1){
            tokenPtr = strtok(NULL, DELIM);
            continue;
        }

        //increment total word count
        (*wordCount)++;
        
        int repeat = 0;
        
        //copy the words into an array, but check if the word is a repeat
        for(int i = 0; i < *uniqueWordCounter; i++){
            if(strcmp(wordArray[i], tokenPtr) == 0){
                (*repeatWords)[i] += 1;
                repeat = 1;
                if(debug){fprintf(stderr, "DEBUG    REPEAT WORD FOUND\n");}
                break;
            }
        }

        //if the word is new set its frequency to one
        if(repeat != 1){
            if(debug){fprintf(stderr, "DEBUG    NEW WORD FOUND\n");}

            //dynamically resize the memory for wordArray
            if(*uniqueWordCounter >= wordArraySize){
                if(debug){fprintf(stderr, "DEBUG    REALLOCATING MEMORY\n");}
                wordArraySize += WORD_CHUNK;
                char **tempWordArray = realloc(wordArray, wordArraySize * sizeof(char*));

                if(tempWordArray == NULL){
                    if(debug){fprintf(stderr, "DEBUG    FAILED TO REALLOCATE MEMORY TO THE WORD ARRAY\n");}
                    exit(1);
                }

                wordArray = tempWordArray;
            }

            //dynamically resize the memory for repeatWords
            if(*uniqueWordCounter >= repeatArraySize){
                if(debug){fprintf(stderr, "DEBUG    REALLOCATING MEMORY\n");}
                repeatArraySize += WORD_CHUNK;
                int *tempRepeatArray = realloc(*repeatWords, repeatArraySize * sizeof(int));

                if(tempRepeatArray == NULL){  
                    if(debug){fprintf(stderr, "DEBUG    FAILED TO REALLOCATE MEMORY TO THE REPEAT ARRAY\n");}
                    exit(1);
                }

                *repeatWords = tempRepeatArray;

            }

                wordArray[*uniqueWordCounter] = malloc(strlen(tokenPtr) + 1);
                if (wordArray[*uniqueWordCounter] == NULL) {
                    if(debug){fprintf(stderr, "DEBUG    FAILED TO ALLOCATE MEMORY FOR NEW WORD\n");}
                    exit(1);
                }

                strcpy(wordArray[*uniqueWordCounter], tokenPtr);
                (*repeatWords)[*uniqueWordCounter] = 1;
                
                //increment the amount of unique words
                (*uniqueWordCounter)++;
            }
        
        //get the next token
        tokenPtr = strtok(NULL, DELIM);

    }
    return wordArray;
}

void output(char **words, size_t inputWordCount, size_t inputCharCount, int *repeatWords, int numLines, int lineCount, int charCount, int wordCount, int wordFrequency, int help, int *uniqueWordCounter, int avgWordCount){
    if(avgWordCount == 1){wordCount = 1;}
    if(!help){
        if(lineCount){
            printf("line count : %u\n", numLines);
        }
        if(avgWordCount){
            printf("avg line length : %.1f\navg word length : %.1f\n", (double)inputCharCount / numLines, (double)inputCharCount / (double)inputWordCount);
        }
        if(wordCount){
            printf("word count : %lu\n", inputWordCount);
        }
        if(charCount){
            printf("char count : %lu\n", inputCharCount);
        }
        if(wordFrequency){
            printf("word frequency :\n");
            for(size_t i = 0; i < *uniqueWordCounter; i++){
                if(words[i]){
                    printf("    %s : %d\n", words[i], repeatWords[i]);
                }
            }
        }
        
    }
    else{
        printf("Prints the word count from stdin.\nUsage: my_wc [-h] [-l] [-c] [-w] [-f] [-d] [-v] [-a] [-p]\n-h -- display this help message\n-d -- debugging output to stderr\n-w -- word count (default with no options)\n-c -- character count\n-l -- line count\n-f -- word frequency\n-v -- output all word, line, character. and frequency\n-a -- report average word and line length\n-p -- do not include punctuation in words");
    }
}

void findCommands(int argc, char * argv[], char commands[]){
    for(int i = 1; i < strlen(argv[1]); i++){
        commands[i - 1] = argv[1][i];
    }
}



int main(int argc, char * argv[]){
    //input buffer variables
    int uniqueWordCounter = 0;
    char *inputBuffer = NULL;
    int *repeatWords = NULL;
    size_t inputCharCount = 0;
    size_t inputBufferSize = 0;
    size_t inputWordCount = 0;
    size_t numLines = 1;
    char commands[argc - 1];

    //command line arguement variables
    int lineCount = 0;
    int charCount = 0;
    int wordCount = 0;
    int wordFrequency = 0;
    int help = 0;
    int debug = 0;
    int none = 1;
    int avgWordCount = 0;


    //Find which arguments have been submitted
    if(argc > 1){
        findCommands(argc, argv, commands);
        none = 0;
        for(int i = 0; i < strlen(commands); i ++){
            if(commands[i] == 'l'){
                lineCount = 1;
            }
            if(commands[i] == 'c'){
                charCount = 1;
            }
            if(commands[i] ==  'w'){
                wordCount = 1;
            }
            if(commands[i] == 'f'){
                wordFrequency = 1;
            }
            if(commands[i] ==  'v'){
                lineCount = 1;
                charCount = 1;
                wordCount = 1;
                wordFrequency = 1;
            }
            if(commands[i] == 'h'){
                help = 1;
            }
            if(commands[i] == 'd'){
                debug = 1;
            }
            if(commands[i] == 'a'){
                avgWordCount = 1;
            }
        }
    }
    else{
        lineCount = 1;
        charCount = 1;
        wordCount = 1;
    }



    //Process the data from stdin
    processInput(&inputBuffer, &inputCharCount, &inputBufferSize, debug);

    //find the number of lines
    numLines = findLines(inputBuffer, inputCharCount);

    //Turn the buffer into individual words
    char **words = findWords(inputBuffer, &inputWordCount, &repeatWords, debug, &uniqueWordCounter);

    //output
    output(words, inputWordCount, inputCharCount, repeatWords, numLines, lineCount, charCount, wordCount, wordFrequency, help, &uniqueWordCounter, avgWordCount);

    //freeing up memory
    for (size_t i = 0; i < uniqueWordCounter; i++) {
        if(words[i] != NULL){
            //printf("\n%s", words[i]);
            free(words[i]);
            words[i] = NULL;
        }
        else{
            //printf("words[%zu] is NULL", i);
        }
    }

    free(inputBuffer);
    inputBuffer = NULL;
    free(repeatWords);
    repeatWords = NULL;
    free(words);
    words = NULL;
    return 0;
}