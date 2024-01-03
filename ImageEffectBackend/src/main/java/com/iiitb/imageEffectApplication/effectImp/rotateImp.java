package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.RotationInterface;

public class rotateImp implements SingleValueDiscreteEffect{
    private int value;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        return RotationInterface.applyRotation(image,value);
    }
    public void setParameterValue(int parameterValue) throws IllegalParameterException{
        if (parameterValue==0 || parameterValue== 1|| parameterValue==2 || parameterValue==3){
            value=parameterValue*90;
        }
        else {
            throw new IllegalParameterException("value out of bounds");
        }
    }


}