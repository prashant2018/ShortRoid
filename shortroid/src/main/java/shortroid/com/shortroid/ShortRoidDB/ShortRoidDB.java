package shortroid.com.shortroid.ShortRoidDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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


    // Query method which returns HashMap<row_num,List of columns>
    public List<HashMap<String,String>> query(String query) {


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int i,k=0;
        int column_count;
        int row_count = cursor.getCount();
        Log.v("rc", String.valueOf(row_count));


        List<HashMap<String,String>> map = new ArrayList<>();
        HashMap<String,String> tmap;
        if (cursor.moveToFirst()) {
            do {
                tmap = new HashMap<>();
                column_count = cursor.getColumnCount();

                for(i=0;i<column_count;i++) {
                    try {
                        tmap.put(cursor.getColumnName(i), cursor.getString(i));
                    } catch (Exception e) {
                        Log.v("cool", e.toString());
                    }
                }
                map.add(tmap);
            } while (cursor.moveToNext());

        }
        Log.v("map",map.toString());
        return map;
    }


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

