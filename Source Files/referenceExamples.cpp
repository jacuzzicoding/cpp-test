
//example of an inproper reference declaration
int a = 10;
int &ref; //this wont work because a reference must be initialized when declared!
&ref = a; //this is the correct way to declare a reference, but it must be done at the same time as the declaration

//example of another inproper reference declaration
int a = 10;
int &ref = 20; //this wont work because a reference must be initialized with a variable, not a value

//more examples of references

int a = 10;
int b = 20;
int &ref = a; //ref is now a reference to a, thi
&ref = b; //error because a reference cannot be changed to refer to another variable, it is already bound to *A!


//example of declaring a reference to a pointer
int a = 10;
int *p = &a; //p is a pointer to a!

