package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.ParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.HueSaturationInterface;
import libraryInterfaces.Pixel;

public class huesatImp implements ParameterizableEffect{
    private float hvalue=0, svalue=0;
    public     Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"HueSaturation","Hue: "+hvalue+" Saturation: "+svalue);
        return HueSaturationInterface.applyHueSaturation(image,svalue,hvalue);
    }
    public void setParameter(String paramName, float value) throws IllegalParameterException{
        if ((paramName.equals( "saturation") && (value>100 || value<0) || (paramName.equals("hue") && (value>360 || value<0)))){
            throw new IllegalParameterException("value out of bounds");
        }

        else{
            if (paramName.equals("saturation"))    svalue = value;
            if (paramName.equals("hue"))   hvalue = value;

        }
    }

}