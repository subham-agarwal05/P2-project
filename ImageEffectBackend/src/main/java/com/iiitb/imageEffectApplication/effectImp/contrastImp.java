// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.ContrastInterface;
import libraryInterfaces.Pixel;

// Define the contrastImp class implementing the SingleValueParameterizableEffect interface
public class contrastImp implements SingleValueParameterizableEffect {

    // Declare a private float variable to store the contrast value
    private float value = 0;

    // Override the apply method from the SingleValueParameterizableEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the contrast value
        loggingService.addLog(fileName, "Contrast", "Contrast: " + value);

        // Apply the contrast using the ContrastInterface
        return ContrastInterface.applyContrast(image, value);
    }

    // Override the setParameterValue method from the SingleValueParameterizableEffect interface
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        // Check if the parameter value is within bounds
        if (parameterValue > 200 || parameterValue < 0) {
            // Throw an exception if the value is out of bounds
            throw new IllegalParameterException("value out of bounds");
        } else {
            // Set the value if it's within bounds
            value = parameterValue;
        }
    }
}
