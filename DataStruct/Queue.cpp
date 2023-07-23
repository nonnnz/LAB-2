#include <bits/stdc++.h>

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
    Queue(int capacity = 10) : queue_size(0), ifront(0), iback(-1), array_capacity(capacity) {
        array = new Type[capacity];
    }

    ~Queue() {
        delete[] array;
    }

    bool empty() const {
        return queue_size == 0;
    }

    Type front() const {
        if (empty()) {
            throw runtime_error("Queue is empty.");
        }
        return array[ifront];
    }

    void push(const Type &value) {
        if (queue_size == array_capacity) {
            throw runtime_error("Queue is full.");
        }
        iback = (iback + 1) % array_capacity;
        array[iback] = value;
        ++queue_size;
    }

    Type pop() {
        if (empty()) {
            throw runtime_error("Queue is empty.");
        }
        Type front_value = array[ifront];
        ifront = (ifront + 1) % array_capacity;
        --queue_size;
        return front_value;
    }
};

int main() {
    // Test the Queue implementation here if needed
    return 0;
}
