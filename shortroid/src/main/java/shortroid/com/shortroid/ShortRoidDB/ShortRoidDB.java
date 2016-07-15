package shortroid.com.shortroid.ShortRoidDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by prashant on 15/7/16.
 */
public class ShortRoidDB extends SQLiteOpenHelper {

    private String DB_NAME;
    private String TABLE_NAME;
    private int DB_VERSION;
    private HashMap<String,String> ATTRIBUTES;
    public String CREATE_QUERY = ""; //create_query is for creating table


    public ShortRoidDB(Context context, String db_name, int version, String table_name, HashMap<String,String> attributes) {
        super(context, db_name,null, version);


        TABLE_NAME = table_name;
        DB_NAME = db_name;
        ATTRIBUTES = attributes;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        CREATE_QUERY =  "CREATE TABLE "+TABLE_NAME+" ( " ;

        for (HashMap.Entry<String, String> entry : ATTRIBUTES.entrySet()){
            CREATE_QUERY += entry.getKey() +" "+ entry.getValue()+", ";
        }

        int l = CREATE_QUERY.length();
        CREATE_QUERY = CREATE_QUERY.substring(0,l-2);
        CREATE_QUERY += " )";

        // for testing

        db.execSQL(CREATE_QUERY);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    //TODO : Complete insert
    // Following is dummy for testing
    public void insert(){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("KEY", 1); // Contact Name
        values.put("NAME", "Prashant"); // Contact Phone Number
        System.out.print(CREATE_QUERY);
        Log.v("PK","woho "+CREATE_QUERY);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

}

