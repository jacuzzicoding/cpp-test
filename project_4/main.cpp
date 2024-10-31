#include <iostream>
#include <limits> //for numeric_limits
#include <stdexcept> //to throw exceptions
#include <array> //using array instead of vector for fixed size

//function prototypes

//function to get user input
class InputValidationError : public std::exception { //create exception class for input validation errors
    std::string message; //store error message 
public: //constructor for exception class
    InputValidationError(const std::string& msg) : message(msg) {} //initialize the message 
    const char* what() const noexcept override { //use a constant char pointer to return the message
        return message.c_str(); 
    }
};

class Program { //create a class for the program itself
private:
    static constexpr size_t ARRAY_SIZE = 5; //set the size of the array to 5
    std::array<int, ARRAY_SIZE> numbers = {1, 2, 3, 4, 5};

    void clearInputStream() { //function to clear the input stream so that the program can continue
        std::cin.clear();
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
    }

//function to perform division of two integers
public:
    void performDivision() {
        try { //try block to catch and throw exceptions
            int num1, num2; //initialize two integers
            std::cout << "Enter two integers: ";
            if (!(std::cin >> num1 >> num2)) { //if the input is not two integers, throw an exception
                clearInputStream(); //using my clearInputStream function to clear the input stream because the input is invalid
                throw InputValidationError("Invalid input - Please enter two integers."); //throw an exception with the message
            }

            if (num2 == 0) { //if the second number is 0, throw an exception (you can't divide by zero)
                throw std::runtime_error("Division by zero is not allowed."); //throw an exception 
            }

            double result = static_cast<double>(num1) / num2; //if the input is valid, we will perform the division using static_cast to convert the integers to doubles
            std::cout << "Result: " << result << std::endl; //output the result
        }
        catch (const InputValidationError& e) { //catch the input validation error
            std::cerr << "Error: " << e.what() << std::endl; 
        }
        catch (const std::runtime_error& e) { //catch the runtime error
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }

//function to access an element in the array

    void accessArray() {
        try {
            int index; //initialize an integer for the index
            std::cout << "Enter an index to access array (0-4): ";
            if (!(std::cin >> index)) { //if the input isn't an integer for the index, throw an exception
                clearInputStream(); 
                throw InputValidationError("Invalid input - Please enter an integer.");
            }

            if (index < 0 || index >= ARRAY_SIZE) { //if the index is negative, throw an exception (out of bounds)
                throw std::out_of_range("Index out of bounds.");
            }

            std::cout << "Accessing element at index " << index << ": " //if the index is valid, output the element at that index
                      << numbers[index] << std::endl;
        }
        catch (const InputValidationError& e) { //catch the input validation error
            std::cerr << "Error: " << e.what() << std::endl;
        }
        catch (const std::out_of_range& e) { //catch the out of range error
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }

//function to get a floating-point number from the user
       void getFloatingPoint() {
        try {
            float number; //initialize a float for the number
            std::cout << "Enter a floating-point number: "; 
            if (!(std::cin >> number)) { //if the input isn't a floating-point number, throw an exception
                clearInputStream();
                throw InputValidationError("Invalid input - Please enter a floating-point number.");
            }
            std::cout << "You entered " << number << std::endl;
        }
        catch (const InputValidationError& e) { 
            std::cerr << "Error: " << e.what() << std::endl;
        }
    }
//function to run the program
    void run() {
        performDivision();
        accessArray();
        getFloatingPoint();
    }
};
//simple main function to create an instance of the Program class and run it :)
int main() {
    Program program;
    program.run();
    return 0;
}