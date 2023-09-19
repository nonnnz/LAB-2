def divided_difference(x, f):
    n = len(x)
    if n == 1:
        return f[0]
    else:
        return (divided_difference(x[1:], f[1:]) - divided_difference(x[:-1], f[:-1])) / (x[-1] - x[0])


def interpolating_polynomial(x, f):
    n = len(x)
    if n == 1:
        return [f[0]]
    else:
        divided_diff = divided_difference(x, f)
        rest_of_coefficients = interpolating_polynomial(x[1:], f)
        return [divided_diff] + [rest_of_coefficients[i] * (x[0] - x[i+1]) for i in range(n - 1)]


# Example usage
x_values = [0, 20000]
f_values = [9.81, 9.7487]
coefficients = interpolating_polynomial(x_values, f_values)
print("Coefficients of the interpolating polynomial:", coefficients)
