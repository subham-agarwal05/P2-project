//package com.iiitb.imageEffectApplication.effectImp;
//import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
//import com.iiitb.imageEffectApplication.service.LoggingService;
//import libraryInterfaces.InvertInterface;
//import libraryInterfaces.Pixel;
//
//public class invertImp implements PhotoEffect{
//    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
//
//        return InvertInterface.applyInvert(image);
//    }
//}

package com.iiitb.imageEffectApplication.effectImp;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class invertImp implements PhotoEffect{
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService){
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        Date date = new Date();
//        String timestamp = formatter.format(date);
        loggingService.addLog(fileName, "Invert", "None");
        return InvertInterface.applyInvert(image);
    }
}