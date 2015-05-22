#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAX_BUFFER_SIZE 4096

 int bufferChars = 0;
 char *cmdArgv[MAX_BUFFER_SIZE];
 int cmdArgc = 0;
 char buffer[MAX_BUFFER_SIZE];
 long long int total_token_count = 0;
int s_token_count = 0;
int n_sentences = 0;
char dump[MAX_BUFFER_SIZE];
void populateCmd()
{
        char* bufferPointer;
          // printf("%s",buffer);
        bufferPointer = strtok(buffer, " ");
           // printf("\n1:%s",bufferPointer);
        while (bufferPointer != NULL) {
                   //printf("\n2:%s",bufferPointer);
                cmdArgv[cmdArgc] = bufferPointer;
                bufferPointer = strtok(NULL, " ");
                cmdArgc++;
        }
 
}

void fgetline(FILE *fptr)
{
    int l_senID;
    fscanf(fptr,"%d %s",&l_senID,polarity);
    fgets(buffer,sizeof(buffer),fptr);

    printf("SentenceID: %d\n SentencePolarity: %s\n Text: %s\n",
                            l_senID,polarity,buffer);
    
}

int main(int argc, char **argv)
{
    FILE *fptr, *fptr2;
   
    if((fptr = fopen(argv[1],"r")) == NULL){
             fprintf(stderr,"\nError could not open the file %s",argv[1]);
    }
      if((fptr2 = fopen(argv[2],"w")) == NULL){
             fprintf(stderr,"\nError could not open the file %s",argv[2]);
    }
    int i = 0;

    while(fgets(dump,MAX_BUFFER_SIZE,fptr)){
       n_sentences++;
    }
     printf("\n");
     printf("total no of sentences: %d\n",n_sentences);
    fseek(fptr,0,SEEK_SET);
    
    
