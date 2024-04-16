#include <bits/stdc++.h>

using namespace std;


int partition2(int a[], int l, int r) {
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

int quick_select(int a[], int low, int high, int k, int& count) {
    if (k > 0 && k <= high - low + 1) {
        int p_index = partition2(a, low, high);
       
        // printA(a);
        // cout<<endl<<a[p_index]<<endl;

        if (k - 1 == p_index - low) {
            // count[0]++;
            // count_partition++;
            return a[p_index];
        }

        count++;

        if (p_index - low > k - 1)
        {
            // count_partition++;
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
    int kth = quick_select(a, 0, n-1, k, count);
    cout<<kth<<" "<<count;


    return 0;
}