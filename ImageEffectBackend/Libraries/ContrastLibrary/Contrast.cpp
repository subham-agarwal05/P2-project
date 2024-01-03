#include <iostream>
#include <vector>
#include "../Pixel.h"

using namespace std;

// Function to adjust the contrast of an image
void adjustContrast(vector<vector<Pixel> > &imageVector, float contrastFactor) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Iterate through each pixel in the image
    for (int row = 0; row < num_rows; row++) {
        for (int col = 0; col < num_cols; col++) {
            // Calculate the new pixel values with adjusted contrast
            float adjustedR = contrastFactor * (imageVector[row][col].r - 128) + 128;
            float adjustedG = contrastFactor * (imageVector[row][col].g - 128) + 128;
            float adjustedB = contrastFactor * (imageVector[row][col].b - 128) + 128;

            // Ensure the values are within the valid range [0, 255]
            imageVector[row][col].r = max(0.0f, min(255.0f, adjustedR));
            imageVector[row][col].g = max(0.0f, min(255.0f, adjustedG));
            imageVector[row][col].b = max(0.0f, min(255.0f, adjustedB));
        }
    }
}

