package com.grin.poligon.adam2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.grin.poligon.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {


    private SectionsPagerAdapter mSectionsPagerAdapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_account, container, false);
          {



              mTabLayout = view.findViewById(R.id.main_tabs);
              mViewPager = view.findViewById(R.id.tabPager);
              mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

              mViewPager.setAdapter(mSectionsPagerAdapter);
              mViewPager.setOffscreenPageLimit(2);
              mTabLayout.setupWithViewPager(mViewPager);
              mTabLayout.setupWithViewPager(mViewPager);
              mTabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_data_usage_24);
              mTabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_query_stats_24);
              mTabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              mTabLayout.getTabAt(3).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              mTabLayout.getTabAt(4).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              // mTabLayout.getTabAt(5).setIcon(R.drawable.ic_gallery_video);
//              mTabLayout.getTabAt(5).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              mTabLayout.getTabAt(6).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              mTabLayout.getTabAt(7).setIcon(R.drawable.ic_baseline_alternate_email_24);
//              mTabLayout.getTabAt(8).setIcon(R.drawable.ic_baseline_alternate_email_24);

              //   mTabLayout.getTabAt(10).setIcon(R.drawable.ic_setting);


              mTabLayout.getChildAt(0).setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {


                      return false;
                  }
              });









                }





            ///////////////////








        //////////////////////

        return view;
    }


}
