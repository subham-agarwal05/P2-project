// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.FlipInterface;
import libraryInterfaces.Pixel;

// Define the flipImp class implementing the DiscreteEffect interface
public class flipImp implements DiscreteEffect {

    // Declare private variables to store the horizontal and vertical flip options
    private int hflip = 0;
    private int vflip = 0;

    // Override the apply method from the DiscreteEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the flip options
        loggingService.addLog(fileName, "Flip", "Vertical: " + vflip + " Horizontal: " + hflip);

        // Apply the flip using the FlipInterface
        return FlipInterface.applyFlip(image, hflip, vflip);
    }

    // Override the selectOptionValue method from the DiscreteEffect interface
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException {
        // Check the option name and set the corresponding flip option value
        if (optionName.equals("Horizontal")) {
            hflip = value;
        } else if (optionName.equals("Vertical")) {
            vflip = value;
        } else {
            // Throw an exception if an invalid option name is provided
            throw new IllegalParameterException();
        }
    }
}
