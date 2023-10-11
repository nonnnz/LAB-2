import sympy as sp

def removeZero(num):
    num = round(num*1000000)
    num = float(num / 1000000)
    return num

def multiLinearRegression(x, y, find):
    m = len(x) # order
    n = len(x[0])
    a = [[None for i in range(m+2)] for j in range(m+1)]
    for i in range(m+1):
        _sumP = 0
        for l in range(0,n):
            if(i>0):_sumP = _sumP + x[i-1][l] * x[i-1][l]
        if(i>0):a[i][i] = _sumP
        else:a[i][i] = n
        for j in range(0,i):
            _sum = 0
            for l in range(0,n):
                if(j>0):_sum = _sum + x[i-1][l] * x[j-1][l]
                else:_sum = _sum + x[i-1][l]
            a[i][j] = _sum 
            a[j][i] = _sum
        _sum = 0
        for l in range(0,n):
            if(i > 0): _sum = _sum + y[l] * x[i-1][l]
            else: _sum = _sum + y[l]
        a[i][m+1] = _sum
    print(a)
    mt = sp.Matrix(a)
    m_rref, pivots = mt.rref() # reduced row echelon form
    rref_numeric = m_rref.evalf()
    print(rref_numeric)
    eq = []
    for i in range(1,m+2):
        eq.append(rref_numeric[(m+1)*i+(i-1)])
        print(f'a[{i-1}] = {removeZero(eq[i-1])}')
    ans = 0
    for i in range(m+1):
        if(i>0):ans += removeZero(eq[i])*find[i-1]
        else:ans += removeZero(eq[i])
    print("f(x)= ", end='')
    for i in range(m+1):
        if(i==0):print(f'{removeZero(eq[i])}', end='')
        else:print(f' + {removeZero(eq[i])}*x{i}', end='')
    print()




#======= given =======
x = [[1,0,2,3,4,2,1], [0,1,4,2,1,3,6], [1,3,1,2,5,3,4]]
y = [4,-5,-6,0,-1,-7,-20]
find = [1,1,1]
multiLinearRegression(x,y,find)