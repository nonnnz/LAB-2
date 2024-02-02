#include <stdio.h>

#define max(x, y)  (x>y?x:y)

int max_sum(int nums[], int low, int high) {
    // conquer step
    if (low == high)
        return nums[low];
   
    //  divide step
    int mid = (low + high) / 2;                  
    int Lsum = max_sum(nums, low, mid);                
    int Rsum = max_sum(nums, mid+1, high);
   
    //  combine step  
    int max_left_right = max(Lsum, Rsum);     // compare max seq. from left  and max from right
 
    int left_max  = -10000;
    int right_max = -10000;
    int sum = 0;
    for (int i = mid; i >= low; i--) {          // cross sum from mid to low
        sum += nums[i];
        left_max = max(left_max, sum);
    }
    sum = 0;
    for (int i = mid + 1; i <= high; i++) {       //cross sum from mid +1 to high
        sum += nums[i];
        right_max = max(right_max, sum);
    }
     
    return max(left_max + right_max, max_left_right);       // compare cross sum and max_left_right
}
