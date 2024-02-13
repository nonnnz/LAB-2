#include <bits/stdc++.h>

using namespace std;

int maxCrossingSum(int a[], int l, int m, int h) {
    int sum = 0;
    int left_sum = -100;
    for(int i = m-1; i >= l; i--) {
        sum += a[i];
        if(sum > left_sum) left_sum = sum;
        // cout<<left_sum<<" "<<sum<<endl;
    }
    sum = 0;
    int right_sum = -100;
    for(int i = m+1; i <= h; i++) {
        sum += a[i];
        if(sum > right_sum) right_sum = sum;
    }
    return max(left_sum + right_sum + a[m], 
    max(left_sum, right_sum));
}

int maxSubArraySum(int a[], int l, int h) {
    if(l > h) return INT_MIN;
    if(l == h) return a[l];
    int m = (l + h) / 2;
    return max(maxSubArraySum(a, l, m-1), 
    max(maxSubArraySum(a, m+1, h), 
    maxCrossingSum(a, l, m, h)));
}

int main() {
    // int a[] = {2, -4, 1, 9, -6, 7, -3};
    // int a[] = {-1, -3, -4, -5, -9};
    // int n = sizeof(a) / sizeof(a[0]);
    int n;
    cin>>n;
    int a[n];
    for(int i = 0; i < n; i++) cin>>a[i];
    int max_sum = maxSubArraySum(a, 0, n-1);
    cout<<max_sum;
    return 0;
}