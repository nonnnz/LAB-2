#include <iostream>

using namespace std;

class node {
    public:
        int key;
        string data;
        node *next;
        node() {
            key = -1;
            data = "-";
            next = NULL;
        }
        
        node(string s, int k) {
            key = k;
            data = s;
            next = NULL;
        }
};

class S_c {
    public:
        int n; // size
        node h[100];
        S_c(int p_n) {
            n = p_n;
        }

        void add(int key, string data) {
            int j = key%n; // hash to size
            if(h[j].next == NULL) {
                h[j].data = data;
                h[j].key = key;
                h[j].next = new node();
            } else {
                node *ptr = h[j].next;
                while(ptr->next != NULL) {
                    ptr = ptr->next;
                }
                ptr->data = data;
                ptr->key = key;
                ptr->next = new node();
            }
        }

        string search(int key) {
            int j = key%n;
            if(h[j].key == -1) return "-";
            if(h[j].key == j) {
                return h[j].data;
            } else {
                node *ptr = h[j].next;
                while(ptr->next != NULL) {
                    if(ptr->key == key) return ptr->data; 
                    ptr = ptr->next;
                }
            }
            return "-";
        }

	void print()
	{
		for(int i=0;i<n;i++)
		{
			cout<<"("<<h[i].key<<","<<h[i].data<<")";
            if(h[i].next != NULL)
            {
                node *t_node = h[i].next;
                while(t_node->next != NULL)
                {
                    cout<<" "<<"("<<t_node->key<<","<<t_node->data<<")";
                    t_node = t_node->next;
                }
            }
            cout<<endl;
		}
        
	}
};

int main() {
	S_c *h = new S_c(17);
	char s, v[100];
	int k;
	while(s != 'e'){
		cin>>s;
		if(s == 'a') {
			cin>>k>>v;
			h->add(k, v);
		}
		else if(s == 'p') {
			h->print();
		}
		else if(s == 's') {
			cin>>k;
			cout<<h->search(k)<<endl;
		}
	}
    return 0;
}