#include <bits/stdc++.h>

using namespace std;

// O(n logn)
int partitionM(int a[],int l, int r) {
	int c = (l + r) / 2; // center
	
	if(a[l] > a[c])  // l < c < r
		swap(a[l], a[c]);
	if(a[c] > a[r])
		swap(a[c], a[r]);
	if(a[l] > a[c])
		swap(a[l], a[c]);
	swap(a[c], a[r]); // c to r
	
	int pivot = a[r];
	int i = (l-1);
	// loop i->r-1
	for(int j = 0; j <= r-1; j++) {
		if(a[j] < pivot) {
			i++;
			swap(a[i], a[j]);
		}
	}
	swap(a[i+1], a[r]);
	
	return (i + 1);
}

// left is piovt
int partitionL(int a[], int l, int r) {
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

// right is piovt
int partitionR(int a[], int l, int r) {
    int pivot, i, j;
    pivot = a[r];
    i = l - 1;

    for (j = l; j < r; ++j) {
        if (a[j] <= pivot) {
            ++i;
            swap(a[i], a[j]);
        }
    }

    swap(a[i + 1], a[r]);

    return i + 1;
}

void printA(int a[], int n=8) {
	for(int i=0;i<n;i++) cout<<a[i]<<" ";
}

void quickSort(int a[], int l, int r) {
	int p;
	if(l < r) {
		p = partitionL(a, l, r);
		quickSort(a, l, p-1);
		quickSort(a, p+1, r);
	}
}

// o(n)
void countingSort(int a[], int n) {
	int max = -1;
	//get max abs for size
	for(int i = 0; i < n; i++)
		if(abs(a[i]) > max) max = abs(a[i]);
	// double max size
	int out[max*2+1] = {0};
	
	// shift max
	for(int i = 0; i < n; i++) {
		out[a[i]+max]++;
	}
	
	int i = 0, j = 0; 
	while(i <= max*2) {
		if(out[i] > 0) {
			a[j] = i-max;
			out[i]--;
			j++;
		} else i++;
	}
}

int main() {
	int n;
	cin>>n;
	int a[n];
	for(int i = 0; i < n; i++) cin>>a[i];
	
	quickSort(a,0,n-1);
//	countingSort(a, n);
//	printA(a, n);
	
	int diff = 1;
	for(int i = 0; i < n-1; i++)
		if(abs(a[i] - a[i+1]) > 0) diff++;
	cout<<diff;
}
