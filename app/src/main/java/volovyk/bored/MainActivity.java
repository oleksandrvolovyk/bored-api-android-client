package volovyk.bored;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TaskDatabase taskDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        try {
            taskDatabase = new JSONTaskDatabase(getResources().openRawResource(R.raw.activities));
            showRandomTask();
        } catch (JSONException | IOException e) {
            makeToast(getString(R.string.error));
        }
    }

    private void makeToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        try {
            showRandomTask();
        } catch (JSONException e) {
            makeToast(getString(R.string.error));
        }
    }

    private void displayTask(Task task) {
        final TextView activityNameTextView = findViewById(R.id.activityNameTextView);
        final TextView activityTypeTextView = findViewById(R.id.activityTypeTextView);
        final ProgressBar progressbar = findViewById(R.id.availabilityProgressBar);

        activityNameTextView.setText(task.getName());
        activityTypeTextView.setText(String.format(getString(R.string.type_caption), task.getType()));
        progressbar.setProgress(task.getAvailability());
    }

    private void showRandomTask() throws JSONException {
        Task randomTask = taskDatabase.getRandomTask();
        displayTask(randomTask);
    }
}
