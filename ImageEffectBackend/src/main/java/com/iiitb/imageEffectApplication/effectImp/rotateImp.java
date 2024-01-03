// Specify the package where the class belongs
package com.iiitb.imageEffectApplication.effectImp;

// Import necessary classes and interfaces
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.RotationInterface;

// Define the rotateImp class implementing the SingleValueDiscreteEffect interface
public class rotateImp implements SingleValueDiscreteEffect {

    // Declare a private variable to store the rotation value
    private int value;

    // Override the apply method from the SingleValueDiscreteEffect interface
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        // Log the rotation degree
        loggingService.addLog(fileName, "Rotation", "Rotation degree: " + value);

        // Apply the rotation using the RotationInterface
        return RotationInterface.applyRotation(image, value);
    }

    // Override the setParameterValue method from the SingleValueDiscreteEffect interface
    public void setParameterValue(int parameterValue) throws IllegalParameterException {
        // Check if the parameter value is within bounds
        if (parameterValue == 0 || parameterValue == 1 || parameterValue == 2 || parameterValue == 3) {
            // Convert the parameter value to degrees (0, 90, 180, 270)
            value = parameterValue * 90;
        } else {
            // Throw an exception if the value is out of bounds
            throw new IllegalParameterException("value out of bounds");
        }
    }
}
