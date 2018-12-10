package dp.schoolandroid.service.repository.remotes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.widget.Toast;

import dp.schoolandroid.application.MyApp;
import dp.schoolandroid.di.component.NetworkComponent;
import dp.schoolandroid.service.model.request.TeacherRequest;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherResponse;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherLoginRepository {

    private static TeacherLoginRepository instance;

    private TeacherLoginRepository() {
    }

    public static TeacherLoginRepository getInstance() {
        if (instance == null) {
            instance = new TeacherLoginRepository();
        }
        return instance;
    }

    public LiveData<TeacherResponse> loginAsTeacher(final Application application, String phoneNumber, String password) {

        TeacherRequest teacherLoginRequest = getTeacherLoginRequest(phoneNumber, password);
        final MutableLiveData<TeacherResponse> data = new MutableLiveData<>();
        getApiInterfaces(application).loginAsTeacher("application/json",
                "application/json", teacherLoginRequest).enqueue(new Callback<TeacherResponse>() {
            @Override
            public void onResponse(Call<TeacherResponse> call, Response<TeacherResponse> response) {
                if (response.code() == 200) {
                    Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
                    data.setValue(response.body());
                    Toast.makeText(application, "Login :"+response.body().getTeacherData().getApiToken(), Toast.LENGTH_SHORT).show();
                    TeacherGetScheduleRepository.getInstance().setBearerToken("Bearer "+response.body().getTeacherData().getApiToken());
                    startNewActivity(application);
                }
            }

            @Override
            public void onFailure(Call<TeacherResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

    public TeacherRequest getTeacherLoginRequest(String phoneNumber, String password) {
        TeacherRequest teacherLoginRequest = new TeacherRequest();
        teacherLoginRequest.setPhone(phoneNumber);
        teacherLoginRequest.setPassword(password);
        return teacherLoginRequest;
    }

    public ApiInterfaces getApiInterfaces(Application application) {
        NetworkComponent daggerNetworkComponent = ((MyApp) application).getDaggerNetworkComponent();
        ApiInterfaces apiInterfaces = daggerNetworkComponent.getRetrofitApiInterfaces();
        return apiInterfaces;
    }

    public void startNewActivity(Application application) {
        Intent intent = new Intent(application, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent);
    }
}
