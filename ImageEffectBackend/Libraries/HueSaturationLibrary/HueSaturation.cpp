//#include "HueSaturation.h"

#include <iostream>
#include <cmath>
#include <vector>
#include "../Pixel.h"

using namespace std;

void applyHueSaturation(vector<vector<Pixel> > &imageVector, float saturationValue, float hueValue)
{
    int num_rows = imageVector.size();
    int num_cols = imageVector[0].size();

    for (int row = 0; row < num_rows; row++)
    {
        for (int each = 0; each < num_cols; each++)
        {
            // Extract RGB values from the current pixel
            int &r = imageVector[row][each].r;
            int &g = imageVector[row][each].g;
            int &b = imageVector[row][each].b;

            // Convert RGB to HSV
            float maxVal = max(max(r, g), b);
            float minVal = min(min(r, g), b);
            float delta = maxVal - minVal;

            float huePrime = 0.0f;
            if (delta != 0)
            {
                if (maxVal == r)
                {
                    huePrime = fmod((g - b) / delta, 6.0f);
                }
                else if (maxVal == g)
                {
                    huePrime = (b - r) / delta + 2.0f;
                }
                else
                {
                    huePrime = (r - g) / delta + 4.0f;
                }
            }

            // Adjust Hue and Saturation
            huePrime += hueValue;
            if (huePrime < 0)
                huePrime += 6.0f;
            if (huePrime >= 6)
                huePrime -= 6.0f;

            float newSaturation = min(max(0.0f, saturationValue), 1.0f);
            float newLightness = (maxVal + minVal) / 2.0f;

            // Convert HSV back to RGB and update the pixel values
            float c = (1 - fabs(2 * newLightness - 1)) * newSaturation;
            float x = c * (1 - fabs(fmod(huePrime, 2) - 1));
            float m = newLightness - c / 2;

            if (0 <= huePrime && huePrime < 1)
            {
                r = (c + m) * 255;
                g = (x + m) * 255;
                b = m * 255;
            }
            else if (1 <= huePrime && huePrime < 2)
            {
                r = (x + m) * 255;
                g = (c + m) * 255;
                b = m * 255;
            }
            else if (2 <= huePrime && huePrime < 3)
            {
                r = m * 255;
                g = (c + m) * 255;
                b = (x + m) * 255;
            }
            else if (3 <= huePrime && huePrime < 4)
            {
                r = m * 255;
                g = (x + m) * 255;
                b = (c + m) * 255;
            }
            else if (4 <= huePrime && huePrime < 5)
            {
                r = (x + m) * 255;
                g = m * 255;
                b = (c + m) * 255;
            }
            else
            {
                r = (c + m) * 255;
                g = m * 255;
                b = (x + m) * 255;
            }
        }
    }
}
