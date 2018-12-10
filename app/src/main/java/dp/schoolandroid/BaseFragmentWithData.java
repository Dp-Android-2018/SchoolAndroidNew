package dp.schoolandroid;

import android.app.ActivityOptions;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import dp.schoolandroid.databinding.FragmentBaseWithDataBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.view.ui.activity.ChatActivity;
import dp.schoolandroid.view.ui.activity.HomeActivity;
import dp.schoolandroid.view.ui.adapter.ClassRecyclerViewAdapter;
import dp.schoolandroid.view.ui.adapter.DayRecyclerViewAdapter;
import dp.schoolandroid.view.ui.fragment.ScheduleFragment;
import dp.schoolandroid.viewmodel.BaseFragmentWithDataViewModel;
import dp.schoolandroid.viewmodel.DayFragmentViewModel;
import dp.schoolandroid.viewmodel.MyCustomBarViewModel;


public class BaseFragmentWithData extends Fragment {
    FragmentBaseWithDataBinding binding;
    ActivityOptions options;
    ImageView action_menu;
    ImageView chat_menu;
    ArrayList<SectionTimeModel> data;
    ClassRecyclerViewAdapter classRecyclerViewAdapter;

    public static BaseFragmentWithData newInstance() {
        BaseFragmentWithData fragment = new BaseFragmentWithData();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_base_with_data,container,false);
        binding.dayActionBar.setViewModel(new MyCustomBarViewModel(getContext()));
        classRecyclerViewAdapter = new ClassRecyclerViewAdapter();
        binding.baseClassRecyclerView.setAdapter(classRecyclerViewAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

//        setUpRecyclerView(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final BaseFragmentWithDataViewModel viewModel = ViewModelProviders.of(this).get(BaseFragmentWithDataViewModel.class);
    }
}
