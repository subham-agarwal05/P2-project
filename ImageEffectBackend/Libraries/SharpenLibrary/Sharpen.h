#ifndef SHARPEN_H
#define SHARPEN_H
#include "../Pixel.h"
#include <vector>
using namespace std;

void applySharpen(vector< vector<Pixel> > &imageVector, float amount);

#endif