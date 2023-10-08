#include <bits/stdc++.h>

using namespace std;

double splineLinear(vector<double> x, vector<double> y, double find) {
    for (int i = 0; i < x.size() - 1; i++) {
        if (find >= x[i] && find <= x[i + 1]) {
            return y[i] + (y[i + 1] - y[i]) / (x[i + 1] - x[i]) * (find - x[i]);
        }
    }
    return 0;
}

int main() {
    vector<double> x = {2, 4, 6, 8, 10};
    vector<double> y = {9.5, 8, 10.5, 39.5, 72.5};
    double find = 4.5;

    cout << splineLinear(x, y, find) << endl;
    
    return 0;
}
