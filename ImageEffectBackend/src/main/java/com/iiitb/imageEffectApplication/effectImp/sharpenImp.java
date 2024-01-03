// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

// Define the sharpenImp class implementing the SingleValueParameterizableEffect interface
public class sharpenImp implements SingleValueParameterizableEffect {

    // Declare a private float variable to store the sharpen value
    private float value = 0;

    // Override the apply method from the SingleValueParameterizableEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the sharpen value
        loggingService.addLog(fileName, "Sharpen", "Sharpen: " + value);

        // Apply the sharpen effect using the SharpenInterface
        return SharpenInterface.applySharpen(image, value);
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
