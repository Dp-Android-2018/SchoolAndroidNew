package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityTeacherLoginBinding;
import dp.schoolandroid.service.model.response.TeacherLoginResponse;
import dp.schoolandroid.viewmodel.TeacherLoginActivityViewModel;

public class TeacherLoginActivity extends AppCompatActivity {


    ActivityTeacherLoginBinding binding;
    ImageView view_done;
    Button btn_check;
    TeacherLoginActivityViewModel viewModel;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_login);
        initViewModel();
        setUpAnimation();
        initUi();
        ObserverViewModel(viewModel);
    }

    public void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(TeacherLoginActivityViewModel.class);
        binding.setViewModel(viewModel);
    }

    public void initUi() {
        btn_check = (Button) findViewById(R.id.btn_teacher_login);
        view_done = (ImageView) findViewById(R.id.view_done);
        checkButton();
    }

    private void checkButton() {
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_check.setVisibility(View.INVISIBLE);
                view_done.setVisibility(View.VISIBLE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }

    public void ObserverViewModel(TeacherLoginActivityViewModel viewModel) {
        if (viewModel !=null) {
            viewModel.getTeacherLoginResponseLiveData().observe(this, new Observer<TeacherLoginResponse>() {
                @Override
                public void onChanged(@Nullable TeacherLoginResponse teacherLoginResponse) {
                    if (teacherLoginResponse != null) {
                        System.out.println("Teacher Data :" + new Gson().toJson(teacherLoginResponse));
                    }
                }
            });
        }else {
            Toast.makeText(this,"Null Value ",Toast.LENGTH_LONG).show();
        }
    }

}
