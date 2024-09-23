#include <iostream>

using namespace std;

int main() { //the compiler will read an array as a pointer
    //first lets declare the array
    int arr[5] = {1, 2, 3, 4, 5}; //declare an array of integers
    int *p = arr; //p is a pointer to the first element of the array
    cout << *p << endl; //this will print the value of the first element of the array
    cout << *(p+3) << endl;
    cout << *(p+2) << endl;
   int *c = (p+4);
    cout << *(c-5);
}