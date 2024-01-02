#include <bits/stdc++.h>

using namespace std;

pair<long long, int> power(int base, int exp) {
    if(exp == 0) return {1, 0};

    auto halfPower = power(base, exp/2);

    long long result = halfPower.first * halfPower.first;
    cout<<halfPower.first<<" "<<halfPower.second<<endl;
    int count = halfPower.second;

    if(exp % 2 == 1) {
        result *= base;
        count++;
    }

    return {result, count};
}

int main() {
    int a, n;
    cin>>a>>n;

    auto result = power(a, n);

    cout<<result.first<<" "<<result.second<<endl;

    return 0;
}