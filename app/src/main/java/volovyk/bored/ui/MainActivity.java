package volovyk.bored.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import volovyk.bored.R;
import volovyk.bored.data.Task;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;
    private Button refreshButton;
    private TextView activityNameTextView;
    private TextView activityTypeTextView;
    private ProgressBar availabilityProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshButton = findViewById(R.id.button);
        activityNameTextView = findViewById(R.id.activityNameTextView);
        activityTypeTextView = findViewById(R.id.activityTypeTextView);
        availabilityProgressBar = findViewById(R.id.availabilityProgressBar);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class); // TODO: DI

        mainViewModel.task.observe(this, this::displayTask);

        refreshButton.setOnClickListener(this);
    }

    private void makeToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        mainViewModel.onRefreshButtonClick();
    }

    private void displayTask(Task task) {
        activityNameTextView.setText(task.getName());
        activityTypeTextView.setText(String.format(getString(R.string.type_caption), task.getType()));
        availabilityProgressBar.setProgress(task.getAvailability());
    }
}