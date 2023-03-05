package volovyk.bored.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import volovyk.bored.data.local.JSONTaskDatabase;

@Singleton
public class JSONTaskRepository implements TaskRepository {

    private final JSONTaskDatabase database;

    @Inject
    public JSONTaskRepository(JSONTaskDatabase database) {
        this.database = database;
    }

    @Override
    public Task getRandomTask() {
        return database.getRandomTask();
    }
}