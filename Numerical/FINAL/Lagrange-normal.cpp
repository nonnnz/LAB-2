#include <bits/stdc++.h>

using namespace std;

double lagange(double* x, double* y, int n, double find) {
    double result = 0.0;
    for (int i = 0; i < n; i++) {
        double term = 1;
        for (int j = 0; j < n; j++) {
            if(i!=j)
            term *= (x[j] - find) / (x[j]-x[i]);
        }
        result += term * y[i];
    }

    return result;
}

int main() {
    int n = 5; 
    double x[n] = {0, 20000, 40000, 60000, 80000};  
    double y[n] = {9.81, 9.7487, 9.6879, 9.6879, 9.5682};  

    double find = 42235;  

    double interpolatedValue = lagange(x, y, n, find);
    
    cout << "x = " << find << "; y = " << interpolatedValue << endl;

    return 0;
}
