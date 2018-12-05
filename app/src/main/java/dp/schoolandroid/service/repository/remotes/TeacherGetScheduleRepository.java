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
import dp.schoolandroid.service.model.response.teacherresponse.TeacherScheduleResponse;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class TeacherGetScheduleRepository {

    private static TeacherGetScheduleRepository instance;

    private TeacherGetScheduleRepository(){}

    public static TeacherGetScheduleRepository getInstance() {
        if (instance == null) {
            instance = new TeacherGetScheduleRepository();
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public LiveData<TeacherScheduleResponse> getTeacherSchedule(final Application application,String bearerToken) {
        final MutableLiveData<TeacherScheduleResponse> data = new MutableLiveData<>();
        getApiInterfaces(application).getTeacherSchedule(bearerToken,"application/json", "application/json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<TeacherScheduleResponse>>() {
                    @Override
                    public void accept(Response<TeacherScheduleResponse> teacherScheduleResponseResponse) throws Exception {
                        if (teacherScheduleResponseResponse.code()== 200){
                            Toast.makeText(application, "Schedule Request Success", Toast.LENGTH_SHORT).show();
                            data.setValue(teacherScheduleResponseResponse.body());
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

    public ApiInterfaces getApiInterfaces(Application application) {
        NetworkComponent daggerNetworkComponent = ((MyApp) application).getDaggerNetworkComponent();
        ApiInterfaces apiInterfaces = daggerNetworkComponent.getRetrofitApiInterfaces();
        return apiInterfaces;
    }

}
