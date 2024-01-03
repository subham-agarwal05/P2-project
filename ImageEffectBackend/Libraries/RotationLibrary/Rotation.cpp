#include <iostream>
#include <vector>
#include "../Pixel.h"

using namespace std;

// Function to rotate an image by 90 degrees clockwise
void rotate90(vector<vector<Pixel>>& imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Transpose the matrix
    for (int i = 0; i < num_rows; i++) {
        for (int j = i + 1; j < num_cols; j++) {
            swap(imageVector[i][j], imageVector[j][i]);
        }
    }

    // Reverse the order of rows
    for (int i = 0; i < num_rows / 2; i++) {
        swap(imageVector[i], imageVector[num_rows - 1 - i]);
    }
}

// Function to rotate an image by 180 degrees clockwise
void rotate180(vector<vector<Pixel>>& imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Transpose the matrix twice (equivalent to 180-degree rotation)
    for (int rotation = 0; rotation < 2; rotation++) {
        for (int i = 0; i < num_rows; i++) {
            for (int j = i + 1; j < num_cols; j++) {
                swap(imageVector[i][j], imageVector[j][i]);
            }
        }

        // Reverse the order of rows
        for (int i = 0; i < num_rows / 2; i++) {
            swap(imageVector[i], imageVector[num_rows - 1 - i]);
        }
    }
}

// Function to rotate an image by 270 degrees clockwise
void rotate270(vector<vector<Pixel>>& imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Transpose the matrix thrice (equivalent to 270-degree rotation)
    for (int rotation = 0; rotation < 3; rotation++) {
        for (int i = 0; i < num_rows; i++) {
            for (int j = i + 1; j < num_cols; j++) {
                swap(imageVector[i][j], imageVector[j][i]);
            }
        }

        // Reverse the order of rows
        for (int i = 0; i < num_rows / 2; i++) {
            swap(imageVector[i], imageVector[num_rows - 1 - i]);
        }
    }
}

void rotate(vector<vector<Pixel>> &imageVector, int value)          //Calling the corresponding rotate function
{
    if (value == 0)
    {
        return;
    }
    if (value == 90)
    {
        return rotate90(imageVector);
    }
    else if (value == 180)
    {
        return rotate180(imageVector);
    }
    else if (value == 270)
    {
        return rotate270(imageVector);
    }
}