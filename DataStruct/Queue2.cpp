#include<bits/stdc++.h>

using namespace std;

class Queue {
	public:
	int size;
	int *arr;
	int head;
	int tail;
	
	// constructor
	Queue(int s) {
		head = tail = -1;
		size = s;
		arr = new int[s];
	}
	
	bool isFull() {
		if (head == 0 && tail == size-1) {
			return true;
		}
		if (head == tail + 1) {
			return true;
		}
		return false;
	}
	
	bool isEmpty() {
		return (head == -1);
	}
	
	void enqueue(int ele) {
		if (isFull()) {
			cout << "" << endl;
		} else {
			if (head == -1) head = 0;
			tail++;
			arr[tail%size] = ele;	
		}
		
		
	}
	int dequeue() {
		int ele;
		if(isEmpty()) {
			cout << "" << endl;
		} else {
			ele = arr[head];
			if(head == tail) {
				head = -1;
				tail = -1;
			}
			else {
				head = (head + 1) % size;
			}
			return ele;
		}	
	}
	
	void print() {
		int i;
		if(isEmpty()) {
			cout << "" << endl;
		} else {
			for (i = head; i != tail; i = (i + 1) % size) {
				cout << arr[i] << " ";
//				cout << i;
			}
			cout << arr[i] << endl;
		}
	}
	
	void count() {
		int i, count = 1;
		if(isEmpty()) {
			cout << "0" << endl;
		} else {
			for (i = head; i != tail; i = (i + 1) % size) count++;
			cout << count << endl;
		}
	}
	
	void showq() {
		int i;
		if(isEmpty()) {
			cout << "" << endl;
		} else {
			cout << arr[head] << " " << arr[tail] << endl;
		}	
	}
};

int main() {
	Queue q(10);
	char c;
	int n;
	while(c != 'x') {
		cin >> c;
		if(c == 'e') {
			cin >> n;
			q.enqueue(n);
		}
		else if(c == 'd') {
			cout << q.dequeue() << endl;
		}
		else if(c == 'p') {
			q.print();
		}
		else if(c == 'n') {
			q.count();
		}
		else if(c == 's') {
			q.showq();
		}
	}
	return 0;
}
