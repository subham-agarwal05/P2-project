// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SepiaInterface;

// Define the sepiaImp class implementing the PhotoEffect interface
public class sepiaImp implements PhotoEffect {

    // Override the apply method from the PhotoEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the sepia effect
        loggingService.addLog(fileName, "Sepia", "None");

        // Apply the sepia effect using the SepiaInterface
        return SepiaInterface.applySepia(image);
    }
}
