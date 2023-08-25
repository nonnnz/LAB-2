#include <bits/stdc++.h>

using namespace std;

class node {
    public:
        int data;
        node* next;

        node(int n) {
            data = n;
            next = NULL;
        }
};

class List {
    public:
        node* head;

    int front() {
        return head->data;
    }

    int end() {
        node* ptr = head;
        while(ptr->next != NULL) {
            ptr = ptr->next;
        }
        return ptr->data;
    }

    void push_front(int data) {
        if(!head) {
            head = new node(data);
        } else {
            node* n = new node(data);
            n->next = head;
            head = n;
        }
    }

    int pop_front() {
        node* ptr = head;
        head = head->next;
        ptr->next = NULL;
        return ptr->data;
    }

    int pop_back() {
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

    void insert_after(int data, int pos) {
        node* x = new node(data);
        if(!head) {}
        else {
            node* ptr = head;
            while(ptr->data != pos) ptr = ptr->next;
            x->next = ptr->next;
            ptr->next = x;
        }
    }
    
    void insert_before(int data, int pos) {
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

    void del(int pos) {
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

int main() {
    List *a = new List();

    for(int i = 0; i < 5; i++) a->push_front(i);
    cout<<"popf: "<<a->pop_front()<<" popb: "<<a->pop_back()<<endl;
    cout<<"iaf: 10, 2"; a->insert_after(10, 2); cout<<endl;
    cout<<"ibf: 10, 2"; a->insert_before(10, 2); cout<<endl;
    cout<<"ibf: 11, 3"; a->insert_before(11, 3); cout<<endl;
    cout<<"f:"<<a->front()<<" e:"<<a->end()<<endl;
    a->show();
    cout<<"del: 11"; a->del(11); cout<<endl; a->show();
    cout<<"del: 1"; a->del(1); cout<<endl; a->show();
    cout<<"del: 2"; a->del(2); cout<<endl; a->show();
    return 0;
}