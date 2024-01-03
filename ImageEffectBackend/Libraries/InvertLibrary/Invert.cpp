#include <iostream>
#include <vector>
#include "../Pixel.h"  // Make sure to provide the correct path to the Pixel.h file

using namespace std;

// Function to invert the colors of an image
void invertImage(vector<vector<Pixel>> &imageVector)
{
    // Get the number of rows and columns in the image
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Loop through each pixel in the image
    for (int row = 0; row < num_rows; row++)
    {
        for (int col = 0; col < num_cols; col++)
        {
            // Invert the red, green, and blue components of each pixel
            imageVector[row][col].r = 255 - imageVector[row][col].r;
            imageVector[row][col].g = 255 - imageVector[row][col].g;
            imageVector[row][col].b = 255 - imageVector[row][col].b;
        }
    }
}
