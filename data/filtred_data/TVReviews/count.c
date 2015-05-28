#include<stdio.h>
#include<stdlib.h>
int main()
{
  FILE *fptr;
   fptr = fopen("FilteredTVReviews.txt","w");
  int i = 0;
   for(i=1;i<=227;i++){fprintf(fptr,"%d\n",i);}
  return 0;

}
