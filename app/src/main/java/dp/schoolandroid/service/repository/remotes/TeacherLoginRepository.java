package dp.schoolandroid.service.repository.remotes;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import dp.schoolandroid.application.MyApp;
import dp.schoolandroid.di.component.NetworkComponent;
import dp.schoolandroid.service.model.request.TeacherLoginRequest;
import dp.schoolandroid.service.model.response.TeacherLoginResponse;
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

    public LiveData<TeacherLoginResponse> loginAsTeacher(Application application, String phoneNumber, String password) {
        final MutableLiveData<TeacherLoginResponse> data = new MutableLiveData<>();
        TeacherLoginRequest teacherLoginRequest = getTeacherLoginRequest(phoneNumber, password);
        getApiInterfaces(application).loginAsTeacher("application/json", "application/json", teacherLoginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<TeacherLoginResponse>>() {
                    @Override
                    public void accept(Response<TeacherLoginResponse> teacherLoginResponseResponse) throws Exception {
                        data.setValue(teacherLoginResponseResponse.body());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        data.setValue(null);
                    }
                });
        return data;
    }

    public TeacherLoginRequest getTeacherLoginRequest(String phoneNumber, String password) {
        TeacherLoginRequest teacherLoginRequest = new TeacherLoginRequest();
        teacherLoginRequest.setPhone(phoneNumber);
        teacherLoginRequest.setPassword(password);
        return teacherLoginRequest;
    }

    public ApiInterfaces getApiInterfaces(Application application) {
        NetworkComponent daggerNetworkComponent = ((MyApp) application).getDaggerNetworkComponent();
        ApiInterfaces apiInterfaces = daggerNetworkComponent.getRetrofitApiInterfaces();
        return apiInterfaces;
    }
}
