package shortroid.com.shortroid.ShortFiles;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import shortroid.com.shortroid.ShortRoidPreferences.FileNameException;

/**
 * Created by prashant on 9/8/16.
 */
public class ShortInternalStorage {

    private Context context;
    private FileOutputStream fos;
    private FileInputStream fin;
    private char mode;

    public ShortInternalStorage(Context context,String filename, char mode){
        this.context = context;
        this.mode = mode;

        if(mode == 'r' || mode == 'R'){
            try {
                fin = context.openFileInput(filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(mode == 'w' || mode == 'W'){
            try {
                fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public ShortInternalStorage(Context context,String filename, char mode, int mode_context){
        this.context = context;
        this.mode = mode;

        if(mode == 'r' || mode == 'R'){
            try {
                fin = context.openFileInput(filename);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(mode == 'w' || mode == 'W'){

            try {
                fos = context.openFileOutput(filename, mode_context);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void write(String content){
        try {
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(){
        int res = -999;
        try {
            res = fin.read();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return "";
    }

    public void close(){
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public File getFilesDir(){
        return context.getFilesDir();
    }

    public File getDir(String fname, int i){
        return context.getDir(fname,i);
    }

    public boolean deleteFile(String fname){
        return context.deleteFile(fname);
    }

    public String[] fileList(){
        return context.fileList();
    }

}
