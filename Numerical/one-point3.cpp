#include<bits/stdc++.h>

using namespace std;

// g(x) = sqrt(7)
double f2(double x) {
    return sqrt(7);
}

void onept(double x0) {
    double x = x0;
    int iter = 0;
    double es = 0.000001;
    double ea = 1;
    double xold;
    while(ea > es) {
        xold = x;
        x = f2(xold);
        iter++;
        if(x != 0) ea = abs((x-xold)/x)*100;
        if(x == xold) break;
    }
    double onept = x;
    cout << onept;
}

int main() {
    cout << fixed << setprecision(6);
    onept(0);
    return 0;
}
