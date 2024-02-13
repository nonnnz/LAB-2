#include <bits/stdc++.h>

using namespace std;

int find(int a[], int l, int r, int k) {
    if(l > r) return -1;

    if(l == r) return (a[l] == k) ? 1 : -1;

    int m = (l + r) / 2;
    int lc = find(a, l, m, k);
    int rc = find(a, m+1, r, k); 

    if(lc != -1 || rc != -1)
        return (lc == -1 ? 0 : lc) + (rc == -1 ? 0 : rc);
    return -1;
}

int main() {
    // int a[] = {5,2,5,6,6,5,6};
    // int n = sizeof(a)/sizeof(a[0]);
    // int target = 5;
    int n, target;
    cin>>n>>target;
    int a[n];
    for(int i=0; i<n; i++) cin>>a[i];

    cout<<find(a, 0, n, target);
    return 0;
}