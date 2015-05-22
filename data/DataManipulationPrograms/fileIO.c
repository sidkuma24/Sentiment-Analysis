#include <stdio.h>
#include <string.h>

char buffer[4096];
static int readSenID = 0;
static int newSenID = 0;
char polarity[5];
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
    
    
  /*  while((fscanf(fptr,"%d %s %s",readSenID,polarity,buffer)) > 0){
       newSenID++;
       fprintf(stdout,"%d\t%s\t%s\n",newSenID,polarity,buffer);
       fprintf(fptr2,"%d\t%s\t%s",newSenID,polarity,buffer);
    }*/
    char dump[4096];
    int offset;
  while((fgets(buffer,sizeof(buffer),fptr)) != NULL){
     offset = -(sizeof(buffer));
     fseek(fptr, offset, SEEK_CUR);
     fgetline(fptr);
   
  }

 fclose(fptr);

return 0;
}

void fgetline(FILE *fptr)
{
    int l_senID, l_polarity;
    fscanf(fptr,"%d %s",&l_senID, l_polarity);
    fgets(buffer,sizeof(buffer),fptr);

    printf("SentenceID: %d\n SentencePolarity: %s\n Text: %s\n",
                            l_senID,l_polarity,buffer);
}
