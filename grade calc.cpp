#ifndef GRADE_CALC_H
#define GRADE_CALC_H

// Include any necessary libraries here

// Declare any function prototypes or class declarations here

#endif // GRADE_CALC_H

#include <iostream>
int main()
{
    int score = 95;

    if (score >= 90) { std::cout << "You got an A!";
    }
   else if (score >= 80) { std::cout << "You got a B!";
    }
    else if (score >= 70) { std::cout << "You got a C!";
    }
    else if (score >= 60) { std::cout << "You got a D!";
    }
    else { std::cout << "You got an F!";
    }


}