package shortroid.com.shortroid.ShortAnimation;

import android.content.Context;

import android.view.View;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by JohnConnor on 19-Jul-16.
 */
public class ShortAnimation {

    public static class FadeInAnimation
    {   public static final int INFINITE=-1;
        public static final int RESTART=1;
        public static final int REVERSE=2;
        private View v;
        private int duration=500;
        private int repeatCount=0;
        private boolean fillAfter=false;
        private boolean fillBefore=false;
        private boolean fill=false;
        private int repeatMode=0;
        private Interpolator interpolator;
        AlphaAnimation alphaAnimation;
        TranslateAnimation t;
        public FadeInAnimation(View v)
        {
            this.v=v;
            alphaAnimation=new AlphaAnimation(1.0f,0.0f);
            interpolator=new AccelerateInterpolator();
        }
        public FadeInAnimation(View v,float from,float to)
        {
            this.v=v;
            alphaAnimation=new AlphaAnimation(from,to);
            interpolator=new AccelerateInterpolator();
        }

        public int getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(int repeatMode) {
            this.repeatMode = repeatMode;
            alphaAnimation.setRepeatMode(repeatMode);
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
            alphaAnimation.setRepeatCount(repeatCount);
        }

        public void startAnimation()
        {
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(int duration)
        {   alphaAnimation.setDuration(duration);
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(final ShortAnimationListener shortAnimationListener)
        {
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(int duration,final ShortAnimationListener shortAnimationListener)
        {   alphaAnimation.setDuration(duration);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(alphaAnimation);
        }
        public Interpolator getInterpolator() {
            return interpolator;
        }

        public void setInterpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            alphaAnimation.setInterpolator(interpolator);
        }

        public void setInterpolator(Context context,int resId)
        {
            alphaAnimation.setInterpolator(context, resId);
        }

        public boolean isFillBefore() {
            return fillBefore;
        }

        public void setFillBefore(boolean fillBefore) {
            this.fillBefore = fillBefore;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            alphaAnimation.setFillEnabled(fill);
        }

        public boolean isFillAfter() {
            return fillAfter;
        }

        public void setFillAfter(boolean fillAfter) {
            this.fillAfter = fillAfter;
            alphaAnimation.setFillAfter(fillAfter);
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
            alphaAnimation.setDuration(duration);
        }



    }
    public static class FadeOutAnimation
    {   public static final int INFINITE=-1;
        public static final int RESTART=1;
        public static final int REVERSE=2;
        private View v;
        private int duration=500;
        private int repeatCount=0;
        private boolean fillAfter=false;
        private boolean fillBefore=false;
        private boolean fill=false;
        private int repeatMode=0;
        private Interpolator interpolator;
        AlphaAnimation alphaAnimation;
        public FadeOutAnimation(View v)
        {
            this.v=v;
            alphaAnimation=new AlphaAnimation(0.0f,1.0f);
            interpolator=new AccelerateInterpolator();
        }
        public FadeOutAnimation(View v,float from,float to)
        {
            this.v=v;
            alphaAnimation=new AlphaAnimation(from,to);
            interpolator=new AccelerateInterpolator();
        }

        public int getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(int repeatMode) {
            this.repeatMode = repeatMode;
            alphaAnimation.setRepeatMode(repeatMode);
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
            alphaAnimation.setRepeatCount(repeatCount);
        }

        public void startAnimation()
        {
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(int duration)
        {   alphaAnimation.setDuration(duration);
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(final ShortAnimationListener shortAnimationListener)
        {
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(alphaAnimation);
        }
        public void startAnimation(int duration,final ShortAnimationListener shortAnimationListener)
        {   alphaAnimation.setDuration(duration);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(alphaAnimation);
        }
        public Interpolator getInterpolator() {
            return interpolator;
        }

        public void setInterpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            alphaAnimation.setInterpolator(interpolator);
        }

        public void setInterpolator(Context context,int resId)
        {
            alphaAnimation.setInterpolator(context, resId);
        }

        public boolean isFillBefore() {
            return fillBefore;
        }

        public void setFillBefore(boolean fillBefore) {
            this.fillBefore = fillBefore;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            alphaAnimation.setFillEnabled(fill);
        }

        public boolean isFillAfter() {
            return fillAfter;
        }

        public void setFillAfter(boolean fillAfter) {
            this.fillAfter = fillAfter;
            alphaAnimation.setFillAfter(fillAfter);
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
            alphaAnimation.setDuration(duration);
        }



    }
    public static class RotateAnimation
    {   public static final int INFINITE=-1;
        public static final int RESTART=1;
        public static final int REVERSE=2;
        private View v;
        private int duration=500;
        private int repeatCount=0;
        private boolean fillAfter=false;
        private boolean fillBefore=false;
        private boolean fill=false;
        private int repeatMode=0;
        private Interpolator interpolator;
        android.view.animation.RotateAnimation rotateAnimation;
        public RotateAnimation(View v)
        {
            this.v=v;
            rotateAnimation=new android.view.animation.RotateAnimation(0.0f,180f);
            interpolator=new AccelerateInterpolator();
        }
        public RotateAnimation(View v,float from,float to)
        {
            this.v=v;
            rotateAnimation=new android.view.animation.RotateAnimation(from,to);
            interpolator=new AccelerateInterpolator();
        }
        public RotateAnimation(View v,float fromDegrees, float toDegrees, float pivotX, float pivotY)
        {
            this.v=v;
            rotateAnimation=new android.view.animation.RotateAnimation(fromDegrees,toDegrees,pivotX,pivotY);
            interpolator=new AccelerateInterpolator();
        }
        public RotateAnimation(View v,float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
                               int pivotYType, float pivotYValue)
        {
            this.v=v;
            rotateAnimation=new android.view.animation.RotateAnimation(fromDegrees,toDegrees,pivotXType,pivotXValue,pivotYType,pivotYValue);
            interpolator=new AccelerateInterpolator();
        }
        public int getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(int repeatMode) {
            this.repeatMode = repeatMode;
            rotateAnimation.setRepeatMode(repeatMode);
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
            rotateAnimation.setRepeatCount(repeatCount);
        }

        public void startAnimation()
        {
            v.startAnimation(rotateAnimation);
        }
        public void startAnimation(int duration)
        {   rotateAnimation.setDuration(duration);
            v.startAnimation(rotateAnimation);
        }
        public void startAnimation(final ShortAnimationListener shortAnimationListener)
        {
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(rotateAnimation);
        }
        public void startAnimation(int duration,final ShortAnimationListener shortAnimationListener)
        {   rotateAnimation.setDuration(duration);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(rotateAnimation);
        }
        public Interpolator getInterpolator() {
            return interpolator;
        }

        public void setInterpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            rotateAnimation.setInterpolator(interpolator);
        }

        public void setInterpolator(Context context,int resId)
        {
            rotateAnimation.setInterpolator(context, resId);
        }

        public boolean isFillBefore() {
            return fillBefore;
        }

        public void setFillBefore(boolean fillBefore) {
            this.fillBefore = fillBefore;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            rotateAnimation.setFillEnabled(fill);
        }

        public boolean isFillAfter() {
            return fillAfter;
        }

        public void setFillAfter(boolean fillAfter) {
            this.fillAfter = fillAfter;
            rotateAnimation.setFillAfter(fillAfter);
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
            rotateAnimation.setDuration(duration);
        }



    }
    public static class ScaleAnimation
    {   public static final int INFINITE=-1;
        public static final int RESTART=1;
        public static final int REVERSE=2;
        private View v;
        private int duration=500;
        private int repeatCount=0;
        private boolean fillAfter=false;
        private boolean fillBefore=false;
        private boolean fill=false;
        private int repeatMode=0;
        private Interpolator interpolator;
        android.view.animation.ScaleAnimation scaleAnimation;
        public ScaleAnimation(View v)
        {
            this.v=v;
            scaleAnimation=new android.view.animation.ScaleAnimation(2f,0f,2f,0f);
            interpolator=new AccelerateInterpolator();
        }
        public ScaleAnimation(View v,float fromX, float toX, float fromY, float toY)
        {
            this.v=v;
            scaleAnimation=new android.view.animation.ScaleAnimation(fromX,toX,fromY,toY);
            interpolator=new AccelerateInterpolator();
        }
        public ScaleAnimation(View v,float fromX, float toX, float fromY, float toY,
                              float pivotX, float pivotY)
        {
            this.v=v;
            scaleAnimation=new android.view.animation.ScaleAnimation(fromX,toX,fromY,toY,pivotX,pivotY);
            interpolator=new AccelerateInterpolator();
        }
        public ScaleAnimation(View v,float fromX, float toX, float fromY, float toY,
                              int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
        {
            this.v=v;
            scaleAnimation=new android.view.animation.ScaleAnimation(fromX,toX,fromY,toY,pivotXType,pivotXValue,pivotYType,pivotYValue);
            interpolator=new AccelerateInterpolator();
        }
        public int getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(int repeatMode) {
            this.repeatMode = repeatMode;
            scaleAnimation.setRepeatMode(repeatMode);
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
            scaleAnimation.setRepeatCount(repeatCount);
        }

        public void startAnimation()
        {
            v.startAnimation(scaleAnimation);
        }
        public void startAnimation(int duration)
        {   scaleAnimation.setDuration(duration);
            v.startAnimation(scaleAnimation);
        }
        public void startAnimation(final ShortAnimationListener shortAnimationListener)
        {
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(scaleAnimation);
        }
        public void startAnimation(int duration,final ShortAnimationListener shortAnimationListener)
        {   scaleAnimation.setDuration(duration);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(scaleAnimation);
        }
        public Interpolator getInterpolator() {
            return interpolator;
        }

        public void setInterpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            scaleAnimation.setInterpolator(interpolator);
        }

        public void setInterpolator(Context context,int resId)
        {
            scaleAnimation.setInterpolator(context, resId);
        }

        public boolean isFillBefore() {
            return fillBefore;
        }

        public void setFillBefore(boolean fillBefore) {
            this.fillBefore = fillBefore;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            scaleAnimation.setFillEnabled(fill);
        }

        public boolean isFillAfter() {
            return fillAfter;
        }

        public void setFillAfter(boolean fillAfter) {
            this.fillAfter = fillAfter;
            scaleAnimation.setFillAfter(fillAfter);
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
            scaleAnimation.setDuration(duration);
        }



    }
    public static class TranslateAnimation
    {   public static final int INFINITE=-1;
        public static final int RESTART=1;
        public static final int REVERSE=2;
        private View v;
        private int duration=500;
        private int repeatCount=0;
        private boolean fillAfter=false;
        private boolean fillBefore=false;
        private boolean fill=false;
        private int repeatMode=0;
        private Interpolator interpolator;
        android.view.animation.TranslateAnimation translateAnimation;
        public TranslateAnimation(View v)
        {
            this.v=v;
            translateAnimation=new android.view.animation.TranslateAnimation(0,100,0,0);
            interpolator=new AccelerateInterpolator();
        }
        public TranslateAnimation(View v,float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
        {
            this.v=v;
            translateAnimation=new android.view.animation.TranslateAnimation(fromXDelta,toXDelta,fromYDelta,toYDelta);
            interpolator=new AccelerateInterpolator();
        }
        public TranslateAnimation(View v,int fromXType, float fromXValue, int toXType, float toXValue,
                                  int fromYType, float fromYValue, int toYType, float toYValue)
        {
            this.v=v;
            translateAnimation=new android.view.animation.TranslateAnimation(fromXType,fromXValue,toXType,toXValue,fromYType,
                    fromYValue,toYType,toYValue);
            interpolator=new AccelerateInterpolator();
        }

        public int getRepeatMode() {
            return repeatMode;
        }

        public void setRepeatMode(int repeatMode) {
            this.repeatMode = repeatMode;
            translateAnimation.setRepeatMode(repeatMode);
        }

        public int getRepeatCount() {
            return repeatCount;
        }

        public void setRepeatCount(int repeatCount) {
            this.repeatCount = repeatCount;
            translateAnimation.setRepeatCount(repeatCount);
        }

        public void startAnimation()
        {
            v.startAnimation(translateAnimation);
        }
        public void startAnimation(int duration)
        {   translateAnimation.setDuration(duration);
            v.startAnimation(translateAnimation);
        }
        public void startAnimation(final ShortAnimationListener shortAnimationListener)
        {
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(translateAnimation);
        }
        public void startAnimation(int duration,final ShortAnimationListener shortAnimationListener)
        {   translateAnimation.setDuration(duration);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    shortAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    shortAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    shortAnimationListener.onAnimationRepeat(animation);
                }
            });
            v.startAnimation(translateAnimation);
        }
        public Interpolator getInterpolator() {
            return interpolator;
        }

        public void setInterpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            translateAnimation.setInterpolator(interpolator);
        }

        public void setInterpolator(Context context,int resId)
        {
            translateAnimation.setInterpolator(context, resId);
        }

        public boolean isFillBefore() {
            return fillBefore;
        }

        public void setFillBefore(boolean fillBefore) {
            this.fillBefore = fillBefore;
        }

        public boolean isFill() {
            return fill;
        }

        public void setFill(boolean fill) {
            this.fill = fill;
            translateAnimation.setFillEnabled(fill);
        }

        public boolean isFillAfter() {
            return fillAfter;
        }

        public void setFillAfter(boolean fillAfter) {
            this.fillAfter = fillAfter;
            translateAnimation.setFillAfter(fillAfter);
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
            translateAnimation.setDuration(duration);
        }



    }
    public interface ShortAnimationListener
    {
        void onAnimationStart(Animation animation);
        void onAnimationEnd(Animation animation);
        void onAnimationRepeat(Animation animation);
    }
}
