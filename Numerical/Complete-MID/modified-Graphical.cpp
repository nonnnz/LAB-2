#include <bits/stdc++.h>

using namespace std;

double func(double x) {
    return (43 * x) - 180;
}

void graphical() {
    double xl = 0;
    double xr = 0;
    double r_prev = func(xl);
    double r = r_prev;
    while(xl < 10) { // 0 <= x <= 10
        xr = xl + 1;
        r = func(xr);

        if ((r >= 0 && r_prev < 0) || (r < 0 && r_prev >= 0)) {
            if (r == 0) {
                cout << xr;
                break;
            }
            break;
        }

        r_prev = r;
        xl = xr;
    }
    // now xl = 4, xr = 5 (-8, 35)
    // xl = 4.186;
    while(r != 0) {
        xr = xl + 0.000001;
        r = func(xr);
        if ((r >= 0 && r_prev < 0) || (r < 0 && r_prev >= 0)) {
            // check closest to zero
            if(abs(r) < abs(r_prev)) { 
                cout << "x = " << xr << ", " << "f(x) = "<< r;
            } else cout << "x = " << xl << ", " << "f(x) = "<< r_prev;
            break;
        }
        cout << "x = " << xr << ", " << "f(x) = "<< r << endl;
        r_prev = r;
        xl = xr;
    }
}

int main() {
    cout << fixed << setprecision(6);

    graphical();

    return 0;
}