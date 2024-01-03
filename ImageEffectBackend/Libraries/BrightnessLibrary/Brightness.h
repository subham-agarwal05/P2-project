#ifndef BRIGHTNESS_H
#define BRIGHTNESS_H

#include <vector>
#include "../Pixel.h"

void applyBrightness(std::vector<std::vector<Pixel> >& img, float amount);

#endif // BRIGHTNESS_H
