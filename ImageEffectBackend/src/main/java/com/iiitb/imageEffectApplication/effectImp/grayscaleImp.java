package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GrayscaleInterface;
import libraryInterfaces.Pixel;

public class grayscaleImp implements PhotoEffect{
    public     Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
        return GrayscaleInterface.applyGrayscale(image);
    }
}