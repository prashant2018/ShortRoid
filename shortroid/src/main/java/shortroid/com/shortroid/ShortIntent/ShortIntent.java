package shortroid.com.shortroid.ShortIntent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;

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

    // email
    public void email(String to,String sub, String body){
        intent = new Intent(Intent.ACTION_SEND);

        intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
        intent.putExtra(Intent.EXTRA_TEXT,body);

        _context.startActivity(Intent.createChooser(intent, "Send mail..."));

    }

    public void email(String to,String sub, String body,String cc){
        intent = new Intent(Intent.ACTION_SEND);

        intent.setData(Uri.parse("mailto:"));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_CC, cc);
        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
        intent.putExtra(Intent.EXTRA_TEXT,body);
        _context.startActivity(Intent.createChooser(intent, "Send mail..."));
    }

    public void shareImage(Uri uri){

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("image/*");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, uri);
        _context.startActivity(Intent.createChooser(sharingIntent, "Share image using"));
        Toast.makeText(_context,"Works",Toast.LENGTH_LONG).show();
    }

    public void shareImage(String path){
        final Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        final File photoFile = new File(_context.getFilesDir(), path);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(photoFile));
        _context.startActivity(Intent.createChooser(shareIntent, "Share image using"));
    }





}
