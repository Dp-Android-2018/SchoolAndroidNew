package dp.schoolandroid.service.repository.remotes;

import android.annotation.SuppressLint;
import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.widget.Toast;

import dp.schoolandroid.application.MyApp;
import dp.schoolandroid.di.component.NetworkComponent;
import dp.schoolandroid.service.model.request.ParentRequest;
import dp.schoolandroid.service.model.request.StudentRequest;
import dp.schoolandroid.service.model.response.parentresponse.ParentResponse;
import dp.schoolandroid.service.model.response.studentresponse.StudentResponse;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ParentLoginRepository {
    private static ParentLoginRepository instance;

    private ParentLoginRepository(){}

    public static ParentLoginRepository getInstance() {
        if (instance == null) {
            instance = new ParentLoginRepository();
        }
        return instance;
    }
    @SuppressLint("CheckResult")
    public LiveData<ParentResponse> loginAsParent(final Application application, String phone) {
        final MutableLiveData<ParentResponse> data = new MutableLiveData<>();
        ParentRequest parentLoginRequest = getParenttLoginRequest(phone);
        getApiInterfaces(application).loginAsParent("application/json", "application/json", parentLoginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<ParentResponse>>() {
                    @Override
                    public void accept(Response<ParentResponse> parentLoginResponseResponse) throws Exception {
                        if (parentLoginResponseResponse.code()== 200){
                            Toast.makeText(application, "Login Success", Toast.LENGTH_SHORT).show();
                            data.setValue(parentLoginResponseResponse.body());
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

    public ParentRequest getParenttLoginRequest(String phone) {
        ParentRequest parenttLoginRequest = new ParentRequest();
        parenttLoginRequest.setPhone(phone);
        return parenttLoginRequest;
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
