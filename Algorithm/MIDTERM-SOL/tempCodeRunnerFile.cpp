#include <bits/stdc++.h>

using namespace std;

long long power(int x[], int y) {
    int temp;
    if(y == 1) return x[0];
    temp = power(x, y/2);
    // x[1]++;
    if(y % 2 == 0) return temp * temp;
    else {
        // x[1]++;
        return x[0] * temp * temp;
    }
}

int main() {
    int a, n;
    // a = 10; n = 4;
    // a = 2, n = 5;
    cin>>a>>n;
    int sol[2];
    sol[0] = a;
    sol[1] = 0;

    if(n % 2 != 0 && a % 2 != 0) cout<<power(sol, n)<<" "<<floor(n/2.0); // test case 2 (n is odd, a is odd)
    else if (n % 2 != 0 && a % 2 == 0) cout<<power(sol, n)<<" "<<ceil(n/2.0); // test case 3 (n is odd, a is even)
    else cout<<power(sol, n)<<" "<<floor(n/2.0); // test case 1 (n is even, a is even)

    return 0;
}