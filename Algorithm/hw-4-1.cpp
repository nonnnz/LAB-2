#include <iostream>

using namespace std;

int arr[] = {1, 5, 10, 4, 8, 2, 6, 9, 20};
int k = 4;
int n = sizeof(arr) / sizeof(arr[0]);

int partition(int l, int r) {
    int m = (l + r) / 2;

    int p_index;
    if (arr[l] < arr[m] && arr[m] < arr[r])
        p_index = m;
    else if (arr[l] < arr[r] && arr[r] < arr[m])
        p_index = r;
    else
        p_index = l;

    swap(arr[l], arr[p_index]);
    
    int pivot, i, j; 
    pivot = arr[l];
    i = l;
    j = r + 1;

    while(1) {
        do ++i; while(arr[i] <= pivot);
        do --j; while(arr[j] > pivot);

        cout << i << " " << j << endl;

        if (i >= j) break;
        swap(arr[i], arr[j]);
    }

    swap(arr[l], arr[j]);

    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";
    } cout << endl;

    return j;
}

int quickSelect(int low, int high, int k) {
    if (low == high)
        return arr[low];
    
    int p = partition(low, high);

    if (k == p - low + 1) // case k = Pivot position
        return arr[p];
    else if (k < p - low + 1) // case k ∈ L
        return quickSelect(low, p - 1, k);
    else { // case k ∈ R
        k = k - (p - low + 1);
        return quickSelect(p + 1, high, k);
    }
}

int main() {
    using namespace std;

    cout << quickSelect(0, n - 1, k) << endl;

    return 0;
}
