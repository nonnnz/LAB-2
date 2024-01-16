#include <bits/stdc++.h>

using namespace std;

void search(int a[], int m, int k, int n) {
    int i = 0;
    int j = 0;
    // search i A->M
    while (j < n) {
        if (a[j] == m) {
            i = j;
            break;
        }
        else if(a[j] < m) {
            i = j;
        }
        else if(a[j] > m) {
            break;
        }
        j++;
    }
    cout << i << endl;

    int left = i - 1, right = i;
    if (left == -1) left = i;

    cout << left << " " << right << endl;

    while ((right - left) <= k) {
        cout << a[left] << " " << a[right] << endl;
        if(abs(a[left] - m) >= abs(a[right] - m)) 
            right++;
        else
            left--;
    }
}

int main() {
    int m, k;
    int a[] = {10, 12, 15, 17, 18, 20, 25}; // sorted array
    m = 15; k = 2;
    int n = sizeof(a) / sizeof(a[0]);

    search(a, m, k, n);
    return 0;
}