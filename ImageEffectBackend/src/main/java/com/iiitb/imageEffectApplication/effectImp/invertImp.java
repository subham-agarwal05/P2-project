// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;

// Define the invertImp class implementing the PhotoEffect interface
public class invertImp implements PhotoEffect {

    // Override the apply method from the PhotoEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the invert effect
        loggingService.addLog(fileName, "Invert", "None");

        // Apply the invert effect using the InvertInterface
        return InvertInterface.applyInvert(image);
    }
}
