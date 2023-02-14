package volovyk.bored.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import volovyk.bored.data.Task;
import volovyk.bored.data.TaskRepository;
import volovyk.bored.data.local.JSONTaskRepository;

public class MainViewModel extends ViewModel {

    private final MutableLiveData<Task> currentTask = new MutableLiveData<>();
    public LiveData<Task> task = currentTask;

    private TaskRepository taskRepository = new JSONTaskRepository(); // TODO: DI

    public void onRefreshButtonClick() {
        currentTask.setValue(taskRepository.getRandomTask());
    }

    public MainViewModel() {
        onRefreshButtonClick();
    }
}
