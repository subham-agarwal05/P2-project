#include <iostream>
#include <vector>
#include "../Pixel.h"
#include "GaussianBlur.h"

using namespace std;

const int kernelSize = 3;
const float sharpenKernel[kernelSize][kernelSize] = {
    {1/16, 1/8, 1/16},
    {1/8,  1/4, 1/8},
    {1/16, 1/8, 1/16}
};

void Gaussianblur(vector<vector<Pixel>>&imageVector) {
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    // Create a temporary vector to store the sharpened image
    vector<vector<Pixel>> sharpenedImage(num_rows, vector<Pixel>(num_cols));

    for (int row = 1; row < num_rows - 1; row++) {
        for (int col = 1; col < num_cols - 1; col++) {
            float sumR = 0, sumG = 0, sumB = 0;

            // Apply the convolution operation
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    sumR += imageVector[row + i][col + j].r * sharpenKernel[i + 1][j + 1];
                    sumG += imageVector[row + i][col + j].g * sharpenKernel[i + 1][j + 1];
                    sumB += imageVector[row + i][col + j].b * sharpenKernel[i + 1][j + 1];
                }
            }

            // Clamp values to the valid range [0, 255]
            sharpenedImage[row][col].r = min(max(static_cast<int>(sumR), 0), 255);
            sharpenedImage[row][col].g = min(max(static_cast<int>(sumG), 0), 255);
            sharpenedImage[row][col].b = min(max(static_cast<int>(sumB), 0), 255);
        }
    }

    // Copy the sharpened image back to the original vector
    imageVector = sharpenedImage;
}