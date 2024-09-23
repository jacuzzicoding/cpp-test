#include <iostream>

int main()
{
  int a = 10; //declare an integer variable to allocate memory
  int *p = &a; //declare a pointer variable to store the memory address of the variable a
  //notice how we use the '*' to dereference the pointer and get the actual value of the variable it points to

  std::cout<<&a; //print the memory address of the variable a using the '&' operator

    return 0;

}

//example of pointer

int a = 10;
int *p;
p = &a; // no error! this works just fine, unlike if it were a reference

//example to showcase the difference between a pointer and a reference

int a = 10;
int b = 20;
int *p;
p = &a; //p is a pointer to a
int &ref = a; //ref is a reference to a

//showing how *p can be used to ovwrite the value of a
int a = 10;
int *p = &a; //can declare in one line
*p = 20; //this will change the value of a to 20! if we used a reference, this would not be possible, as a reference cannot be changed to refer to another variable