package nyc.c4q.enough.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nyc.c4q.enough.help.HelpFragment;

/**
 * Created by c4q on 3/3/18.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;


    public FragmentAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numberOfTabs = numOfTabs;
    }
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HelpFragment();
            /*case 1:
                return new TimeswireFragment();
            case 2:
                return new MovieReviewsFragment();*/
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
         return numberOfTabs;
    }
}
