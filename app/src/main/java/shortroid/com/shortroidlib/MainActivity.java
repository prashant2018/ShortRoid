package shortroid.com.shortroidlib;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import shortroid.com.shortroid.ShortIntent.ShortIntent;
import shortroid.com.shortroid.ShortRoidPreferences.ShortRoidPreferences;

public class MainActivity extends AppCompatActivity {
    ShortRoidPreferences shortRoidPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        /*
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

        String update = "UPDATE TABLE_TEST SET KEY = 191 WHERE NAME=\"Rishabh\" ";
        System.out.println(sdb.anyQuery(update));
        TextView tv = (TextView)findViewById(R.id.text);

        data.put("KEY",32);
        data.put("NAME","Saurabh");
        sdb.insert(data);
        data.put("KEY",41);
        data.put("NAME","Rishabh");
        sdb.insert(data);
        String q = "SELECT * FROM TABLE_TEST";

        List<HashMap<String,String>> list;
        Log.v("L","h");
        list = sdb.query(q);
        Log.v("no","h");
        String s="";
        for(HashMap<String,String> hmap:list){
            System.out.println(hmap.get("NAME"));
            s = s+hmap.get("NAME")+" "+hmap.get("KEY")+" \n";
        }



        tv.setText(s);
    */
    }
public void funct(View v){

    ShortIntent si = new ShortIntent(this);
    //si.message("8984511995","hello");
    //si.email("prashtechno@gmail.com","test","yo pk");
    //si.call("8984511995");
    Uri uri = Uri.parse("android.resource://shortroid.com.shortroidlib/drawable/ic_launcher.png");
    si.shareImage(uri);

}
}
