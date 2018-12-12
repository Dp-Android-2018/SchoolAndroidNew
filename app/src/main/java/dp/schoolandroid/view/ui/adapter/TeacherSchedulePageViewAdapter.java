package dp.schoolandroid.view.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dp.schoolandroid.view.ui.fragment.DayFragment;

public class TeacherSchedulePageViewAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private DayFragment dayFragment;

    public TeacherSchedulePageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Fragment getItem(int position) {
        return new DayFragment(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        return tabTitles[position];
    }
}
