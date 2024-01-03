// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.HueSaturationInterface;
import libraryInterfaces.Pixel;

// Define the huesatImp class implementing the ParameterizableEffect interface
public class huesatImp implements ParameterizableEffect {

    // Declare private variables to store the hue and saturation values
    private float hvalue = 0;
    private float svalue = 0;

    // Override the apply method from the ParameterizableEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the hue and saturation values
        loggingService.addLog(fileName, "HueSaturation", "Hue: " + hvalue + " Saturation: " + svalue);

        // Apply the hue and saturation using the HueSaturationInterface
        return HueSaturationInterface.applyHueSaturation(image, svalue, hvalue);
    }

    // Override the setParameter method from the ParameterizableEffect interface
    public void setParameter(String paramName, float value) throws IllegalParameterException {
        // Check if the parameter name and value are within bounds
        if ((paramName.equals("saturation") && (value > 100 || value < 0)) || (paramName.equals("hue") && (value > 360 || value < 0))) {
            // Throw an exception if the value is out of bounds
            throw new IllegalParameterException("value out of bounds");
        } else {
            // Set the value based on the parameter name
            if (paramName.equals("saturation")) {
                svalue = value;
            }
            if (paramName.equals("hue")) {
                hvalue = value;
            }
        }
    }
}
