#include<bits/stdc++.h>

using namespace std;

template <typename Type>
class Queue {
	private:
		int queue_size;
		int ifront;
		int iback;
		int array_capacity;
		Type *array;
	
	public:
		Queue(int = 10);
		~Queue();
		bool empty() const;
		Type front() const;
		void push(Type const &);
		Type pop();
		void print(Queue* q);
};

template <typename Type>
Queue<Type>::Queue(int n):
	queue_size(0),
	iback(-1),
	ifront(0),
	array_capacity(max(1,n)),
	array(new Type[array_capacity]) {
		// empty
	}

template <typename Type>
Queue<Type>::~Queue() {
	delete[] array;
}

template <typename Type>
bool Queue<Type>::empty() const {
	return (queue_size == 0);
}

template <typename Type>
Type Queue<Type>::front() const {
	if(empty()) {
		throw "...";
	}
	return array[ifront];
}

template <typename Type>
void Queue<Type>::push(Type const &obj) {
	if(queue_size == array_capacity) {
		throw "...";
	}
	
	++iback;
	array[iback] = obj;
	++queue_size;
}

template <typename Type>
Type Queue<Type>::pop() {
	if(empty()) {
		throw "...";
	}
	
	--queue_size;
	++ifront;
	
	return array[ifront - 1];
}

template <typename Type>
void Queue<Type>::print(Queue* q) {
	for(int i = q->ifront ; i < q->queue_size; i++) {
		if(i == q->queue_size - 1) cout << q->array[i] << endl;
		else cout << q->array[i] << " ";
	}
	
}

int main() {
	Queue<int> q;
	char c;
	int n;
	while(c != 'x') {
		cin >> c;
		if(c == 'e') {
			cin >> n;
			q.push(n);
		}
		else if(c == 'd') {
			cout << q.pop();
		}
		else if(c == 'p') {
			q.print(&q);
		}
	}
	return 0;
}
