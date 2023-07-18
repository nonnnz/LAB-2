#include<iostream>

using namespace std;

class Stack {
	public:
		int top=-1;
		char arr[99999];
		void push(char x);
		char pop();
		void check();
};

void Stack::push(char x) {
	top++;
	arr[top] = x;
}

char Stack::pop() {
	return arr[top--];
}


int main() {
	Stack s;
	int n, i, j;
	char str[9999];
	cin >> str;
	while(str[i] != '\0') {
		s.push(str[i]);
		i++;
	}
	char x;
	while(1) {
		cout << s.pop();
		if(s.top == -1) break;
	}
	return 0;
	
}
