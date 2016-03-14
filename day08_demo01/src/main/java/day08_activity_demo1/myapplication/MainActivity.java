package day08_activity_demo1.myapplication;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import day08_activity_demo1.myapplication.fragment.BaseFragment;
import day08_activity_demo1.myapplication.fragment.FoodFragment;
import day08_activity_demo1.myapplication.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener{
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private List<Fragment> pList=new ArrayList<>();
    private PagerAdapter adapter;

    /**
 *
 * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTablayout=(TabLayout)findViewById(R.id.tab_layout);
        mViewPager = (ViewPager)findViewById(R.id.main_viewPager);
//            给tablayout添加tab按钮
        mTablayout.addTab(mTablayout.newTab().setText("精选").setIcon(R.mipmap.ic_launcher));
        mTablayout.addTab(mTablayout.newTab().setText("涨姿势"));
//        mTablayout.addTab(mTablayout.newTab().setText("海淘"));
//        mTablayout.addTab(mTablayout.newTab().setText("美食"));
//        mTablayout.addTab(mTablayout.newTab().setText("美食1"));
//        mTablayout.addTab(mTablayout.newTab().setText("美食2"));
//        mTablayout.addTab(mTablayout.newTab().setText("美食3"));
//        mTablayout.addTab(mTablayout.newTab().setText("美食4"));

        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        initViewPager();
        TabPager();
    }

    private void  initViewPager(){
//        adapter
    pList.add(HomeFragment.newInstance(null,null));
    pList.add(FoodFragment.newInstance(null, null));
     adapter=new ContentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    private  void  TabPager(){

        mTablayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class ContentPagerAdapter extends FragmentPagerAdapter{


        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pList.get(position);
        }

        @Override
        public int getCount() {
            return pList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "菜单"+position;
        }
    }
}
