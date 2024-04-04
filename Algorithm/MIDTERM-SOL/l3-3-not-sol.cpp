#include <bits/stdc++.h>

using namespace std;

int partition(int a[], int l, int r) {
    int pivot, i, j, t;
    pivot = a[l];
    i = l;
    j = r + 1;

    while (1) {
        do { ++i; } while (a[i] <= pivot);
        do { --j; } while (a[j] > pivot);

        if (i >= j) break;
        swap(a[i], a[j]);
    }

    swap(a[l], a[j]);

    return j;
}

int partitionMid(int arr[],int l, int r) {
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

    return j;
}

void printA(int a[], int n=7) {
	for(int i=0;i<n;i++) cout<<a[i]<<" ";
}


int quick_select(int a[], int low, int high, int k, int count[]) {
    if (low == high) return a[low];
    
    if (low <= high) {
        int p_index = partition(a, low, high);
        // printA(a);
        // cout<<endl<<a[p_index]<<endl;
        count[0]++;
        int L_size = p_index - low + 1;

        if (k == L_size) {
            return a[p_index];
        }

        else if (k < L_size)
            return quick_select(a, low, p_index - 1, k, count);

        else {
            return quick_select(a, p_index + 1, high, k - L_size, count);
        }
    }
    else return -1;
}

int kthSmallest(int A[], int left, int right, int K) {
    if (left == right)
        return A[left];

    int pos = partition(A, left, right);
    int count = pos - left + 1;

    if (count == K)
        return A[pos];
    else if (count > K)
        return kthSmallest(A, left, pos - 1, K);
    else
        return kthSmallest(A, pos + 1, right, K - count);
}

void quickSort(int a[], int l, int r) {
    int p;
    if ((r-l)>0) 
    if (l < r)
    {
        p = partition(a, l, r);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }
}

int main() {
	int n, k;
	cin>>n>>k;
	int a[n];
    // n = 7, k = 3;
    // int a[] = {1,5,10,4,8,2,6};
	for(int i=0; i<n; i++) cin>>a[i];
    // int a[] = {1, 5, 10, 4, 8, 2, 6, 9, 20};
    // int k = 1;
    // int n = sizeof(a) / sizeof(a[0]);
	
    // cout<<kthSmallest(a, 0, n-1, k);
    int count[1];
    count[0] = 0;
    cout<<quick_select(a, 0, n-1, k, count)<<" "<<count[0];
	// cout<<quick_select(a, 0, n, k);
    // quickSort(a, 0, n-1);
    // for (int i = 0; i < n; i++) cout << a[i] << " ";
    // cout<<a[k-1];

    return 0;
}