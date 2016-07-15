package shortroid.com.shortroidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import shortroid.com.shortroid.ShortRoidDB.ShortRoidDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String,String> attributes = new HashMap<>();
        attributes.put("KEY","INTEGER");
        attributes.put("NAME","TEXT");
        ShortRoidDB sdb = new ShortRoidDB(MainActivity.this,"DATABASE_NAME",1,"TABLE_TEST",attributes);

        System.out.println(sdb.CREATE_QUERY);

        sdb.insert();
    }
}
