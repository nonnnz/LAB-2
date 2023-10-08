def splineLinear(x, y, find):
    for i in range(len(x)-1):
        if(find >= x[i] and find <= x[i+1]):
            return y[i] + (y[i+1]-y[i])/(x[i+1]-x[i]) * (find-x[i])

x = [2, 4, 6, 8, 10]
y = [9.5, 8, 10.5, 39.5, 72.5]
find = 4.5
print(splineLinear(x, y, find))