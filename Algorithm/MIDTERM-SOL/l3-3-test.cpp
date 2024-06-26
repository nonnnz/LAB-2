#include <bits/stdc++.h>

using namespace std;

int partitionRight(int arr[], int l, int r) {
    int pivot, i, j;
    pivot = arr[r];
    i = l ;

    for (j = l; j <= r-1; j++) {
        if (arr[j] <= pivot) {
            swap(arr[i], arr[j]);
            i++;
        }
    }

    swap(arr[i], arr[r]);

    return i;
}

int quick_select(int a[], int low, int high, int k, int& count) {
    if (k > 0 && k <= high - low + 1) {
        int p_index = partitionRight(a, low, high);
       
        int L_size = p_index - low + 1;

        if (k == L_size) {

            return a[p_index];
        }
        count++;
        if (k < L_size)
        {
            return quick_select(a, low, p_index - 1, k, count);
        }
        return quick_select(a, p_index + 1, high, k - p_index + low - 1, count);
    }
    return -1;
}

int main() {
	int n, k;
	cin>>n>>k;
	int a[n];

	for(int i=0; i<n; i++) cin>>a[i];

    int count = 0;
    cout<<quick_select(a, 0, n-1, k, count)<<" "<<count;

    return 0;
}