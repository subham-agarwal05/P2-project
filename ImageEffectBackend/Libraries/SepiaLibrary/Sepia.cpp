#include <iostream>
#include <vector>
#include "../Pixel.h"

using namespace std;

void applySepia(vector<vector<Pixel> > &imageVector)
{
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows; row++)
    {
        for (int each = 0; each < num_cols; each++)
        {
            // Apply sepia filter to each pixel
            int &r = imageVector[row][each].r;
            int &g = imageVector[row][each].g;
            int &b = imageVector[row][each].b;

            int tr = static_cast<int>(0.393 * r + 0.769 * g + 0.189 * b);
            int tg = static_cast<int>(0.349 * r + 0.686 * g + 0.168 * b);
            int tb = static_cast<int>(0.272 * r + 0.534 * g + 0.131 * b);

            // Ensure values are within the valid range [0, 255]
            imageVector[row][each].r = min(tr, 255);
            imageVector[row][each].g = min(tg, 255);
            imageVector[row][each].b = min(tb, 255);
        }
    }
}
