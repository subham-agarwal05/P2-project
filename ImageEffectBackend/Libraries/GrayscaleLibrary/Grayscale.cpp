#include <iostream>
#include <vector>
#include "Grayscale.h"
#include "../Pixel.h"

using namespace std;

void convertToGrayscale(vector<vector<Pixel>> &imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows; row++) {
        for (int each = 0; each < num_cols; each++) {
            // Calculate grayscale value using the formula: (0.299 * R + 0.587 * G + 0.114 * B)
            auto grayscale = 0.299 * imageVector[row][each].r +0.587 * imageVector[row][each].g +0.114 * imageVector[row][each].b;

            // Assign the grayscale value to all color channels
            imageVector[row][each].r = grayscale;
            imageVector[row][each].g = grayscale;
            imageVector[row][each].b = grayscale;

        }
    }
}


