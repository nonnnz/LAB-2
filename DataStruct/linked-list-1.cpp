#include <bits/stdc++.h>

using namespace std;

class Node{
	public:
		int data;
		Node* next;
};

class List{
	public:
		Node* head;
		void push_front(int data) {
			if(head == NULL) {
				head = new Node();
				head->data = data;
				head->next = NULL;
			} else {
				Node* x = new Node();
				x->data = data;
				x->next = head;
				head = x;
			}	
		}
		
		int dup(int data) {
			Node* ptr = head;
			int index = 0;
			while(ptr!=NULL) {
				if(ptr->data == data) {
					return 1;
				}
				else {
					ptr = ptr->next;
					index++;
				}
			}
			return -1;			
		}

		void Insert_before(int data, int pos) {
		    Node* x = new Node();
		    int check = dup(data);
		    if(check == 1) {
		    	cout<<endl;
		    	return;
			}
		    x->data = data;
		    if (head == NULL) {
		        x->next = head;
		        head = x;
		    } else {
		        Node* ptr = head;
		        Node* front = NULL;
		
		        int index = search(pos);
		
		        if (index != -1) {
		            for (int i = 0; i < index; i++) {
		                front = ptr;
		                ptr = ptr->next;
		            }
		
		            if (front == NULL) {
		                x->next = head;
		                head = x;
		            } else {
		                front->next = x;
		                x->next = ptr;
		            }
		        } else {
		        	while(ptr->next != NULL) {
						ptr = ptr->next;
					}
					x->next = ptr->next;
					ptr->next = x;
		        }	
	    	}
			showList();
	    }
		
		int search(int data) {
			Node* ptr = head;
			int index = 0;
			while(ptr!=NULL) {
//				cout<<"s = "<<ptr->data<<endl;
				if(ptr->data == data) {
					return index;
				}
				else {
					ptr = ptr->next;
					index++;
				}
			}
//			cout<<"Not found"<<endl;
			return -1;
		}
		
		int erase(int pos) {
			Node* ptr = head;
			Node* x;
			int index = search(pos);
//			cout<<"index ="<<index<<" ";
			if(index == 0) {
				x = head;
				head = ptr->next;
				x->next = NULL;
				return x->data;
			}
			for(int i =0; i< index-1;i++) {
				ptr = ptr->next;
			}
			x = ptr->next;
			ptr->next = ptr->next->next;
			x->next = NULL;
			return x->data;
		}
		
		void Insert_after(int data, int pos) {
			Node* ptr = head;
			bool dup = false;
			if(head == NULL) {
				head = new Node();
				head->data = data;
				head->next = NULL;
			} else {
				while(ptr->data != pos) {
					ptr = ptr->next;
					if(ptr->data == data) dup = true;
					if(ptr->next == NULL) break;
				}
				if(!dup) {
					Node* x = new Node();
					x->data = data;
					x->next = ptr->next;
					ptr->next = x;
				}
			}
			if(!dup) showList();
			else cout<<endl;
		}		
		
		int pop_front() {
			if(head != NULL) {	
				Node* x = head;
				head = head->next;
				x->next = NULL;
				return x->data;
			} else {
				return -1;
			}
		}
		
		int pop_back() {
			Node* ptr = head;
			if(head == NULL) {
				return -1;
			}
			else if(ptr->next==NULL) {
				Node* x = head;
				head = NULL;
				return x->data;
			} 
			else {	
				while(ptr->next->next != NULL) {
					ptr = ptr->next;
				}
				Node* x = ptr->next;
				ptr->next = NULL;
				return ptr->data;
			}
		}
		
		void showList() {
			Node* ptr = head;
			while(ptr!=NULL) {
				if(ptr->next == NULL) cout<<ptr->data;
				else cout<<ptr->data<<" ";
				ptr = ptr->next;
		}
		cout<<endl;
			
		}
};

int main() {
	int data, pos;
	char c;
	List* list = new List();
	while(c != 'E') {
		cin>>c;
		if(c == 'D') {
			cin>>data;
			list->erase(data);
			list->showList();
		}
		else if(c == 'I') {
			cin>>data>>pos;
			list->Insert_before(data, pos); 
		}
		else if(c == 'A') {
			cin>>data>>pos;
			list->Insert_after(data, pos); 
		}
	}
	
	
	
	return 0;
}

