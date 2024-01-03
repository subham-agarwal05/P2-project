// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GrayscaleInterface;
import libraryInterfaces.Pixel;

// Define the grayscaleImp class implementing the PhotoEffect interface
public class grayscaleImp implements PhotoEffect {

    // Override the apply method from the PhotoEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the grayscale effect
        loggingService.addLog(fileName, "Grayscale", "None");

        // Apply the grayscale effect using the GrayscaleInterface
        return GrayscaleInterface.applyGrayscale(image);
    }
}
