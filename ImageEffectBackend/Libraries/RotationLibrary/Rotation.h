#ifndef ROTATEIMAGE_H
#define ROTATEIMAGE_H

#include <vector>
#include <algorithm> // for std::swap
#include "../Pixel.h"   // Include the appropriate path to your Pixel.h file

using namespace std;

// Function to rotate an image by 90 degrees clockwise
void rotate90(vector<vector<Pixel>>& imageVector);

// Function to rotate an image by 180 degrees clockwise
void rotate180(vector<vector<Pixel>>& imageVector);

// Function to rotate an image by 270 degrees clockwise
void rotate270(vector<vector<Pixel>>& imageVector);

// Function to rotate an image by a specified angle (in degrees) clockwise
void rotate(vector<vector<Pixel>>& imageVector, int value);

#endif // ROTATEIMAGE_H
