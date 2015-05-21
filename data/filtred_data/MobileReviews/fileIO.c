#include <stdio.h>
#include <string.h>

char buffer[4096];
static int readSenID = 0;
static int newSenID = 134;
char polrity[5];
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
    fseek(fptr,0,SEEK_SET);
    
    
    while((fscanf(fptr,"%d %s %s",&readSenID,polarity,buffer)) != NULL){
       newSenID++;
       fprintf(stdout,"%d\t%s\t%s\n",newSenID,polarity,buffer);
       fprintf(fptr2,"%d\t%s\t%s",newSenID,polarity,buffer);
    }

 fclose(fptr);

return 0;
}
