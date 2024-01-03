package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

public class sharpenImp implements SingleValueParameterizableEffect{
    private float value=0;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"Sharpen","Sharpen: "+value);
        return SharpenInterface.applySharpen(image,value);
    }
    public     void setParameterValue(float parameterValue) throws IllegalParameterException{
        if(parameterValue>200 || parameterValue<0){
            throw new IllegalParameterException("value out of bounds");
        }
        else{
            value=parameterValue;
        }
    }

}