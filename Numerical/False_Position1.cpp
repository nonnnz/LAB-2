#include<bits/stdc++.h>

using namespace std;

double f(double x, double i, double n) {
    return pow(x, n) - i;
}

void false_position(double x, double n,double xl, double xr) {
    int iter = 0;
    double es = 0.000001; // Desired relative error tolerance
    double ea = 1; // Approximate relative error
    
    if (f(xl, x, n) * f(xr, x, n) >= 0) {
        cout << "f(xl) and f(xr) must be opposite in sign.";
        return;
    }
    
    double x1 = xl;
    double x1old = 0;
    while(ea >= es) {
        x1old = x1;

        // step 1 find x1
        x1 = (xl * f(xr, x, n) - xr * f(xl, x, n) ) / (f(xr, x, n) - f(xl, x, n));
        iter++;
        // if f(x1) is root
        if(f(x1, x, n) == 0) break;

        // step 4 check Coverage criteria
        ea = abs((x1-x1old)/x1)*100;

        // step 2 compute product; step 3 set new
        if (f(x1, x, n) * f(xr, x, n) > 0) xr = x1;
        else xl = x1;
    }
    double false_position = x1;
    cout << false_position;
}

int main() {
    cout << fixed << setprecision(6);
    int x=13, n=4;
    double xl=1.5, xr=2.0;

    false_position(x, n,xl, xr);

    return 0;
}