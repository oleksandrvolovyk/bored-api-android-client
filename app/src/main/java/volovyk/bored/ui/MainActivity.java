package volovyk.bored.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import volovyk.bored.R;
import volovyk.bored.data.Task;

@AndroidEntryPoint
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

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.task.observe(this, this::displayTask);

        refreshButton.setOnClickListener(this);
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
