package volovyk.bored;

import android.app.Application;

import java.io.InputStream;

public class MyApplication extends Application {

    private static InputStream activitiesInputStream;

    @Override
    public void onCreate() {
        super.onCreate();
        activitiesInputStream = getApplicationContext().getResources().openRawResource(R.raw.activities);
    }

    public static InputStream getMyInputStream(){
        return activitiesInputStream;
    }
}
