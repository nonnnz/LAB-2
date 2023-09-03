#include<iostream>
#include <string>

using namespace std;


class Stack {
	public:
		int top=-1;
		char arr[99999];
		void push(char x);
		char pop();
		void check();
		bool empty() {
			return (top==-1);
		}
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
	int n, i=0, j;
	char str[9999];
	cin >> str;
	cout<<s.empty();
	while(str[i] != '\0') {
		s.push(str[i]);
		i++;
	}

	int count = 0;
	char x;
	int error = 0; // for case ()(), 2()
	char prv_x;
    while ((x = s.pop()) != '\0') {
        if (x == ')') {
			if(isdigit(prv_x) == 1) error++;
            count++;
        } else if (x == '(') {
            count--;
			if(s.arr[s.top] == ')' || isdigit(s.arr[s.top]) == 1) error++;
        }
		if(error > 0) break;
		prv_x = x; // for case ()2
    }
    if (count == 0 && error == 0) {
        cout << "Pass";
    } else {
        cout << "Error";
    }
	cout<<s.empty();
	return 0;
}
