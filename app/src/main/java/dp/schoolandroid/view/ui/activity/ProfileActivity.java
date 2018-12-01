package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityProfileBinding;
import dp.schoolandroid.viewmodel.ProfileActivityViewModel;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    ProfileActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_profile);
        viewModel=ViewModelProviders.of(this).get(ProfileActivityViewModel.class);
        binding.setViewModel(viewModel);
    }
}
