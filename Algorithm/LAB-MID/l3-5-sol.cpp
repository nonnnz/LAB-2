#include<stdio.h>

#define MAXSIZE 100001

void main()
{  int arr[MAXSIZE], arr2[MAXSIZE];
   int n, i, j, x=0, max=0;

   memset(arr, 0, sizeof(arr));
   memset(arr2, 0, sizeof(arr2));

   scanf("%d", &n);

   while(n > 0)
    { scanf("%d %d", &i, &j);
      arr[i] = arr[i]+1;
      arr[j+1] = arr[j+1]-1;
      if(j+1 > x)
        x = j + 1;
      n--;
    }

  for(i=0; i <= x; i++)
   { arr[i+1] += arr[i];
     if(arr[i] > max)
         max = arr[i];
   }

  for(j=0, i=0; i <= x; i++)
     { if(arr[i] == max)
         { arr2[j] = i;
           j++;
         }
     }

  int start = arr2[0];
  i=0;

  while((arr2[i+1]-arr2[i] < 2) && (i < j) )
    i++;

  int end = arr2[i-1];

  if(i < j)
    end = arr2[i];

  printf("%d %d %d", start, end, max);
}
