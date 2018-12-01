package dp.schoolandroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;

import dp.schoolandroid.service.model.response.TeacherLoginResponse;
import dp.schoolandroid.service.repository.remotes.TeacherLoginRepository;

public class TeacherLoginActivityViewModel extends AndroidViewModel {

    public ObservableField<String> phoneNumber;
    public ObservableField<String> password;
    private LiveData<TeacherLoginResponse> teacherLoginResponseLiveData = new MutableLiveData<>();
    private Application application;

    public TeacherLoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        initializeVariables();

    }

    public void initializeVariables() {
        phoneNumber = new ObservableField<>();
        password = new ObservableField<>();
    }

    public void login(View view) {
        System.out.println("Teacher Clicked");
        teacherLoginResponseLiveData = TeacherLoginRepository.getInstance().loginAsTeacher(application, phoneNumber.get(), password.get());
    }

    public LiveData<TeacherLoginResponse> getTeacherLoginResponseLiveData() {
        return teacherLoginResponseLiveData;
    }
}
