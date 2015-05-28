#include<stdio.h>
#include<stdlib.h>
int main()
{
  FILE *fptr;
   fptr = fopen("FilteredMobileReviews.txt","w");
  int i = 0;
   for(i=1;i<=1336;i++){fprintf(fptr,"%d\n",i);}
  return 0;

}
