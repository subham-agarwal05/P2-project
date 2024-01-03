#include "Sharpen.h"

#include <vector>
#include "../Pixel.h"
using namespace std;

void applySharpen(vector<vector<Pixel> > &imageVector, float amount){
    int h=imageVector.size();           //Iterating through all pixels
    int w=imageVector[0].size();
    for (long i = 1; i < h - 1; i++) {
            for (long j = 1; j < w - 1; j++) {
                Pixel Color;
                float factor =amount/50;
                // Calculate the sharpened pixel values
                int nR = imageVector[i][j].r + static_cast<int>((imageVector[i][j].r - imageVector[i - 1][j].r) * factor );
                int nG = imageVector[i][j].g + static_cast<int>((imageVector[i][j].g - imageVector[i - 1][j].g) * factor);
                int nB = imageVector[i][j].b + static_cast<int>((imageVector[i][j].b - imageVector[i - 1][j].b) * factor);

                // Clamp the values to the valid range [0, 255]
                nR = max(0, min(nR, 255));
                nG = max(0, min(nG, 255));
                nB = max(0, min(nB, 255));

                // Update the pixel in the image vector
                imageVector[i][j].r = nR;
                imageVector[i][j].g = nG;
                imageVector[i][j].b = nB;
            }
        }
}