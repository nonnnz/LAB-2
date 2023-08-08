#include <iostream>
#include <cmath>

double calculateLnUsingTaylorSeries(double x, double x0, int n) {
    double result = 0.0;
    double term = 1.0;

    for (int i = 1; i <= n; ++i) {
        term *= (x - x0) / x0;
        result += term / i;
    }

    return result;
}

int main() {
    double x = 4.0;
    double x0 = 2.0;

    std::cout << "Calculating ln(" << x << ") using Taylor series expansion around x0 = " << x0 << "\n\n";

    for (int n = 0; n <= 3; ++n) {
        double approximation = calculateLnUsingTaylorSeries(x, x0, n);
        double actualValue = std::log(x);
        double error = std::abs(approximation - actualValue);

        std::cout << "N = " << n << ", Approximation = " << approximation << ", Error = " << error << "\n";
    }

    return 0;
}
