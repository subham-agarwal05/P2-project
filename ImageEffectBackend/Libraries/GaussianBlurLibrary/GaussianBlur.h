#ifndef GAUSSIAN_BLUR_H
#define GAUSSIAN_BLUR_H
#include<vector>
#include "../Pixel.h"

using namespace std;

void applyGaussianBlur(vector<vector<Pixel>>& image, float amount);

#endif