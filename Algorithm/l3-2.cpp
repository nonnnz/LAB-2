#include <bits/stdc++.h>

using namespace std;

double power(int a, int l, int r) {
    if(r == 0) return 1;
    if(l == r) return a;
    int m = (l + r) / 2;
    double  m1 = power(a, l, m);
    double  m2 = power(a, m+1, r);

    return m1 * m2;
}

int main() {
    int a, n;
    cin>>a>>n;

    cout<<power(a, 1, n)<<" "<<ceil(n/2.0);
    return 0;
}