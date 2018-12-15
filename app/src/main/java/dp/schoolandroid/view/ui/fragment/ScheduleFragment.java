package dp.schoolandroid.view.ui.fragment;

import android.app.ActivityOptions;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.FragmentDayBinding;
import dp.schoolandroid.databinding.FragmentScheduleBinding;
import dp.schoolandroid.global.TeacherSchedule;
import dp.schoolandroid.service.model.response.teacherresponse.TeacherScheduleResponse;
import dp.schoolandroid.view.ui.activity.ChatActivity;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import dp.schoolandroid.view.ui.adapter.DayRecyclerViewAdapter;
import dp.schoolandroid.view.ui.adapter.TeacherSchedulePageViewAdapter;
import dp.schoolandroid.viewmodel.DayFragmentViewModel;
import dp.schoolandroid.viewmodel.MyCustomBarViewModel;
import dp.schoolandroid.viewmodel.ScheduleFragmentViewModel;


public class ScheduleFragment extends Fragment {


    FragmentScheduleBinding binding;
    private  TeacherSchedulePageViewAdapter pageViewAdapter;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    public static ScheduleFragment newInstance() {
        ScheduleFragment fragment = new ScheduleFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schedule, container, false);
        initUi();

        return binding.getRoot();
    }

    private void initUi() {
        binding.actionBar.setViewModel(new MyCustomBarViewModel(getContext()));
        binding.actionBar.tvActionBarTitle.setText("Schedule");
        binding.actionBar.chatMenuImage.setVisibility(View.GONE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ScheduleFragmentViewModel viewModel = ViewModelProviders.of(this).get(ScheduleFragmentViewModel.class);
        observeViewModel(viewModel);
    }

    private void observeViewModel(ScheduleFragmentViewModel viewModel) {
        viewModel.getData().observe(this, new Observer<TeacherScheduleResponse>() {
            @Override
            public void onChanged(@Nullable TeacherScheduleResponse teacherScheduleResponse) {
                Toast.makeText(getContext(), "data changed", Toast.LENGTH_SHORT).show();
                if (teacherScheduleResponse != null) {
                    Toast.makeText(getContext(), "Thursday" + teacherScheduleResponse.getData().getThu().get(0).getClassName(), Toast.LENGTH_SHORT).show();
                    TeacherSchedule weekData = teacherScheduleResponse.getData();
                    initializeViewPager(weekData);
                   // DayRecyclerViewAdapter.weekData = teacherScheduleResponse.getData();
                    Toast.makeText(getContext(), "size :" + teacherScheduleResponse.getData().getThu().size(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void initializeViewPager(TeacherSchedule weekData){
        ViewPager viewPager = binding.viewpagerSchedule;
        viewPager.setOffscreenPageLimit(1);
        pageViewAdapter = new TeacherSchedulePageViewAdapter(getFragmentManager() , weekData);
        viewPager.setAdapter(pageViewAdapter);
        TabLayout tabLayout = binding.tlScheduleClass;
        tabLayout.setupWithViewPager(viewPager);
    }
}
