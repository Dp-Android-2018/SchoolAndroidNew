package dp.schoolandroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import dp.schoolandroid.Utility.utils.ValidationUtils;
import dp.schoolandroid.service.model.response.studentresponse.StudentResponse;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.service.repository.remotes.StudentLoginRepository;

public class StudentLoginActivityViewModel extends AndroidViewModel {
    public ObservableField<String> ssn;
    public ObservableField<String> password;
    private LiveData<StudentResponse> studentLoginResponseLiveData = new MutableLiveData<>();
    private Application application;

    public StudentLoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        initializeVariables();
    }

    public void initializeVariables() {
        ssn = new ObservableField<>();
        password = new ObservableField<>();
    }

    public void login(View view) {
        if (ValidationUtils.validateTexts(ssn.get(), ValidationUtils.TYPE_TEXT)
                && ValidationUtils.validateTexts(password.get(), ValidationUtils.TYPE_PASSWORD)) {
            studentLoginResponseLiveData =StudentLoginRepository.getInstance().loginAsStudent(application,ssn.get(),password.get());
//            Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "Error SSN or Password", Toast.LENGTH_SHORT).show();
        }
    }

    public LiveData<StudentResponse> getStudentLoginResponseLiveData() {
        return studentLoginResponseLiveData;
    }

}
