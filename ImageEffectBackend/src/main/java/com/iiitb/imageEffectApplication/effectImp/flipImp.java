package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.FlipInterface;
import libraryInterfaces.Pixel;

public class flipImp implements DiscreteEffect{
    private int hflip=0,vflip=0;
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        loggingService.addLog(fileName,"Flip","Verical: "+vflip+"Horizontal: "+hflip);
        return FlipInterface.applyFlip(image,hflip,vflip);
    }
    public void selectOptionValue(String optionName, int value) throws IllegalParameterException{
        if(optionName.equals("Horizontal")) hflip=value;
        else if(optionName.equals("Vertical")) vflip=value;
        else{
            throw new IllegalParameterException();
        }
    }
}