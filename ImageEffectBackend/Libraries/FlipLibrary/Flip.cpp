#include <iostream>
#include <vector>
#include "../Pixel.h"
#include "Flip.h"

using namespace std;

// Function to flip an image horizontally
void flipHorizontal(vector<vector<Pixel>> &imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows; row++) {
        for (int col = 0; col < num_cols / 2; col++) {
            // Swap pixels from left and right sides
            swap(imageVector[row][col], imageVector[row][num_cols - 1 - col]);
        }
    }
}

// Function to flip an image vertically
void flipVertical(vector<vector<Pixel>> &imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows / 2; row++) {
        // Swap rows from top and bottom
        swap(imageVector[row], imageVector[num_rows - 1 - row]);
    }
}