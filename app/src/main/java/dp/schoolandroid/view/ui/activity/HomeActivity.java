package dp.schoolandroid.view.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import dp.schoolandroid.databinding.ActivityHomeBinding;
import dp.schoolandroid.view.ui.fragments.BaseFragment;
import dp.schoolandroid.view.ui.fragments.ContactUsFragment;
import dp.schoolandroid.view.ui.fragments.FeedsFragment;
import dp.schoolandroid.R;
import dp.schoolandroid.view.ui.fragments.ScheduleFragment;
import dp.schoolandroid.view.ui.fragments.SuggestionFragment;
import dp.schoolandroid.view.ui.fragments.TopStudentFragment;
import dp.schoolandroid.viewmodel.HomeActivityViewModel;

public class HomeActivity extends AppCompatActivity {

    HomeActivityViewModel viewModel;
    ActivityHomeBinding binding;
    public static DrawerLayout drawer;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_home);
        viewModel=ViewModelProviders.of(this).get(HomeActivityViewModel.class);
        binding.setViewModel(viewModel);

        setUpAnimation();
        setNavigationDrawer();
        setBottonNavigationView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setUpAnimation(){
        Explode enterTransition = new Explode();
        enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        getWindow().setEnterTransition(enterTransition);
    }

    public void setNavigationDrawer() {
        drawer = (DrawerLayout) findViewById(R.id.main_activity);
        t = new ActionBarDrawerToggle(this, drawer, R.string.Open, R.string.Close);
        drawer.addDrawerListener(t);
        t.syncState();

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.menu_edit_profile:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_edit_profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_message:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_message", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_about_us:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_about_us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_picture_gallery:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_picture_gallery", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_suggestions:
                        selectedFragment= SuggestionFragment.newInstance();
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_suggestions", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_contact_us:
                        selectedFragment= ContactUsFragment.newInstance();
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_contact_us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_logOut:
                        drawer.closeDrawer(GravityCompat.START);
                        Toast.makeText(HomeActivity.this, "menu_logOut", Toast.LENGTH_SHORT).show();
                        break;
                }
                if (selectedFragment !=null){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                }
                return true;
            }
        });
    }
    private void configureToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setHomeAsUpIndicator(R.drawable.ic_action_menu);
        actionbar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setBottonNavigationView() {
        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                item.setIcon(R.drawable.ic_home_on);
                                selectedFragment = BaseFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                item.setIcon(R.drawable.ic_calender_on);
                                selectedFragment = ScheduleFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                item.setIcon(R.drawable.ic_student_on);
                                selectedFragment = TopStudentFragment.newInstance();
                                break;
                            case R.id.action_item4:
                                item.setIcon(R.drawable.ic_feed_on);
                                selectedFragment = FeedsFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, BaseFragment.newInstance());
        transaction.commit();
    }
}
