import numpy as np
import math

a = [
    [5, 2, 0, 0],
    [2, 5, 2, 0],
    [0, 2, 5, 2],
    [0, 0, 2, 5]]

b = [12, 17, 14, 7]

es = 0.001

x = [0, 0, 0, 0]

def cg(a, b, x, es):
    k = 0
    r = np.dot(a,x) - b
    d = -r
    error = 1
    print("ITER\tX1\tX2\tX3\tX4\tError",)
    while(error >= es):
        dtr = np.dot(np.transpose(d), r)
        dtad = np.dot(np.dot(np.transpose(d),a),d)
        lmda = -(dtr/dtad)
        x1 = x + (lmda * d)
        r1 = np.dot(a, x1) - b
        r1[np.abs(r1) < es] = 0 # define zero
        error = math.sqrt(np.dot(np.transpose(r1), r1))

        # direction
        r1tad = np.dot(np.dot(np.transpose(r1),a),d)
        alpha = r1tad/dtad
        d1 = -r1 + (alpha * d)

        print(f"{k}\t{x1[0]:.3f}\t{x1[1]:.3f}\t{x1[2]:.3f}\t{x1[3]:.3f}\t{error:.3f}")
        k+=1
        d = d1
        r = r1
        x = x1
    return x

x = cg(a, b, x, es)