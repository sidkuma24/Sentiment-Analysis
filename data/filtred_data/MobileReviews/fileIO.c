#include <stdio.h>
#include <string.h>

char buffer[4096];
static int senID = 134;
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
    
    
    while((fgets(buffer,sizeof(buffer),fptr)) != NULL){
       fprintf(stdout,"%s",buffer);
       
        senID++;
        fprintf(fptr2,"%d\t%s\t%s",senID,"pos",buffer);
    }

 fclose(fptr);

return 0;
}
