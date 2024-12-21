#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>

#define INPUT_CHUNK 4  // The amount of bytes to read and allocate at a time
#define MAX_INPUT_SIZE 2048  // Maximum bytes to read

//0 is not the same 1 is true
int compareWords(char * word1, char * word2){
    if(strlen(word1) != strlen(word2)){
        return 0;
    }
    for(int i = 0; i < strlen(word1); i++){
        if(word1[i] != word2[i]){
            return 0;
        }
    }
    return 1;
}

//This function reads all the data into our buffer, thank you Tianyu 
void processInput(char **inputBuffer, size_t *inputBufferSize, size_t *charCount) {
    if (*inputBuffer == NULL) {
        *inputBuffer = malloc(INPUT_CHUNK);
        if (*inputBuffer == NULL) {
            fprintf(stderr, "Failed to allocate memory.\n");
            exit(1);
        }
        *inputBufferSize = INPUT_CHUNK;
        memset(*inputBuffer, 0, INPUT_CHUNK);
    }

    // Read input until 2048 bytes or a null character shows up
    while (1) {
        if (*inputBufferSize == *charCount) {
            // Resize the buffer when it gets full
            char *tempBuffer = realloc(*inputBuffer, *inputBufferSize + INPUT_CHUNK);
            if (tempBuffer == NULL) {
                fprintf(stderr, "Failed to allocate memory.\n");
                free(*inputBuffer);
                exit(1);
            }
            *inputBuffer = tempBuffer;
            memset(*inputBuffer + *charCount, 0, INPUT_CHUNK);
            *inputBufferSize += INPUT_CHUNK;
        }

        // Read from stdin
        size_t sizeRead = fread(*inputBuffer + *charCount, sizeof(char), INPUT_CHUNK, stdin);
        *charCount += sizeRead;

        // Stop reading if we've reached 2048 bytes
        if (*charCount >= MAX_INPUT_SIZE) {
            *charCount = MAX_INPUT_SIZE;
            break;
        }

        // If the number of bytes read is less than requested, it means there is no more data to read
        if (sizeRead < INPUT_CHUNK) {
            break;
        }
    }

    // Null-terminate the string in case there was no null character
    /*if (*charCount < *inputBufferSize) {
        (*inputBuffer)[*charCount] = '\0';
    } else {
        *inputBuffer = realloc(*inputBuffer, *inputBufferSize + 1);
        (*inputBuffer)[*charCount] = '\0';
    }
    */
}

// Function to split inputBuffer into words based on space and newline characters
char** findWords(const char* inputBuffer, size_t* wordCount, int wordStartArr[2048]) {
   *wordCount = 0;
    // Allocate space for more words than needed
    char** wordArr = malloc(sizeof(char*) * 1024); 
    if (!wordArr) {
        perror("Failed to allocate memory");
        exit(EXIT_FAILURE);
    }

    size_t bufferLen = strlen(inputBuffer);
    int wordStart = -1;

    // Find out each individual word
    for (size_t i = 0; i <= bufferLen; i++) {
        // Skip multiple spaces or newline characters
        if (isspace(inputBuffer[i]) || inputBuffer[i] == '\0') {
            // If we're at the end of a word, handle it
            if (wordStart != -1) {
                size_t wordLength = i - wordStart;
                wordArr[*wordCount] = malloc(wordLength + 1);
                if (!wordArr[*wordCount]) {
                    perror("Failed to allocate memory");
                    exit(EXIT_FAILURE);
                }
                strncpy(wordArr[*wordCount], inputBuffer + wordStart, wordLength);
                wordArr[*wordCount][wordLength] = '\0'; 
                (*wordCount)++;
                wordStart = -1; // Reset for the next word
            }
        } else if (wordStart == -1 && !isspace(inputBuffer[i]) && inputBuffer[i] != '\0') {
            // Mark the start of a new word
            wordStart = i;
            wordStartArr[(int)*wordCount] = (int)i;
        }
    }

    return wordArr;
}

// Function to count word occurrences and track the first occurrence position
void countWordOccurrences(char **wordArr, size_t wordCount, const char *inputBuffer, size_t totalBytesProcessed, int wordStartArr[]) {
    char **wordCountArr = malloc(sizeof(char*) * wordCount);
    int *countArr = malloc(sizeof(int) * wordCount);
    size_t *firstOccurrencePos = malloc(sizeof(size_t) * wordCount);
    size_t uniqueWordCount = 0;

    for (size_t i = 0; i < wordCount; i++) {
        int found = 0;

        // Ensure there is no confusion between substrings of other words 
        for (size_t j = 0; j < uniqueWordCount; j++) {
            if (strcmp(wordArr[i], wordCountArr[j]) == 0) {
                countArr[j]++;
                found = 1;
                break;
            }
        }

        // Only process the word if it hasn't been counted yet
        if (!found) {
            wordCountArr[uniqueWordCount] = wordArr[i];
            countArr[uniqueWordCount] = 1;
            // Find the first occurrence position of the word
            firstOccurrencePos[uniqueWordCount] = wordStartArr[i];
            uniqueWordCount++;
        }
    }

    // Print the table headers
    printf("%-10s%-10s%-10s%-s\n", "BEGIN", "LENGTH", "COUNT", "WORD");

    // Print the word counts along with their first occurrence positions
    for (size_t i = 0; i < uniqueWordCount; i++) {
        printf("%-10zu%-10zu%-10d%-s", firstOccurrencePos[i], strlen(wordCountArr[i]), countArr[i], wordCountArr[i]);
        if (i < uniqueWordCount) {
            printf("\n");
        }
    }

    // Print the last part
    printf("Total bytes processed: %zu\n", totalBytesProcessed);
    printf("Total Unique Words: %zu\n", uniqueWordCount);
    printf("Total words found: %zu\n", wordCount);

    // Free all the memory
    free(countArr);
    free(wordCountArr);
    free(firstOccurrencePos);
}

int main(void) {
    char *inputBuffer = NULL;
    size_t inputBufferSize = 0;
    size_t charCount = 0;
    int wordStartArr[2048];

    // Process the input and store it in the buffer
    processInput(&inputBuffer, &inputBufferSize, &charCount);
    //printf("%s", inputBuffer);
    
    // A little redundant but helps differentiate
    size_t totalBytesProcessed = charCount;

    // Find words in the input buffer
    size_t wordCount = 0;
    char **wordArr = findWords(inputBuffer, &wordCount, wordStartArr);

    // Count word occurrences
    countWordOccurrences(wordArr, wordCount, inputBuffer, totalBytesProcessed, wordStartArr);

    // Free the memory again
    free(wordArr);
    free(inputBuffer);

    return 0;
}