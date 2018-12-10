package dp.schoolandroid.view.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import dp.schoolandroid.DayFragment;

public class TeacherSchedulePageViewAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] {"Saturday", "Sunday", "Monday", "Tuesday","Wednesday","Thursday","Friday"};

    public TeacherSchedulePageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public Fragment getItem(int position) {

        return new DayFragment();
        /*if(position == 0) {
            return new DayFragment();
        } else if (position == 1) {
            return new ColorsFragment();
        }
        else if (position == 2) {
            return new FamilyFragment();
        }
        else
        {
            return new PhrasesFragment();
        }*/
        //return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        return tabTitles[position];
    }
}
