#include <bits/stdc++.h>

using namespace std;

class node {
    public:
        char data;
        node* next;

        node(char n) {
            data = n;
            next = NULL;
        }
};

class List {
    public:
        node* head;

    char front() {
        return head->data;
    }

    char end() {
        node* ptr = head;
        while(ptr->next != NULL) {
            ptr = ptr->next;
        }
        return ptr->data;
    }

    void push_front(char data) {
        if(!head) {
            head = new node(data);
        } else {
            node* n = new node(data);
            n->next = head;
            head = n;
        }
    }

    char pop_front() {
        if(!head) {
            return '-';
        } else {
            node* ptr = head;
            head = head->next;
            ptr->next = NULL;
            return ptr->data;
        }
        
    }

    char pop_back() {
        node* ptr = head;
        while(ptr->next->next != NULL) ptr = ptr->next;
        node* x = ptr->next;
        ptr->next = NULL;
        return x->data;
    }

    void show() {
        if(!head) {
            cout << "NULL";
        } else {
            node* ptr = head;
            while(ptr->next != NULL) {
                cout << ptr->data << " ";
                ptr = ptr->next;
            }
            cout << ptr->data << endl;
        }

    }

    void insert_after(char data, char pos) {
        node* x = new node(data);
        if(!head) {}
        else {
            node* ptr = head;
            while(ptr->data != pos) ptr = ptr->next;
            x->next = ptr->next;
            ptr->next = x;
        }
    }
    
    void insert_before(char data, char pos) {
        node* x = new node(data);
        if(!head) {}
        else if(head->data == pos) push_front(data);
        else {
            node* ptr = head;
            while(ptr->next->data != pos) ptr = ptr->next;
            x->next = ptr->next;
            ptr->next = x;
        }
    }

    void del(char pos) {
        node* ptr = head;
        node* x;
        if(ptr->data == pos) {
            x = head;
            head = ptr->next;
            x->next = NULL;
        }
        else {
            while(ptr->next->data != pos) ptr = ptr->next;
            x = ptr->next;
            ptr->next = ptr->next->next;
            x->next = NULL;
        }
        
    }
};

class Stack {
    public:
        List lst;
        char top() {
            lst.front();
        }
        void push(char data) {
            lst.push_front(data);
        }
        char pop() {
            lst.pop_front();
        }
        void print() {
            lst.show();
        }

};

void p1(Stack *a) {
	int n, i=0;
    char j;
	char str[9999];
	cin >> str;
	while(str[i] != '\0') {
		a->push(str[i]);
		i++;
	}

    int er = 0;

    while (j != '-')
    {
        j = a->pop();
        if (j == '(') er++;
        else if (j == ')') er++;

    }

    string ans = (er%2 == 0) ? "Pass" : "Error";
    cout<<ans;

}

void p2(Stack *a) {
	int n, i=0;
    char j;
	char str[100];
	cin >> str;
	while(str[i] != '\0') {
		a->push(str[i]);
		i++;
	}
    
    while(1) {
        j = a->pop();
        if(j == '-') break;
        cout<<j;
    }

}

int main() {
    Stack *a = new Stack();
    // p1(a);
    p2(a);
    return 0;
}