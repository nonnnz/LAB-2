#include <bits/stdc++.h>

using namespace std;

double func(double x) {
    return pow(x, 4) - 13;
}

void bisection(double xl, double xr) {
    int iter = 0;
    double es = 0;
    double ea = 100;
    
    if (func(xl) * func(xr) >= 0) {
        cout << "f(xl) and f(xr) must be opposite in sign.";
        return;
    }
    
    double xm = xl;
    double xmold = xm;
    while(1) {
        xmold = xm;
        // step 1 find middle point
        xm = (xl + xr) / 2;
        iter++;
        // if f(xm) is root
        if(func(xm) == 0) break;

        // step 2 compute product; step 3 set new
        
        if (func(xm) * func(xr) > 0) xr = xm;
        else xl = xm;

        // step 4 check Coverage criteria
        ea = abs((xm-xmold)/xm)*100;
        if (ea <= es) break;
        cout << iter << ": " << "f(" << xm << ") = " << func(xm) << " ES = " << ea << "% ; " << xl << " -> " << xr << endl;
    }
    double bisect = xm;
    cout << bisect;
}

int main() {
    cout << fixed << setprecision(6);

    bisection(1.5, 2.0);

    return 0;
}