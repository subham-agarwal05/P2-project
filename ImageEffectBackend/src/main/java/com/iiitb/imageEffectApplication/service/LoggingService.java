package com.iiitb.imageEffectApplication.service;
import com.iiitb.imageEffectApplication.model.LogModel;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Date;

@Service
public class LoggingService {
    int fileId = 1;
    ArrayList <LogModel> logs = new ArrayList<LogModel>();
    File file = new File("logFile.txt");

    public void addLog(String fileName, String effectName, String optionValues) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String timestamp = dtf.format(now);
        LogModel log = new LogModel(timestamp, fileName, effectName, optionValues);
        try {
            FileWriter Writer = new FileWriter("logFile.txt");
            Writer.write(timestamp + "\t" + fileName + "\t" + effectName + "\t" + optionValues);
            Writer.close();
            //System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        logs.add(log);
        return;
    }

    public List<LogModel> getAllLogs() {
        return logs;
    }

    public List<LogModel> getLogsByEffect(String effectName) {
        ArrayList <LogModel> myLogs = new ArrayList<LogModel>();
        for(int i = 0; i<logs.size(); i++){
            LogModel myLog = logs.get(i);
            if(effectName.equals(myLog.getEffectName())){
                myLogs.add(myLog);
            }
        }
        return myLogs;
    }

    public void clearLogs() {
        File nFile = new File("logFile" + String.valueOf(fileId) + ".txt");
        file = nFile;
        fileId++;
        logs.clear();
    }

    public List<LogModel> getLogsBetweenTimestamps(LocalDateTime startTime, LocalDateTime endTime) {
        ArrayList <LogModel> myLogs = new ArrayList<LogModel>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t1 = dtf.format(startTime);
        String t2 = dtf.format(endTime);
        Date start = new Date();
        Date end = new Date();
        try{
            start = sdf.parse(t1);
            end = sdf.parse(t2);
        }
        catch(ParseException p){
            System.out.println("Parse exception");
        }
        for(int i = 0; i<logs.size(); i++){
            LogModel myLog = logs.get(i);
            Date curr = new Date();
            try{
                curr = sdf.parse(myLog.getTimestamp());
            }
            catch(ParseException p){
                System.out.println("Parse exception");
            }
            if((curr.after(start) || curr.equals(start)) && (curr.before(end) || curr.equals(end))){
                myLogs.add(myLog);
            }
        }
        return myLogs;
    }
}