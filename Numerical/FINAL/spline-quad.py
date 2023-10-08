def splineQuad(x, y, find):
    n_Unknown = 3 * (len(x)-1)
    a = [[]]
    



x = [2, 4, 6, 8, 10]
y = [9.5, 8, 10.5, 39.5, 72.5]
find = 4.5
print(splineQuad(x, y, find))