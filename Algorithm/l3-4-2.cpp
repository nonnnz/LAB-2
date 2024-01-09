#include <bits/stdc++.h> 

using namespace std; 

#define MIN -10000000;

int maxSubArraySum(int a[], int l, int r) {
    if(l > r) return MIN;
    if(l == r) return a[l];
    int mid = (l + r) / 2;
    int max_left = maxSubArraySum(a, l, mid-1);
    int max_right = maxSubArraySum(a, mid+1, r);

    int max_left_sum = MIN; 
    int max_right_sum = MIN;
    for(int i = mid-1, sum = 0; i >= l; i--) {
        sum += a[i];
        max_left_sum = max(max_left_sum, sum);
    }
    for(int i = mid+1, sum = 0; i <= r; i++) {
        sum += a[i];
        max_right_sum = max(max_right_sum, sum);
    }
    // cout<<max_left_sum<<" "<<max_right_sum<<endl;
    int max_mid_sum = max(max_left_sum + max_right_sum + a[mid],max(max_left_sum + a[mid], max_right_sum + a[mid]));
    // cout<<max_left<<" "<<max_right<<" "<<max_mid_sum<<endl;
    return max(max(max_left, max_right), max_mid_sum);
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
    int max_sum = maxSubArraySum(a, 0, n-1);
    cout<<max_sum;
    return 0;
}