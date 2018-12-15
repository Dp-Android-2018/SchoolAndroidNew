package dp.schoolandroid.service.repository.remotes;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.widget.Toast;

import dp.schoolandroid.application.MyApp;
import dp.schoolandroid.di.component.NetworkComponent;
import dp.schoolandroid.service.model.request.StudentRequest;
import dp.schoolandroid.service.model.request.TeacherRequest;
import dp.schoolandroid.service.model.response.studentresponse.StudentResponse;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import dp.schoolandroid.view.ui.callback.CallBackInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentLoginRepository {
    private static StudentLoginRepository instance;

    private StudentLoginRepository(){}
    public static StudentLoginRepository getInstance() {
        if (instance == null) {
            instance = new StudentLoginRepository();
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public LiveData<StudentResponse> loginAsStudent(final Application application, String ssn, String password) {
        final MutableLiveData<StudentResponse> data = new MutableLiveData<>();
        StudentRequest studentLoginRequest = getStudentLoginRequest(ssn, password);
        getApiInterfaces(application).loginAsStudent("application/json",
                "application/json", studentLoginRequest).enqueue(new Callback<StudentResponse>() {
            @Override
            public void onResponse(Call<StudentResponse> call, Response<StudentResponse> response) {
                if (response.code()== 200){
                    Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
                    data.setValue(response.body());
                    startNewActivity(application);
                }else {
                    Toast.makeText(application, "Login code :"+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StudentResponse> call, Throwable t) {
                Toast.makeText(application, "Login code :"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }

    public StudentRequest getStudentLoginRequest(String ssn, String password) {
        StudentRequest studentLoginRequest = new StudentRequest();
        studentLoginRequest.setSsn(ssn);
        studentLoginRequest.setPassword(password);
        return studentLoginRequest;
    }

    public ApiInterfaces getApiInterfaces(Application application) {
        NetworkComponent daggerNetworkComponent = ((MyApp) application).getDaggerNetworkComponent();
        ApiInterfaces apiInterfaces = daggerNetworkComponent.getRetrofitApiInterfaces();
        return apiInterfaces;
    }

    public void startNewActivity(Application application){
        Intent intent=new Intent(application,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent);
    }
}
