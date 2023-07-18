#include<iostream>

using namespace std;

class Stack {
	public:
		int top=-1;
		int arr[99999];
		void push(int x);
		int pop();
};

void Stack::push(int x) {
	top++;
	arr[top] = x;
}

int Stack::pop() {
	if(top == -1) return 0;
	return arr[top--];
}


int main() {
	Stack s;
	int n, i, j;
	char e;
	while(1) {
		cin >> e;
		if(e == 'U') {
			cin >> n;
			s.push(n);
		}
		else if(e == 'O') {
			cout << s.pop() << endl;
		}
		else if(e == 'T') {
			cout << s.arr[s.top] << endl;
		}
		else if(e == 'P') {
			j = 0;
			while (j < s.top+1)
			{
				cout << s.arr[j];
				if (j+1 == s.top+1) cout << endl;
				else cout << " ";
				j++;
			}
			
		}
		else if(e == 'N') cout << s.top+1 << endl;
		else if(e == 'X') break;		
	}
	return 0;
}
