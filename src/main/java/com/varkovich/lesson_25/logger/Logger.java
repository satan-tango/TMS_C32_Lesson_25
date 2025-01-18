package com.varkovich.lesson_25.logger;

import com.varkovich.lesson_25.constants.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    public static void logInfo(String infoMessage) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            String dateToLog = sdf.format(date);
            String message = "[INFO] ->       " + dateToLog + " ->       " + infoMessage + "\n";
            Files.write(Paths.get(Constants.PATH_LOG), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
