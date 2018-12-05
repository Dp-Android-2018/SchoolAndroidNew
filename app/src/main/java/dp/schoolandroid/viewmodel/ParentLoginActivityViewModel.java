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
import dp.schoolandroid.service.model.response.parentresponse.ParentResponse;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.service.repository.remotes.ParentLoginRepository;
import dp.schoolandroid.service.repository.remotes.StudentLoginRepository;

/**
 * Created by DELL on 28/11/2018.
 */

public class ParentLoginActivityViewModel extends AndroidViewModel {

    public ObservableField<String> phoneNumber;

    private LiveData<ParentResponse> parentLoginResponseLiveData = new MutableLiveData<>();
    private Application application;

    public ParentLoginActivityViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        initializeVariables();
    }

    public void initializeVariables() {
        phoneNumber = new ObservableField<>();
    }

    public void login(View view) {
        if (ValidationUtils.validateTexts(phoneNumber.get(), ValidationUtils.TYPE_PHONE)) {
            parentLoginResponseLiveData = ParentLoginRepository.getInstance().loginAsParent(application, phoneNumber.get());
//            Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "Error Phone Number", Toast.LENGTH_SHORT).show();
        }
    }

}
