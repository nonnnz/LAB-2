import sympy as sp
import math

def f(x):
    return math.exp(x);

def divided_differnces(x, h, order, mt, oh):
    # true value
    x_sp = sp.symbols('x')
    func = sp.exp(x_sp)

    true_derivative = sp.diff(func,x_sp,order)
    expr_with_substitution = true_derivative.subs(x_sp, x)
    true_value = sp.N(expr_with_substitution)
    if order == 1:
        if mt == "fwd" and oh == 1:
            df = (f(x+(h*1))-f(x+(h*0)))/h
        elif mt == "bwd" and oh == 1:
            df = (f(x+(h*0))-f(x+(h*-1)))/h
        elif mt == "central" and oh == 2:
            df = (f(x+(h*1))-f(x+(h*-1)))/(2*h)
    elif order == 2:
        if mt == "fwd" and oh == 2:
            df = (-f(x+(h*3))+4*f(x+(h*2))-5*f(x+(h*1))+2*f(x+(h*0)))/math.pow(h,2)
        elif mt == "bwd" and oh == 2:
            df = (2*f(x+(h*0))-5*f(x+(h*-1))+4*f(x+(h*-2))-f(x+(h*-3)))/math.pow(h,2)
        elif mt == "central" and oh == 4:
            df = (-f(x+(h*2))+16*f(x+(h*1))-30*f(x+(h*0))+16*f(x+(h*-1))-f(x+(h*-2)))/(12*math.pow(h,2))
    error = (abs(df-true_value)/true_value) * 100
    return df, error

x = 2
h = 0.25

print(f'{round(divided_differnces(x,h,1,"fwd",1)[0],6)} et= {round(divided_differnces(x,h,1,"fwd",1)[1],6)}%')
print(f'{round(divided_differnces(x,h,1,"bwd",1)[0],6)} et= {round(divided_differnces(x,h,1,"bwd",1)[1],6)}%')
print(f'{round(divided_differnces(x,h,1,"central",2)[0],6)} et= {round(divided_differnces(x,h,1,"central",2)[1],6)}%')
