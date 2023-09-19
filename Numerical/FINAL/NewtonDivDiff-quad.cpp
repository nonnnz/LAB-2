#include <bits/stdc++.h>

using namespace std;

double dividedDifference(double* x, double* y, int i, int j) {
    if (i == j) {
        return y[i];
    } else {
        return (dividedDifference(x, y, i + 1, j) - dividedDifference(x, y, i, j - 1)) / (x[j] - x[i]);
    }
}

double interpolate(double* x, double* y, int n, double find) {
    double result = 0.0;
    for (int i = 0; i < n; i++) {
        double term = dividedDifference(x, y, 0, i);
        for (int j = 0; j < i; j++) {
            term *= (find - x[j]);
        }
        result += term;

        // Print 
        cout << i << "\t" << x[i] << "\t" << y[i];

        for (int j = 1; j <= i ; j++) {
            int i_c = i-j;
            cout<<"\t" <<"f[";
            for (int k = i_c+j; k > i_c; k--) cout << "x" <<k <<", ";
            cout<< "x" <<i_c<<"] = ";
            cout<<dividedDifference(x, y, i_c, i_c+j);
        }
        cout << endl;
    }
    return result;
}

int main() {
    int n = 3; 
    double x[n] = {0, 40000, 80000};  
    double y[n] = {9.81, 9.6879, 9.5682};  

    double find = 42235;  

    cout << "i" << "\t" << "xi" << "\t" << "f(xi)";
    
    for (int j = 1; j < n; j++) {
        cout << "\t" << "D" << j;
    }
    cout << endl;

    cout << string(60, '-') << endl;

    double interpolatedValue = interpolate(x, y, n, find);
    
    cout << "x = " << find << "; y = " << interpolatedValue << endl;

    return 0;
}
