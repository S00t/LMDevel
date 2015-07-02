package com.example.letsmeet.letsmeet.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.letsmeet.letsmeet.Fragments.FragmentAccount;
import com.example.letsmeet.letsmeet.Fragments.FragmentChangePassword;
import com.example.letsmeet.letsmeet.Fragments.FragmentEventAdd;
import com.example.letsmeet.letsmeet.Fragments.FragmentEvent;
import com.example.letsmeet.letsmeet.Fragments.FragmentEventList;
import com.example.letsmeet.letsmeet.Fragments.FragmentLogin;
import com.example.letsmeet.letsmeet.Fragments.FragmentRegister;
import com.example.letsmeet.letsmeet.Fragments.FragmentSearch;
import com.example.letsmeet.letsmeet.Models.Event;
import com.example.letsmeet.letsmeet.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fares on 07.06.15.
 */
public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // purpose: if try to open same fragment as is currently display -> do nothing
    private static int activeFragment = -1;

    public static final int FRAGMENT_LOGIN      = 0;
    public static final int FRAGMENT_REGISTER   = 1;
    public static final int FRAGMENT_SEARCH     = 2;
    public static final int FRAGMENT_EVENT      = 3;
    public static final int FRAGMENT_EVENT_ADD  = 4;
    public static final int FRAGMENT_EVENT_LIST = 5;
    public static final int FRAGMENT_ACCOUNT    = 6;
    public static final int FRAGMENT_CHANGE_FRAGMENT    = 7;

    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    private List<Event> eventList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpNavDrawer();

        // test
        createTestEventList();
        openFragment(FRAGMENT_SEARCH);
    }

    private void createTestEventList(){
        eventList = new LinkedList<>();
        for (int i = 0; i < 30; i++){
//            String name, int participantsMax, int participantsCurrent, String place, String date)
            int tmp = (int) (Math.random()*100) %30;
            eventList.add(new Event(0, 0, "wydarzenie "+i, tmp, Math.abs(tmp - i), "miejsce "+i, "data  "+i));
        }
    }

    private void setUpNavDrawer() {
        NavigationView view = (NavigationView) findViewById(R.id.navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigationDrawer);
        view.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.appToolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void openFragment(int fragmentType) {

        // start transaction when want to display different fragment then current
        if (!(activeFragment == fragmentType)) {
            activeFragment = fragmentType;

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Fragment f = getFragment(fragmentType);
            fragmentTransaction.replace(R.id.mainScreenFragmentContainer, f);

            fragmentTransaction.commit();
        }
    }

    private Fragment getFragment(int fragmentType) {
        switch (fragmentType) {
            case FRAGMENT_ACCOUNT:
                return FragmentAccount.newInstance();
            case FRAGMENT_EVENT:
                return FragmentEvent.newInstance();
            case FRAGMENT_EVENT_ADD:
                return FragmentEventAdd.newInstance();
            case FRAGMENT_EVENT_LIST:
                return FragmentEventList.newInstance(eventList);
            case FRAGMENT_LOGIN:
                return FragmentLogin.newInstance();
            case FRAGMENT_REGISTER:
                return FragmentRegister.newInstance();
            case FRAGMENT_SEARCH:
                return FragmentSearch.newInstance();
            case FRAGMENT_CHANGE_FRAGMENT:
                return FragmentChangePassword.newInstance();
            default:
                Log.d("test", "I cant find fragment to open");
                break;
        }
        return null;
    }

    @Override
    public void onBackPressed() {
        if (activeFragment == FRAGMENT_EVENT_LIST) {
            finish();
        }
        else {
            // return to main fragment
            openFragment(FRAGMENT_EVENT_LIST);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.navigationItem1){
            openFragment(FRAGMENT_EVENT_LIST);
        }
        else if (id == R.id.navigationItem2) {
        }
        else if (id == R.id.navigationItem3) {
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
