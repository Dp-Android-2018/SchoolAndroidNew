package dp.schoolandroid.service.repository.remotes;

import android.annotation.SuppressLint;
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
import dp.schoolandroid.view.ui.activity.TeacherLoginActivity;
import dp.schoolandroid.view.ui.callback.CallBackInterface;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class TeacherLoginRepository {

    private static TeacherLoginRepository instance;

    private TeacherLoginRepository(){}

    public static TeacherLoginRepository getInstance() {
        if (instance == null) {
            instance = new TeacherLoginRepository();
        }
        return instance;
    }


    @SuppressLint("CheckResult")
    public LiveData<TeacherResponse> loginAsTeacher(final Application application, String phoneNumber, String password) {
        final MutableLiveData<TeacherResponse> data = new MutableLiveData<>();
        TeacherRequest teacherLoginRequest = getTeacherLoginRequest(phoneNumber, password);
        getApiInterfaces(application).loginAsTeacher("application/json", "application/json", teacherLoginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<TeacherResponse>>() {
                    @Override
                    public void accept(Response<TeacherResponse> teacherLoginResponseResponse) throws Exception {
                        if (teacherLoginResponseResponse.code()== 200){
                            Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
                            data.setValue(teacherLoginResponseResponse.body());
                            startNewActivity(application);
                        }else {
                            Toast.makeText(application, "Login Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
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
    public void startNewActivity(Application application){
        Intent intent=new Intent(application,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        application.startActivity(intent);
    }
}
