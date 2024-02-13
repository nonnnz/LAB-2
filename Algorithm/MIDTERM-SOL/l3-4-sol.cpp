#include <bits/stdc++.h>

using namespace std;

#define MIN -10000000;

int maxSum(int nums[], int low, int high) {
    if(low == high) return nums[low];

    int mid = (low + high) / 2;
    int left_sum = maxSum(nums, low, mid);
    int right_sum = maxSum(nums, mid+1, high);

    int max_left_right = max(left_sum, right_sum);

    int left_max = MIN;
    int right_max = MIN;
    int sum = 0;
    for(int i = mid; i >= low; i--) {
        sum += nums[i];
        left_max = max(left_max, sum);
    }
    sum = 0;
    for(int i = mid+1; i <= high; i++) {
        sum += nums[i];
        right_max = max(right_max, sum);
    }
    int mid_sum = left_max + right_max;
    return max(max_left_right, mid_sum);
}

int main() {
    // int a[] = {2, -4, 1, 9, -6, 7, -3};
    // int a[] = {-1, -3, -4, -5, -9};
    // int a[] = {-1, -1, 9, 9, -1, -1};
    // int n = sizeof(a) / sizeof(a[0]);
    int n;
    cin>>n;
    int a[n];
    for(int i = 0; i < n; i++) cin>>a[i];
    int max_sum = maxSum(a, 0, n-1);
    cout<<max_sum;
    return 0;
}