#include <iostream>
#include <vector>
#include "../Pixel.h"

using namespace std;

void invertImage(vector<vector<Pixel> > &imageVector)
{
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows; row++)
    {
        for (int each = 0; each < num_cols; each++)
        {
            imageVector[row][each].r = 255 - imageVector[row][each].r;
            imageVector[row][each].g = 255 - imageVector[row][each].g;
            imageVector[row][each].b = 255 - imageVector[row][each].b;
        }
    }
}
