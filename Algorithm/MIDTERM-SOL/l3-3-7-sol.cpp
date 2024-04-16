#include <bits/stdc++.h>

using namespace std;

int partition(int a[], int l, int r) {
    int pivot, i, j, t;
    pivot = a[r];
    i = l;

    for(int j = l; j <= r - 1; j++) {
        if(a[j] <= pivot) {
            swap(a[i], a[j]);
            i++;
        }
    }
    swap(a[i], a[r]);
    return i;
}

int quickSelect(int a[], int l, int r, int k, int& count) {
    if(k > 0 && k <= r - l + 1) {
        int pos = partition(a, l, r);
        if(pos - l == k - 1) {
            return a[pos];
        }
        count++;
        if(pos - l > k - 1) {
            return quickSelect(a, l, pos - 1, k, count);
        }
        return quickSelect(a, pos + 1, r, k - pos + l - 1, count);
    }
    return INT_MAX;
}

int main() {
    int n = 0, k = 0;
    cin >> n >> k;
    int arr[n] = {};
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    
    int count = 0;
    int qs = quickSelect(arr, 0, n - 1, k, count);
    cout << qs << " " << count;
    return 0;
}