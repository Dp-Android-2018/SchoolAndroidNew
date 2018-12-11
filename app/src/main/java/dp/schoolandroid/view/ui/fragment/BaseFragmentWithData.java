package dp.schoolandroid.view.ui.fragment;

import android.app.ActivityOptions;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import dp.schoolandroid.R;
import dp.schoolandroid.databinding.FragmentBaseWithDataBinding;
import dp.schoolandroid.global.SectionTimeModel;
import dp.schoolandroid.view.ui.adapter.ClassRecyclerViewAdapter;
import dp.schoolandroid.viewmodel.BaseFragmentWithDataViewModel;
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
        binding.dayActionBar.tvActionBarTitle.setVisibility(View.GONE);
        binding.dayActionBar.chatMenuImage.setVisibility(View.GONE);
        classRecyclerViewAdapter = new ClassRecyclerViewAdapter();
        binding.baseClassRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayout.VERTICAL,false));
        binding.baseClassRecyclerView.setAdapter(classRecyclerViewAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final BaseFragmentWithDataViewModel viewModel = ViewModelProviders.of(this).get(BaseFragmentWithDataViewModel.class);
    }
}
