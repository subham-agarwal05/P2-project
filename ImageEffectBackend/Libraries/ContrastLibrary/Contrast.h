#ifndef IMAGE_PROCESSING_H
#define IMAGE_PROCESSING_H

#include <vector>
#include "../Pixel.h"

void adjustContrast(std::vector<std::vector<Pixel> >& imageVector, float contrastFactor);

#endif // IMAGE_PROCESSING_H
