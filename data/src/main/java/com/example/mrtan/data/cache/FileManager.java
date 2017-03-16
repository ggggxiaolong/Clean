package com.example.mrtan.data.cache;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author mrtan on 17-3-16.
 */

class FileManager {

  static void writeToFile(File file, String fileContent) {
    if (!file.exists()) {
      try {
        FileWriter writer = new FileWriter(file);
        writer.write(fileContent);
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  static String readFromFile(File file) {
    StringBuilder stringBuilder = new StringBuilder();
    if (file.exists()) {
      try {
        String readLine;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((readLine = reader.readLine()) != null) {
          stringBuilder.append(readLine).append("\n");
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return stringBuilder.toString();
  }

  static boolean clearDirectory(File directory) {
    boolean result = false;
    if (directory.exists()) {
      for (File file : directory.listFiles()) {
        result = file.delete();
      }
    }
    return result;
  }

  static void write2Preferences(Context context, String preferenceName, String key, long value) {
    final SharedPreferences preferences =
        context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
    preferences.edit().putLong(key, value).apply();
  }

  static long getFromPreferences(Context context, String preferenceName, String key){
    return context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE).getLong(key, 0);
  }
}
