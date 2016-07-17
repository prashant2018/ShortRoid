package shortroid.com.shortroid.ShortRoidDB;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by prashant on 15/7/16.
 */
public class ShortRoidDB extends SQLiteOpenHelper {

    private String DB_NAME;
    private String TABLE_NAME;
    private int DB_VERSION;
    private HashMap<String, String> ATTRIBUTES;
    public String CREATE_QUERY = ""; //create_query is for creating table


    public ShortRoidDB(Context context, String db_name, int version, String table_name, HashMap<String, String> attributes) {
        super(context, db_name, null, version);


        TABLE_NAME = table_name;
        DB_NAME = db_name;
        ATTRIBUTES = attributes;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " ( ";

        for (HashMap.Entry<String, String> entry : ATTRIBUTES.entrySet()) {
            CREATE_QUERY += entry.getKey() + " " + entry.getValue() + ", ";
        }

        int l = CREATE_QUERY.length();
        CREATE_QUERY = CREATE_QUERY.substring(0, l - 2);
        CREATE_QUERY += " )";

        // for testing

        db.execSQL(CREATE_QUERY);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public void insert(HashMap<String, Object> attributes) {

        // HashMap <Attribute, Value>

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        for (HashMap.Entry<String, Object> attr : attributes.entrySet()) {

            Object ob = attr.getValue();

            if (ob.getClass().equals(Integer.class))
                values.put(attr.getKey(), (Integer) ob);

            if (ob.getClass().equals(Float.class))
                values.put(attr.getKey(), (Float) ob);

            if (ob.getClass().equals(Double.class))
                values.put(attr.getKey(), (Double) ob);

            if (ob.getClass().equals(Boolean.class))
                values.put(attr.getKey(), (Boolean) ob);

            if (ob.getClass().equals(String.class))
                values.put(attr.getKey(), (String) ob);

            if (ob.getClass().equals(Long.class))
                values.put(attr.getKey(), (Long) ob);

            if (ob.getClass().equals(Short.class))
                values.put(attr.getKey(), (Short) ob);

        }

        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.v("Insert","Wow");

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public HashMap query2(String query) {

        HashMap map = new HashMap<Integer,List>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int i,k=0;
        int column_count;
        Object ob;
        List<Object> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                column_count = cursor.getColumnCount();

                for(i=0;i<column_count;i++){
                    ob = cursor.getType(i);
                    if(ob.equals(Integer.class)) {
                        list.add(cursor.getInt(i));
                        Log.v("Query",String.valueOf(cursor.getInt(i)));
                    }

                    if(ob.equals(String.class)) {
                        list.add(cursor.getString(i));

                    }
                    if(ob.equals(Float.class))
                        list.add(cursor.getFloat(i));

                    if(ob.equals(Double.class))
                        list.add(cursor.getDouble(i));

                    if(ob.equals(Short.class))
                        list.add(cursor.getShort(i));

                    if(ob.equals(Long.class))
                        list.add(cursor.getLong(i));

                    if(ob.equals(Blob.class))
                        list.add(cursor.getBlob(i));
                }
                map.put(k,list);
                k++;
            } while (cursor.moveToNext());

        }

        return map;
    }


    // Query method which returns HashMap<row_num,List of columns>
    public HashMap<Integer,List<String>> query(String query) {

        HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int i,k=0;
        int column_count;
        Object ob;
        List<String> list;
        if (cursor.moveToFirst()) {
            do {
                list = new ArrayList<>();
                column_count = cursor.getColumnCount();
                Log.v("cool",cursor.getString(0));
                for(i=0;i<column_count;i++){
                    list.add(cursor.getString(i));
                }
                map.put(k, list);
                k++;
            } while (cursor.moveToNext());

        }

        return map;
    }


    // Queries like update, delete, alter
    public boolean anyQuery(String query){

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();
            c.close();
            return true;
        }
        catch (SQLiteAbortException e){
            Log.e("Update",e.toString());
            return false;
        }

    }

}

