package shortroid.com.shortroidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import shortroid.com.shortroid.ShortRoidDB.ShortRoidDB;
import shortroid.com.shortroid.ShortRoidPreferences.FileNameException;
import shortroid.com.shortroid.ShortRoidPreferences.ShortRoidPreferences;

public class MainActivity extends AppCompatActivity {
    ShortRoidPreferences shortRoidPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            shortRoidPreferences=new ShortRoidPreferences(this,"Preferences");
        } catch (FileNameException e) {
            e.printStackTrace();
        }
        shortRoidPreferences.setPrefString("Example","JustTesting");
        Log.d("TAG",shortRoidPreferences.getPrefString("Example"));
        HashMap<String,String> attributes = new HashMap<>();
        HashMap<String,Object> data = new HashMap<>();

        attributes.put("KEY","TEXT");
        attributes.put("NAME","TEXT");
        ShortRoidDB sdb = new ShortRoidDB(MainActivity.this,"DATABASE_NAME",4,"TABLE_TEST",attributes);


        TextView tv = (TextView)findViewById(R.id.text);

        data.put("KEY",32.3);
        data.put("NAME","Saurabh");
        sdb.insert(data);
        data.put("KEY",41);
        data.put("NAME","Rishabh");
        sdb.insert(data);
        String q = "SELECT * FROM TABLE_TEST";

        HashMap<Integer,List<String>> list;
        list = sdb.query(q);
        System.out.println(list.toString());
        tv.setText(list.toString());
    }
}
