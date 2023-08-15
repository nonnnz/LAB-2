#include <bits/stdc++.h>

using namespace std;

// f(x) = x^2-7
double f(double x) {
    return x * x - 7;
}

double secant(double x0, double x1, double es) {
    double x2, ea = 100;
    int iter = 0;
    while(ea > es) {
        x2 = x1-((f(x1)*(x0-x1))/(f(x0)-f(x1)));

        iter++;
        if(x2 != 0) ea = abs((x2 - x1) / x2) * 100;
        else ea = 0;
        cout << "iterations " << iter << " : " << endl;
        cout << "x" << iter-1 << " = " << x0 << " f(" <<  "x" << iter-1 << ")" << " = " << f(x0) << endl;
        cout << "x" << iter << " = " << x1 << " f(" << "x" << iter << ")" << " = " << f(x1) << endl;
        cout << "x" << iter + 1 << " = " << x2 << " ea = " << ea << " % " << "f(x) = " << f(x2) << endl;

        x0=x1;
        x1=x2;
    }
    return x2;
}

int main() {
    cout << fixed << setprecision(6);
    cout << secant(1.0, 2.0, 0.000001)<< endl;

    return 0;
}
