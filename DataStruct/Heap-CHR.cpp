#include <bits/stdc++.h>
using namespace std;

class Heap {
    public:
    int q[1000];

    void add(int n) {
        q[0] = q[0] + 1;
        q[q[0]] = n;
        int i = q[0];
    }

    void heapify() {
        int j = q[0];
    }
};