#include<bits/stdc++.h>

using namespace std;

double f(double x, double i, double n) {
    return pow(x, n) - i;
}

void false_position(double x, double n,double xl, double xr) {
    int iter = 0;
    double es = 0.000001; // Desired relative error tolerance
    double ea = 0; // Approximate relative error
    
    if (f(xl, x, n) * f(xr, x, n) >= 0) {
        cout << "f(xl) and f(xr) must be opposite in sign.";
        return;
    }
    
    double x1 = xl;
    double x1old = 0;
    while(1) {
        x1old = x1;
        // cout << "f(xr) = " << f(xr, x, n) << "; f(xl) = " << f(xl, x, n) << endl;
        // step 1 find x1
        x1 = (xl * f(xr, x, n) - xr * f(xl, x, n) ) / (f(xr, x, n) - f(xl, x, n));
        iter++;
        // if f(x1) is root
        if(f(x1, x, n) == 0) break;

        // step 4 check Coverage criteria
        ea = abs((x1-x1old)/x1)*100;
        if (ea <= es) {
            cout << "pass" << endl;
            break;
        }
        cout << iter << ": " << "f(" << x1 << ") = " << f(x1, x, n) << " ES = " << ea << "% ; " << xl << " -> " << xr << endl;

        // step 2 compute product; step 3 set new
        if (f(x1, x, n) * f(xr, x, n) > 0) xr = x1;
        else xl = x1;
    }
    double false_position = x1;
    cout << false_position;
}

int main() {
    cout << fixed << setprecision(6);
    int x, n;
    double xl, xr;
    cin >> x >> n >> xl >> xr;

    false_position(x, n,xl, xr);

    return 0;
}