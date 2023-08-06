#include <iostream>

template <typename Type>
class Single_node {
public:
    Type data;
    Single_node* next;

    Single_node(Type value) : data(value), next(nullptr) {}
};

template <typename Type>
class Single_list {
private:
    Single_node<Type>* list_head;
    Single_node<Type>* list_tail;
    int list_size;

public:
    Single_list() : list_head(nullptr), list_tail(nullptr), list_size(0) {}

    int size() const {
        return list_size;
    }

    bool empty() const {
        return list_size == 0;
    }

    Type front() const {
        if (empty()) {
            throw std::runtime_error("List is empty.");
        }
        return list_head->data;
    }

    Type back() const {
        if (empty()) {
            throw std::runtime_error("List is empty.");
        }
        return list_tail->data;
    }

    Single_node<Type>* head() const {
        return list_head;
    }

    Single_node<Type>* tail() const {
        return list_tail;
    }

    int count(Type const &value) const {
        int count = 0;
        Single_node<Type>* current = list_head;
        while (current) {
            if (current->data == value) {
                count++;
            }
            current = current->next;
        }
        return count;
    }

    void push_front(Type const &value) {
        Single_node<Type>* newNode = new Single_node<Type>(value);
        newNode->next = list_head;
        list_head = newNode;
        if (!list_tail) {
            list_tail = list_head;
        }
        list_size++;
    }

    void push_back(Type const &value) {
        Single_node<Type>* newNode = new Single_node<Type>(value);
        if (!list_head) {
            list_head = newNode;
            list_tail = list_head;
        } else {
            list_tail->next = newNode;
            list_tail = newNode;
        }
        list_size++;
    }

    Type pop_front() {
        if (empty()) {
            throw std::runtime_error("List is empty.");
        }
        Type frontValue = list_head->data;
        Single_node<Type>* temp = list_head;
        list_head = list_head->next;
        delete temp;
        list_size--;
        if (empty()) {
            list_tail = nullptr;
        }
        return frontValue;
    }

    int erase(Type const &value) {
        int count = 0;
        Single_node<Type>* current = list_head;
        Single_node<Type>* previous = nullptr;
        while (current) {
            if (current->data == value) {
                if (previous) {
                    previous->next = current->next;
                } else {
                    list_head = current->next;
                }
                if (!current->next) {
                    list_tail = previous;
                }
                Single_node<Type>* temp = current;
                current = current->next;
                delete temp;
                list_size--;
                count++;
            } else {
                previous = current;
                current = current->next;
            }
        }
        return count;
    }

    ~Single_list() {
        while (list_head) {
            Single_node<Type>* temp = list_head;
            list_head = list_head->next;
            delete temp;
        }
    }
};

template <typename Type>
class Queue {
private:
    Single_list<Type> list;

public:
    bool empty() const {
        return list.empty();
    }

    Type front() const {
        if (empty()) {
            throw std::runtime_error("Queue is empty.");
        }
        return list.front();
    }

    void push(Type const &obj) {
        list.push_back(obj);
    }

    Type pop() {
        if (empty()) {
            throw std::runtime_error("Queue is empty.");
        }
        return list.pop_front();
    }
};

int main() {
    Queue<int> queue;

    queue.push(5);
    queue.push(10);
    queue.push(15);

    std::cout << "Front element: " << queue.front() << std::endl;

    queue.pop();
    std::cout << "Front element after pop: " << queue.front() << std::endl;

    return 0;
}
