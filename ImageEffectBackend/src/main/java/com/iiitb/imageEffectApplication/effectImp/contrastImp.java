package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.ContrastInterface;
import libraryInterfaces.Pixel;

public class contrastImp implements SingleValueParameterizableEffect{
    private float value=0;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"Contrast","Contrast: "+value);
        return ContrastInterface.applyContrast(image,value);
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException{
        if(parameterValue>200 || parameterValue<0){
            throw new IllegalParameterException("value out of bounds");
        }
        else{
            value=parameterValue;
        }
    }

}