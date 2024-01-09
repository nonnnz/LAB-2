#include <bits/stdc++.h>

using namespace std;

int power(int a, int n) {
    if(n == 1) return a;
    int m = n / 2;
    int y = power(a, m);
    int x = y * y;
    return (n % 2 == 0) ? x : x * a;
}

int main() {
    int a, n;
    cin>>a>>n;

    cout<<power(a, n)<<" ";
    if(n % 2 == 0) cout<<n/2;
    else cout<<n/2+1;

    return 0;
}