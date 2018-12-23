package dp.schoolandroid.view.ui.activity;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import dp.schoolandroid.R;
import dp.schoolandroid.Utility.utils.ConfigurationFile;
import dp.schoolandroid.Utility.utils.SetupAnimation;
import dp.schoolandroid.Utility.utils.ValidationUtils;
import dp.schoolandroid.databinding.ActivityParentLoginBinding;
import dp.schoolandroid.service.model.response.ForgetPasswordResponse;
import dp.schoolandroid.service.model.response.parentresponse.ParentResponse;
import dp.schoolandroid.viewmodel.ParentLoginActivityViewModel;
import retrofit2.Response;

public class ParentLoginActivity extends AppCompatActivity {
    ParentLoginActivityViewModel viewModel;
    ActivityParentLoginBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        initializeUi();
        SetupAnimation.getInstance().setUpAnimation(getWindow(), getResources());
    }

    private void initializeUi() {
        viewModel = ViewModelProviders.of(this).get(ParentLoginActivityViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent_login);
        binding.setViewModel(viewModel);
    }

    public void parentLogin(View view) {
        if (ValidationUtils.validateTexts(binding.parentPhoneEditText.getText().toString(), ValidationUtils.TYPE_PHONE)
                && ValidationUtils.validateTexts(binding.parentPasswordEditText.getText().toString(), ValidationUtils.TYPE_PASSWORD)) {
            viewModel.handleloginParent();
            observeParentLoginDataViewModel(viewModel);
        } else {
            Toast.makeText(this, "Error Phone or Password", Toast.LENGTH_SHORT).show();
        }
    }

    private void observeParentLoginDataViewModel(ParentLoginActivityViewModel viewModel) {
        viewModel.getParentLoginResponseLiveData().observe(this, new Observer<Response<ParentResponse>>() {
            @Override
            public void onChanged(@Nullable Response<ParentResponse> parentResponseResponse) {
                if (parentResponseResponse != null) {
                    if (parentResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                        moveToHomeActivity();
                    }
                }
        }});
    }

    private void moveToHomeActivity(){
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }


    public void forgetPasswordParentValidation(View view) {
        if (ValidationUtils.validateTexts(binding.parentPhoneEditText.getText().toString(), ValidationUtils.TYPE_PHONE)) {
            viewModel.handleForgetPasswordParent();
            ObserverParentForgetPasswordViewModel(viewModel);
        } else {
            Toast.makeText(this, "Error Phone number", Toast.LENGTH_SHORT).show();
        }
    }

    private void ObserverParentForgetPasswordViewModel(ParentLoginActivityViewModel viewModel) {
        viewModel.getForgetPasswordResponseLiveData().observe(this, new Observer<Response<ForgetPasswordResponse>>() {
            @Override
            public void onChanged(@Nullable Response<ForgetPasswordResponse> forgetPasswordResponseResponse) {
                if (forgetPasswordResponseResponse != null) {
                    if (forgetPasswordResponseResponse.code() == ConfigurationFile.Constants.SUCCESS_CODE) {
                        moveToPasswordActivity();
                    } else {
                        Toast.makeText(ParentLoginActivity.this, "Please wait :)", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void moveToPasswordActivity() {
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        intent.putExtra(ConfigurationFile.Constants.ACTIVITY_NUMBER, ConfigurationFile.Constants.PARENT_ACTIVITY_CODE);
        intent.putExtra(ConfigurationFile.Constants.PARENT_PHONE_NUMBER, binding.parentPhoneEditText.getText().toString());
        startActivity(intent);
    }
}
