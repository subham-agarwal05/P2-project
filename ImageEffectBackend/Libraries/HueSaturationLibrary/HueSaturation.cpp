#include "../Pixel.h"
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

void adjustHueSaturation(Pixel &pixel, float saturationValue, float hueValue)
{
    // Convert RGB to normalized float values
    float red = pixel.r / 255.0f;
    float green = pixel.g / 255.0f;
    float blue = pixel.b / 255.0f;

    // Find maximum and minimum values
    float comp_max = max({red, green, blue});
    float comp_min = min({red, green, blue});
    float delta = comp_max - comp_min;

    // Calculate hue
    float hue = 0;
    if (delta != 0)
    {
        if (comp_max == red)
            hue = 60 * fmod((green - blue) / delta, 6);
        else if (comp_max == green)
            hue = 60 * ((blue - red) / delta + 2);
        else
            hue = 60 * ((red - green) / delta + 4);
    }

    // Adjust hue
    hue += hueValue;
    if (hue < 0)
        hue += 360;
    if (hue >= 360)
        hue -= 360;

    // Calculate saturation
    float saturation = (comp_max == 0) ? 0 : delta / comp_max;

    // Adjust saturation
    float saturationF = (saturationValue >= 50) ? ((saturationValue - 50) / 50.0f) : (-saturationValue / 50.0f);
    saturation = max(0.0f, min(1.0f, saturation + saturationF));

    // Calculate value
    float value = comp_max;

    // Convert back to RGB
    float chroma = value * saturation;
    float hueDiff = hue / 60.0f;
    float x = chroma * (1 - abs(fmod(hueDiff, 2) - 1));

    float red2, green2, blue2;
    switch (static_cast<int>(hueDiff))
    {
    case 0:
        red2 = chroma;
        green2 = x;
        blue2 = 0;
        break;
    case 1:
        red2 = x;
        green2 = chroma;
        blue2 = 0;
        break;
    case 2:
        red2 = 0;
        green2 = chroma;
        blue2 = x;
        break;
    case 3:
        red2 = 0;
        green2 = x;
        blue2 = chroma;
        break;
    case 4:
        red2 = x;
        green2 = 0;
        blue2 = chroma;
        break;
    case 5:
        red2 = chroma;
        green2 = 0;
        blue2 = x;
        break;
    default:
        red2 = green2 = blue2 = 0;
        break;
    }

    float m = value - chroma;
    pixel.r = static_cast<int>((red2 + m) * 255);
    pixel.g = static_cast<int>((green2 + m) * 255);
    pixel.b = static_cast<int>((blue2 + m) * 255);

    // Ensure the RGB values are within the valid range
    pixel.r = max(0, min(255, pixel.r));
    pixel.g = max(0, min(255, pixel.g));
    pixel.b = max(0, min(255, pixel.b));
}

void applyHueSaturation(vector<vector<Pixel>> &image, float saturationValue, float hueValue)
{
    for (auto &row : image)
    {
        for (auto &pixel : row)
        {
            adjustHueSaturation(pixel, saturationValue, hueValue);
        }
    }
}