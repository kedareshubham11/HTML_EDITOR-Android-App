package com.example.htmleditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
import android.app.Activity;
import android.util.Log;
 
public class FileOperations extends Activity {
     public FileOperations() {
 
        }
 
     public Boolean write(String fname, String fcontent){
            try {
 
                String fpath = "/sdcard/"+fname+".html";
 
                File file = new File(fpath);
                // If file does not exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
 
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(fcontent);
                bw.close();
 
                Log.d("Suceess","Sucess");
                return true;
 
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
 
     }
 
     
}
