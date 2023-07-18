#include <bits/stdc++.h>

using namespace std;

double func(double x, double i, double n) {
    return pow(x, n) - i;
}

void bisection(double x, double n,double xl, double xr) {
    int iter = 0;
    double es = 0; // Desired relative error tolerance
    double ea = 0; // Approximate relative error
    
    if (func(xl, x, n) * func(xr, x, n) >= 0) {
        cout << "f(xl) and f(xr) must be opposite in sign.";
        return;
    }
    
    double xm = xl;
    double xmold = 0;
    while(1) {
        xmold = xm;
        // step 1 find middle point
        xm = (xl + xr) / 2;
        iter++;
        // if f(xm) is root
        if(func(xm, x, n) == 0) break;

        // step 4 check Coverage criteria
        ea = abs((xm-xmold)/xm)*100;
        if (ea <= es) break;
        // cout << iter << ": " << "f(" << xm << ") = " << func(xm, x, n) << " ES = " << ea << "% ; " << xl << " -> " << xr << endl;

        // step 2 compute product; step 3 set new
        if (func(xm, x, n) * func(xr, x, n) > 0) xr = xm;
        else xl = xm;
    }
    double bisect = xm;
    cout << bisect;
}

int main() {
    cout << fixed << setprecision(4);
    int x, n;
    double xl, xr;
    cin >> x >> n;
    // 0 <= xl <= xr <= 1000000
    xl = 0;
    xr = 1000000;

    bisection(x, n,xl, xr);

    return 0;
}