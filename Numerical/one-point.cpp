#include<bits/stdc++.h>

using namespace std;

// f(x) = e^-x -x
double f(double x) {
    return exp(-x) - x;
}
// g(x) = e^-x
double f2(double x) {
    return exp(-x);
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
        cout << "iterations " << iter << " : " << "x" << iter << " = " << x << " ea = " << ea << " % " << "f(x) = " << f(x) << endl;
        if(x == xold) break;
    }
    double onept = x;

}

int main() {
    cout << fixed << setprecision(6);
    onept(0.01);
    return 0;
}
