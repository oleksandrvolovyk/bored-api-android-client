package volovyk.bored.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import volovyk.bored.data.Task;
import volovyk.bored.data.TaskRepository;
import volovyk.bored.data.local.JSONTaskRepository;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final MutableLiveData<Task> currentTask = new MutableLiveData<>();
    public LiveData<Task> task = currentTask;

    private final TaskRepository taskRepository;

    public void onRefreshButtonClick() {
        currentTask.setValue(taskRepository.getRandomTask());
    }

    @Inject
    public MainViewModel(JSONTaskRepository jsonTaskRepository) {
        this.taskRepository = jsonTaskRepository;
        onRefreshButtonClick();
    }
}
