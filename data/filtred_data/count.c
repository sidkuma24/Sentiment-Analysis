#include<stdio.h>
#include<string.h>

int main(){
    FILE *fptr = fopen("count.txt","w");
    int i = 0;
    for(i=1;i<=2000;i++){
        fprintf(fptr,"%d\n",i);
    }
}
