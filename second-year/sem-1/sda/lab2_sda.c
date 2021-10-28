#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>


typedef struct
{
    int cod;
    char denumire[350];
}work;

void afisare(work *a, int nr)
{
    int i;
    for(i=0;i<nr;i++)
    {
        printf("%d %s\n", a[i].cod, a[i].denumire);
    }
}

void gasire_cod(work *a, int n, int cod_cautat)
{
    int s=0;
    int d=n-1;
    int gasit=0;
    while(s<=d)
    {
        int m=(s+d)/2;
        if(cod_cautat==a[m].cod)
        {
            printf("%s\n" ,a[m].denumire);
            gasit=1;
            break;
        }
        else
        {
            if(a[m].cod<cod_cautat)
            {
                d=m-1;
            }
            else
            {
                s=m+1;
            }
        }
    }
    if(gasit!=1)
        printf("Cod inexistent\n");
}

void gasire_job(work *a, int n, char *ocupatie)
{
    int OK,i,j;
    for(i=0;i<n;i++)
    {
        if(strstr(a[i].denumire,ocupatie)!=NULL)
        {
            OK=1;
            for(j=0;j<strlen(ocupatie);j++)
            {
                if(a[i].denumire[j]!=ocupatie[j])
                {
                    OK=0;
                    break;
                }
            }
            if(OK==1) printf("%s\n",a[i].denumire);
        }
    }
}



work a[5000];
int main()
{
   int nr=0;
   FILE *fisier =fopen("COR_Descrescator.txt","r");
   char linie[349];
   fgets(linie,349,fisier);
   while(fgets(linie,349,fisier)!=NULL)
   {
       char *p;
       p=strtok(linie,"\t");
       while(p!=NULL)
       {
           int cifre=atoi(p);
           if(cifre!=0)
           {
               a[nr].cod=cifre;
           }
           else{
            strcpy(a[nr].denumire,p);
            a[nr].denumire[strcspn(a[nr].denumire,"\n")-1]=0;
           }
           p=strtok(NULL,linie);
       }
       nr++;
   }

   /*afisare(a,nr);
   gasire_cod(a,nr,962401);*/
   gasire_job(a,nr,"curier");
   return 0;
}
