#include<bits/stdc++.h>

using namespace std;

// g(x) (1/4.0)+(x/2.0)
double f2(double x) {
    return 1/(pow(x,9)-1);
}

void onept(double x0, double es) {
    double x = x0, ea = 100, xold;
    int iter = 0;
    while(ea > es) {
        if(iter > 1000) break;
        xold = x;
        x = f2(xold);
        iter++;
        if(x != 0) ea = abs((x-xold)/x)*100;
        else ea=0;
        cout << "iterations " << iter << " : " << "x" << iter << " = " << x << " ea = " << ea << " % " << endl;
        if(x == xold) break;
    }
    double onept = x;
    cout << onept;
}

int main() {
    cout << fixed << setprecision(6);
    onept(0, 0.000001);
    return 0;
}
