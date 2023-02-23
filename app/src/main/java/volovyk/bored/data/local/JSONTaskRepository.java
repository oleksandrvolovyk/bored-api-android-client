package volovyk.bored.data.local;


import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;
import volovyk.bored.R;
import volovyk.bored.data.Task;
import volovyk.bored.data.TaskRepository;

@Singleton
public class JSONTaskRepository implements TaskRepository {

    List<Task> tasks;

    @Inject
    public JSONTaskRepository(@ApplicationContext Context appContext) {
        try {
            this.tasks = loadJSONFromAsset(appContext.getResources().openRawResource(R.raw.activities));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Task> loadJSONFromAsset(InputStream rawResource) throws IOException {
        String json;

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        for (int length; (length = rawResource.read(buffer)) != -1; ) {
            result.write(buffer, 0, length);
        }

        json = result.toString("UTF-8");

        Gson gson = new Gson();

        return gson.fromJson(json, new TypeToken<List<Task>>() {
        }.getType());
    }


    @Override
    public Task getRandomTask() {
        final Random random = new Random();
        return tasks.get(random.nextInt(tasks.size()));
    }

}
