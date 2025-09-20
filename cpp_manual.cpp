#include <iostream>
#include <vector>

void leak_example() {
    int* a = new int[1000];
    a[0] = 1;
    std::cout << "a[0] = " << a[0] << " (leaked)\n";
}

void no_leak_example() {
    int* b = new int[1000];
    b[0] = 2;
    std::cout << "b[0] = " << b[0] << " (freed)\n";
    delete[] b; 
}

void smart_pointer_example() {
    std::vector<int>* v = new std::vector<int>(1000, 7);
    std::cout << "v->size() = " << v->size() << "\n";
    delete v; 
}

int main() {
    leak_example();
    no_leak_example();
    smart_pointer_example();
    return 0;
}
