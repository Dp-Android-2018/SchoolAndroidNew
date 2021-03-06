package dp.schoolandroid.service.repository.remotes;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.widget.Toast;

import dp.schoolandroid.application.MyApp;
import dp.schoolandroid.di.component.NetworkComponent;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherScheduleResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherGetScheduleRepository {

    private static TeacherGetScheduleRepository instance;
    private String bearerToken;
    private TeacherGetScheduleRepository(){}

    public static TeacherGetScheduleRepository getInstance() {
        if (instance == null) {
            instance = new TeacherGetScheduleRepository();
        }
        return instance;
    }

    @SuppressLint("CheckResult")
    public LiveData<TeacherScheduleResponse> getTeacherSchedule(final Application application) {
        final MutableLiveData<TeacherScheduleResponse> data = new MutableLiveData<>();
        getApiInterfaces(application).getTeacherSchedule(bearerToken,
                "application/json", "application/json").enqueue(new Callback<TeacherScheduleResponse>() {
            @Override
            public void onResponse(Call<TeacherScheduleResponse> call, Response<TeacherScheduleResponse> response) {
                if (response.code()== 200){
//                    Toast.makeText(application, "Schedule Request Success", Toast.LENGTH_SHORT).show();
//                    dayRecyclerViewAdapter.setDayData(response.body().getData().getThu());
//                    Toast.makeText(application, "Thursday"+response.body().getData().getThu().get(0).getClassName(), Toast.LENGTH_SHORT).show();
//                    classRecyclerViewAdapter.setDayData(response.body().getData().getSat());
                    data.setValue(response.body());
                }else {
                    Toast.makeText(application, "Login code: "+response.code(), Toast.LENGTH_SHORT).show();
//                    dayRecyclerViewAdapter.setDayData(getDummyData());
                }
            }

            @Override
            public void onFailure(Call<TeacherScheduleResponse> call, Throwable t) {
                Toast.makeText(application, "Login code: "+t.getMessage(), Toast.LENGTH_SHORT).show();
//                dayRecyclerViewAdapter.setDayData(getDummyData());
            }
        });
        return data;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public ApiInterfaces getApiInterfaces(Application application) {
        NetworkComponent daggerNetworkComponent = ((MyApp) application).getDaggerNetworkComponent();
        ApiInterfaces apiInterfaces = daggerNetworkComponent.getRetrofitApiInterfaces();
        return apiInterfaces;
    }

}
