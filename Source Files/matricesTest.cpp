#include <iostream> 
#include <vector> //necessary libraries
using namespace std; //standard namespace

//function space
void printMatrix(const vector<vector<int>>& matrix) { //function to print matrix
    for (const auto& row : matrix) {
        for (const auto& elem : row) {
            cout << elem << " ";
        }
        cout << endl;
    }
}

int main() {
    // Define two matrices
    vector<vector<int>> matrixA = {
        {1, 2, 3},
        {4, 5, 6}
    };

    vector<vector<int>> matrixB = {
        {7, 8},
        {9, 10},
        {11, 12}
    };

    // Print matrices
    cout << "Matrix A:" << endl;
    printMatrix(matrixA);

    cout << "Matrix B:" << endl;
    printMatrix(matrixB);

    // Placeholder for matrix multiplication result
    vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size(), 0));

    // Matrix multiplication
    for (size_t i = 0; i < matrixA.size(); ++i) {
        for (size_t j = 0; j < matrixB[0].size(); ++j) {
            for (size_t k = 0; k < matrixA[0].size(); ++k) {
                result[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }
    }

    // Print result
    cout << "Result of Matrix Multiplication:" << endl;
    printMatrix(result);

    return 0;
}