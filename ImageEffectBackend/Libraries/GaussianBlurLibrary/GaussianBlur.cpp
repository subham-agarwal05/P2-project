#include "GaussianBlur.h"
#include <vector>
#include "../Pixel.h"
#include <math.h>
using namespace std;

void applyGaussianBlur(vector<vector<Pixel>>& image, float amount) {
    int size = amount;
    if (amount <= 3) size = 3;
    else if (!(static_cast<int>(amount) & 1)) size = static_cast<int>(amount) - 1;

    int width = image[0].size();
    int height = image.size();
    vector<float> kernel;

    // Generate the Gaussian kernel
    for (int i = -size / 2; i <= size / 2; ++i) {
        float value = exp(-(i * i) / (2 * pow(size / 2.0, 2))) / (sqrt(2 * M_PI) * (size / 2.0));
        kernel.push_back(value);
    }

    // Normalize the kernel
    float sum = 0;
    for (float value : kernel) {
        sum += value;
    }
    for (float& value : kernel) {
        value /= sum;
    }

    // Apply convolution separately horizontally and vertically
    vector<vector<Pixel>> tempImage = image; // Create a temporary image to store intermediate results

    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {

            auto r = 0;
            auto b=0;
            auto g=0;

            for (int i = -size / 2; i <= size / 2; ++i) {
                int x_offset = max(0, min(x + i, width - 1));
                int y_offset = max(0, min(y + i, height - 1));

                r += kernel[i + size / 2] * tempImage[y_offset][x].r;
                g += kernel[i + size / 2] * tempImage[y_offset][x].g;
                b += kernel[i + size / 2] * tempImage[y_offset][x].b;
            }

            image[y][x].r = r;
            image[y][x].b=b;
            image[y][x].g=g;

        }
    }

    for (int y = 0; y < height; ++y) {
        for (int x = 0; x < width; ++x) {
            // Pixel result;
            // result.r = result.b = result.g = 0;
            auto rcheck = 0;
            auto bcheck=0;
            auto gcheck=0;

            for (int i = -size / 2; i <= size / 2; ++i) {
                int y_offset = max(min(y + i, height - 1),0);
                int x_offset = max(min(x + i, width - 1),0);

                rcheck += kernel[i + size / 2] * image[y][x_offset].r;
                gcheck += kernel[i + size / 2] * image[y][x_offset].g;
                bcheck += kernel[i + size / 2] * image[y][x_offset].b;
            }

            image[y][x].r = rcheck;
            image[y][x].b=bcheck;
            image[y][x].g=gcheck;
        }
    }
}
