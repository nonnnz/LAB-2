#include <bits/stdc++.h>

using namespace std;

// f(x) = x^2-7
double f(double x) {
    return x * x - 7;
}

// f'(x) = 2x
double df(double x) {
    return 2 * x;
}

double newtonRaphson(double x0, double es) {
    double x = x0, ea = 100, xold;
    int iter = 0;
    while(ea > es) {
        xold = x;
        x = x - f(x) / df(x);
        iter++;
        if(x != 0) ea = abs((x - xold) / x) * 100;
        else ea = 0;
        cout << "iterations " << iter << " : " << "x" << iter << " = " << x << " ea = " << ea << " % " << "f(x) = " << f(x) << endl;
    }
    return x;
}

int main() {
    cout << fixed << setprecision(6);
    cout << newtonRaphson(2.0, 0.000001)<< endl;

    return 0;
}
