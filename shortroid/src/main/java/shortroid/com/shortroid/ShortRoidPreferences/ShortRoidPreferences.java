package shortroid.com.shortroid.ShortRoidPreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JohnConnor on 15-Jul-16.
 */
public class ShortRoidPreferences {
    // Shared Preferences
     SharedPreferences pref;
    // Editor for Shared preferences
     SharedPreferences.Editor editor; //
    // Context
     Context _context;
    // Shared pref mode
     int PRIVATE_MODE = 0;
    // Shared pref file name
     private String PREF_NAME;
    public ShortRoidPreferences(Context context,String preferenceName) throws FileNameException {
        if(preferenceName.length()!=0) {
        this._context = context;
        this.PREF_NAME = preferenceName;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
        else throw new FileNameException();
    }
    public ShortRoidPreferences(Context context,String preferenceName,int privateMode) throws FileNameException {
        if(preferenceName.length()!=0) {
        this._context = context;
        this.PREF_NAME = preferenceName;
        this.PRIVATE_MODE = privateMode;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
        else throw new FileNameException();
    }
    public ShortRoidPreferences(Context context)
    {
        this._context = context;
        this.PREF_NAME="Preferences";
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }
    public void setPrefString(String key,String value)
    {
        editor.putString(key, value).commit();
    }
    public void setPrefInt(String key,int value)
    {
        editor.putInt(key, value).commit();
    }
    public void setPrefBoolean(String key,boolean value)
    {
        editor.putBoolean(key, value).commit();
    }
    public void setPrefLong(String key,long value)
    {
        editor.putLong(key, value).commit();
    }
    public void setPrefFloat(String key,float value)
    {
        editor.putFloat(key, value).commit();
    }
    public String getPrefString(String key)
    {
        return  pref.getString(key,null);
    }
    public String getPrefString(String key,String defaultValue)
    {
        return  pref.getString(key,defaultValue);
    }
    public int getPrefInt(String key)
    {
        return  pref.getInt(key,0);
    }
    public int getPrefInt(String key,int defaultValue)
    {
        return  pref.getInt(key,defaultValue);
    }
    public boolean getPrefBoolean(String key)
    {
        return  pref.getBoolean(key,false);
    }
    public boolean getPrefBoolean(String key,boolean defaultValue)
    {
        return  pref.getBoolean(key,defaultValue);
    }
    public long getPrefLong(String key)
    {
        return  pref.getLong(key,0L);
    }
    public long getPrefLong(String key,long defaultValue)
    {
        return  pref.getLong(key,defaultValue);
    }
    public float getPrefFloat(String key)
    {
        return  pref.getFloat(key,0f);
    }
    public float getPrefFloat(String key,float defaultValue)
    {
        return  pref.getFloat(key,defaultValue);
    }

}
