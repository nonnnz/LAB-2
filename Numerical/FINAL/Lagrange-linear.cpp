#include <bits/stdc++.h>

using namespace std;

double term(double* x, double find, int i, int j) {
    if (j == -1) 
        return 1;
    else if (i == j)
        return term(x, find, i, j - 1);
    else 
        return ((x[j] - find) / (x[j] - x[i])) * term(x, find, i, j - 1);
}

double lagange(double* x, double* y, int n, double find) {
    double result = 0;
    for (int i = 0; i < n; i++) {
        result += term(x, find, i, n-1) * y[i];
    }
    return result;
}

int main() {
    int n = 2; 
    double x[n] = {0, 80000};  
    double y[n] = {9.81, 9.5682};  

    double find = 42235;  

    double interpolatedValue = lagange(x, y, n, find);
    
    cout << "x = " << find << "; y = " << interpolatedValue << endl;

    return 0;
}
