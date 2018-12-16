package dp.schoolandroid.view.ui.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import dp.schoolandroid.R;
import dp.schoolandroid.view.ui.activity.ChatActivity;
import dp.schoolandroid.view.ui.activity.HomeActivity;


public class BaseFragment extends Fragment {

    ActivityOptions options;
    ImageView action_menu;
    ImageView chat_menu;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
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
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        action_menu=(ImageView)getView().findViewById(R.id.action_menu_image);
        action_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.drawer.openDrawer(GravityCompat.START);
            }
        });
        chat_menu=(ImageView)getView().findViewById(R.id.chat_menu_image);
        chat_menu.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                options = ActivityOptions.makeSceneTransitionAnimation(getActivity());
                Intent intent=new Intent(getActivity(),ChatActivity.class);
                startActivity(intent ,options.toBundle());
            }
        });
//        setUpRecyclerView(view);
        super.onViewCreated(view, savedInstanceState);
    }

    /*private void setUpRecyclerView(View view) {
        RecyclerView recyclerView=view.findViewById(R.id.base_day_recycler_view);
        DayRecyclerViewAdapter dayRecyclerViewAdapter=new DayRecyclerViewAdapter(getContext(),getDummyData());
        recyclerView.setAdapter(dayRecyclerViewAdapter);

        LinearLayoutManager mLinearLayoutManager=new LinearLayoutManager(getContext());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);
    }

    private ArrayList<SectionTimeModel> getDummyData() {
        ArrayList<SectionTimeModel> dummyData=new ArrayList<>();

        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));
        dummyData.add(new SectionTimeModel("Java1","Mosaid1","20","9:15 Am","11:15 Am"));

        return dummyData;
    }*/
}
