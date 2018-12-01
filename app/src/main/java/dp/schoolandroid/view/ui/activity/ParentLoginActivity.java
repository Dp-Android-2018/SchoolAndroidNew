package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityParentLoginBinding;
import dp.schoolandroid.viewmodel.ParentLoginViewModel;

public class ParentLoginActivity extends AppCompatActivity {

    Button btn_check;
    TextView signIn_textView;
    EditText teacher_phone_text;
    ParentLoginViewModel viewModel;
    ActivityParentLoginBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        viewModel= ViewModelProviders.of(this).get(ParentLoginViewModel.class);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_parent_login);
        binding.setViewModel(viewModel);

        setUpAnimation();

        btn_check = (Button) findViewById(R.id.btn_parent_check);
        signIn_textView = (TextView) findViewById(R.id.signIn_textView);
        teacher_phone_text = (EditText) findViewById(R.id.teacher_phone_text);

        checkButton();
    }

    private void checkButton() {
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn_textView.setText(R.string.msg_have_sms);
                teacher_phone_text.setHint(R.string.password);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }
}
