package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;

public class gaussianblurImp implements SingleValueParameterizableEffect{
    private float radius=0;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        return GaussianBlurInterface.applyGaussianBlur(image,radius);
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException{
        if(parameterValue>200 || parameterValue<0){
            throw new IllegalParameterException();
        }
        else{
            radius=parameterValue;
        }
    }

}