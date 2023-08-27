import autograd.numpy as np
from autograd import grad
from sympy import symbols, diff
from math import log

def f(x):
    return 3*x**2 + 2*x + 1

f_prime = grad(f)

x = 2
result = f_prime(x)
print(result)