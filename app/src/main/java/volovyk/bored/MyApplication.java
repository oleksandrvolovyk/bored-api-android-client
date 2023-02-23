package volovyk.bored;

import android.app.Application;
import android.content.res.Resources;

public class MyApplication extends Application {

    private static Resources resources;

    @Override
    public void onCreate() {
        super.onCreate();
        resources = getApplicationContext().getResources();
    }

    public static Resources getAppResources(){
        return resources;
    }
}
