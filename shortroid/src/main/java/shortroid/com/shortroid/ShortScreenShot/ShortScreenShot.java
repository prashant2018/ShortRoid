package shortroid.com.shortroid.ShortScreenShot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by prashant on 6/10/16.
 */
public class ShortScreenShot {

    Activity activity;
    Context context;

    public ShortScreenShot(Activity activity){
        this.activity = activity;
        context = activity;
    }

    public void share(int id,String message){
        String path= Environment.getExternalStorageDirectory()+ File.separator+"Screenshot.jpeg";
        File imageFile=new File(path);
        // create bitmap screen capture
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        View v = activity.getWindow().getDecorView().findViewById(id).getRootView();
        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(returnedBitmap);
        v.draw(c);
        // v1.setDrawingCacheEnabled( false);
        OutputStream fout = null ;
        try {
            fout = new FileOutputStream(imageFile);
            returnedBitmap.compress(Bitmap.CompressFormat.JPEG, 90 , fout);
            fout.flush();
            fout.close();

        } catch ( FileNotFoundException e) {
            // TODO Auto-generated catch block
            Toast.makeText(context,"File not found!", Toast.LENGTH_SHORT).show();
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Toast.makeText(context, "IO Exception!", Toast.LENGTH_SHORT).show();
            // e.printStackTrace();
        }

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("image/*");
        i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile( new File (path)));
        i.putExtra(Intent.EXTRA_TEXT,message);
        context.startActivity(i);
    }

    public void share(int id){
        String path= Environment.getExternalStorageDirectory()+ File.separator+"Screenshot.jpeg";
        File imageFile=new File(path);
        // create bitmap screen capture
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        View v = activity.getWindow().getDecorView().findViewById(id).getRootView();
        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels, View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
                v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(returnedBitmap);
        v.draw(c);
        // v1.setDrawingCacheEnabled( false);
        OutputStream fout = null ;
        try {
            fout = new FileOutputStream(imageFile);
            returnedBitmap.compress(Bitmap.CompressFormat.JPEG, 90 , fout);
            fout.flush();
            fout.close();

        } catch ( FileNotFoundException e) {
            // TODO Auto-generated catch block
            Toast.makeText(context,"File not found!", Toast.LENGTH_SHORT).show();
            // e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Toast.makeText(context, "IO Exception!", Toast.LENGTH_SHORT).show();
            // e.printStackTrace();
        }

        Intent i = new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.setType("image/*");
        i.putExtra(Intent.EXTRA_STREAM, Uri.fromFile( new File (path)));
        context.startActivity(i);
    }

}
