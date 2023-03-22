package volovyk.bored.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import volovyk.bored.R;
import volovyk.bored.data.Task;
import volovyk.bored.databinding.ActivityMainBinding;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel mainViewModel;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.task.observe(this, this::displayTask);

        binding.refreshButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mainViewModel.onRefreshButtonClick();
    }

    private void displayTask(Task task) {
        binding.activityNameTextView.setText(task.getName());
        binding.activityTypeTextView.setText(String.format(getString(R.string.type_caption), task.getType()));
        binding.availabilityProgressBar.setProgress(task.getAvailability());
    }
}
