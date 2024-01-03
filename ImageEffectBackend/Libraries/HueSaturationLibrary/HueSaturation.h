#ifndef HUE_SATURATION_H
#define HUE_SATURATION_H
#include <vector>
using namespace std;
#include "../Pixel.h"

void applyHueSaturation(vector<vector<Pixel>>& image, float saturationValue, float hueValue);

#endif
