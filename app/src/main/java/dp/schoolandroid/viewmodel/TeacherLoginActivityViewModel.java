package dp.schoolandroid.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Toast;

import dp.schoolandroid.Utility.utils.ConfigurationFile;
import dp.schoolandroid.Utility.utils.ValidationUtils;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.service.repository.remotes.TeacherLoginRepository;
import dp.schoolandroid.view.ui.activity.StudentLoginActivity;
import dp.schoolandroid.view.ui.activity.TopStudentDetailsActivity;
import dp.schoolandroid.view.ui.callback.CallBackInterface;

public class TeacherLoginActivityViewModel extends AndroidViewModel {

    public ObservableField<String> phoneNumber;
    public ObservableField<String> password;

    private LiveData<TeacherResponse> teacherLoginResponseLiveData = new MutableLiveData<>();
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
        if (ValidationUtils.validateTexts(phoneNumber.get(), ValidationUtils.TYPE_PHONE)
                && ValidationUtils.validateTexts(password.get(), ValidationUtils.TYPE_PASSWORD)) {
            teacherLoginResponseLiveData = TeacherLoginRepository.getInstance().loginAsTeacher(application, phoneNumber.get(), password.get());
//            Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "Error Phone or Password", Toast.LENGTH_SHORT).show();
        }

    }

    public LiveData<TeacherResponse> getTeacherLoginResponseLiveData() {
        return teacherLoginResponseLiveData;
    }
}
