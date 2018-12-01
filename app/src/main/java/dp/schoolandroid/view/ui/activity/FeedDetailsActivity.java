package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.ActivityFeedDetailsBinding;
import dp.schoolandroid.viewmodel.FeedDetailsActivityViewModel;

public class FeedDetailsActivity extends AppCompatActivity {

    FeedDetailsActivityViewModel viewModel;
    ActivityFeedDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_feed_details);
        viewModel=ViewModelProviders.of(this).get(FeedDetailsActivityViewModel.class);
        binding.setViewModel(viewModel);
    }
}
