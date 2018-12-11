package dp.schoolandroid.view.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dp.schoolandroid.view.ui.fragment.DayFragment;

public class TeacherSchedulePageViewAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Saturday", "Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday"};
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

        switch (position) {
            case 0:
                dayFragment= new DayFragment(0);
                break;
            case 1:
                dayFragment=  new DayFragment(1);
                break;
            case 2:
                dayFragment=  new DayFragment(2);
                break;
            case 3:
                dayFragment=  new DayFragment(3);
                break;
            case 4:
                dayFragment=  new DayFragment(4);
                break;

            case 5:
                dayFragment=  new DayFragment(5);
                break;

            case 6:
                dayFragment=  new DayFragment(6);
                break;
        }
        return dayFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        return tabTitles[position];
    }
}
