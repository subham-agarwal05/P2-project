// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;

// Define the gaussianblurImp class implementing the SingleValueParameterizableEffect interface
public class gaussianblurImp implements SingleValueParameterizableEffect {

    // Declare a private float variable to store the Gaussian blur radius
    private float radius = 0;

    // Override the apply method from the SingleValueParameterizableEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Apply the Gaussian blur using the GaussianBlurInterface
        return GaussianBlurInterface.applyGaussianBlur(image, radius);
    }

    // Override the setParameterValue method from the SingleValueParameterizableEffect interface
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        // Check if the parameter value is within bounds
        if (parameterValue > 200 || parameterValue < 0) {
            // Throw an exception if the value is out of bounds
            throw new IllegalParameterException();
        } else {
            // Set the value if it's within bounds
            radius = parameterValue;
        }
    }
}
