package com.example.administrator.keshe.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.keshe.R;
import com.example.administrator.keshe.keshe.SayHelloActivity;

import cn.bmob.v3.BmobUser;

public class MainActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    public Context mContext = this;
    /**
     * Fragment managing the behaviors, interactions and presentation of the
     * navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in
     * {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();

//        String username = (String) Person.getObjectByKey(mContext, "username");

        //  user.setText("132");
        mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
                .findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                Intent oil=new Intent(MainActivity.this,OilActivity.class);
                startActivity(oil);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                Intent map=new Intent(MainActivity.this,MapActivity.class);
                startActivity(map);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                Intent fix=new Intent(this,FixActivity.class);
                startActivity(fix);
                break;
            case 5:
                mTitle = getString(R.string.title_section6);
                Intent weizhang=new Intent(MainActivity.this,WeizhangActivity.class);
                startActivity(weizhang);
                break;
            case 6:
                mTitle = getString(R.string.title_section7);
                Intent a=new Intent(MainActivity.this,SetActivity.class);
                startActivity(a);
                break;
            case 7:
                mTitle = "车车通信";
                Intent q = new Intent(MainActivity.this, SayHelloActivity.class);
                startActivity(q);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView user;
            TextView name;
            TextView sex;

            TextView number;
            TextView oilclass;
            TextView vehcleclass;

            user=(TextView)rootView.findViewById(R.id.user);
            name=(TextView)rootView.findViewById(R.id.name);
            sex=(TextView)rootView.findViewById(R.id.sex);

            number=(TextView)rootView.findViewById(R.id.number);
            oilclass=(TextView)rootView.findViewById(R.id.oilclass);
            vehcleclass=(TextView)rootView.findViewById(R.id.vehcleclass);

            String username = (String) BmobUser.getObjectByKey(getActivity(), "username");
            String nametext = (String) BmobUser.getObjectByKey(getActivity(), "name");
            String sextext = (String) BmobUser.getObjectByKey(getActivity(), "sex");
            user.setText("用户名："+username);
            if(nametext==null){
                name.setText("昵称：未设置");
            }
           else{
                name.setText("昵称："+nametext);
            }
            if (sextext == null) {
                sex.setText("性别：未设置");
            }
            else{
                sex.setText("性别："+sextext);
            }

            String vehclenumbertext = (String) BmobUser.getObjectByKey(getActivity(), "vehclenumber1");
            String vehcleclasstext = (String) BmobUser.getObjectByKey(getActivity(), "vehcleclass1");
            String oilclasstext = (String) BmobUser.getObjectByKey(getActivity(), "oilclass1");

            if(vehclenumbertext==null){
                number.setText("车牌：未设置");
            }
            else
            {
                number.setText("车牌："+vehclenumbertext);
            }


            if(vehcleclasstext==null){
                vehcleclass.setText("车型：未设置");
            }
            else{
                vehcleclass.setText("车型："+vehcleclasstext);
            }
            if (oilclasstext== null) {
                oilclass.setText("油型：未设置");
            }
            else{
                oilclass.setText("油型："+oilclasstext);
            }
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    public void inti(){

    }
}
