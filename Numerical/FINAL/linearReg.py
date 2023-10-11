import sympy as sp

def removeZero(num):
    num = round(num*1000000)
    num = float(num / 1000000)
    return num

def polyRegression(m, x, y, find):
    n = len(x)
    a = [[None for i in range(m+2)] for j in range(m+1)]
    a[0][0] = n # begin
    _sum = 0
    for i in range(0, n):
        _sum += pow(x[i], 2*m)
    a[m][m] = _sum # end
    for i in range(m+1):
        for j in range(0,i):
            k = i + j 
            _sum = 0
            for l in range(0,n):
                _sum = _sum + pow(x[l],k)
            if(i > 1 and (k%2==0)): a[i-1][i-1] = _sum
            a[i][j] = _sum 
            a[j][i] = _sum 
        _sum = 0
        for l in range(0,n):
            _sum = _sum + y[l] * pow(x[l], i)
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
        ans += eq[i]*pow(find,i)
    print(removeZero(ans))



#======= given =======
m = 1 # order
x = [10, 15, 20, 30, 40, 50, 60, 70, 80]
y = [5, 9, 15, 18, 22, 30, 35, 38, 43]
find = 65
polyRegression(m,x,y,find)