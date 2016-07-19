package shortroid.com.shortroid.ShortIntent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by prashant on 20/7/16.
 */
public class ShortIntent {

    private Context _context;
    public Intent intent;


    public ShortIntent(Context context){
        _context = context;

    }

    // calling
    public void call(String num){

        intent= new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + num));
        _context.startActivity(intent);
    }

    public void call(long num){

        intent= new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + num));
        _context.startActivity(intent);
    }

    // sms
    public void message(String address,String msg){

        String num = "smsto:"+address;
        Uri sms_uri = Uri.parse(num);
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms_intent.putExtra("sms_body", msg);
        _context.startActivity(sms_intent);

    }



}
