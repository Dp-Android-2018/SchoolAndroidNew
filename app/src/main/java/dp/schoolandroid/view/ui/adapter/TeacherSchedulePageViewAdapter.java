package dp.schoolandroid.view.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.gson.Gson;

import dp.schoolandroid.service.model.global.TeacherSchedule;
import dp.schoolandroid.view.ui.fragment.DayFragment;

public class TeacherSchedulePageViewAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private DayFragment dayFragment;
    private TeacherSchedule weekData;

    public TeacherSchedulePageViewAdapter(FragmentManager fm , TeacherSchedule weekData) {
        super(fm);
        this.weekData = weekData;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("Week Data Values :"+new Gson().toJson(weekData));
        dayFragment = new DayFragment(position , weekData);
        return dayFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);
        return tabTitles[position];
    }
}
