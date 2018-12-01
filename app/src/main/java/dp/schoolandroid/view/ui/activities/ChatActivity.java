package dp.schoolandroid.view.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Window;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityChatBinding;
import dp.schoolandroid.viewmodel.ChatActivityViewModel;

public class ChatActivity extends AppCompatActivity {

    ChatActivityViewModel viewModel;
    ActivityChatBinding binding;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_chat);
        viewModel=ViewModelProviders.of(this).get(ChatActivityViewModel.class);
        binding.setViewModel(viewModel);


        setUpAnimation();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }

}
