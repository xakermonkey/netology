package com.grin.poligon.adam;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.grin.poligon.R;
import com.grin.poligon.adam2.AccountFragment;
import com.grin.poligon.adam2.BookFragment;
import com.grin.poligon.adam2.HomeFragment;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;



public class MainFragment extends Fragment {
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        animatedBottomBar = view.findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getChildFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container1, homeFragment)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.book:
                        fragment = new BookFragment();
                        break;
                    case R.id.account:
                        fragment = new AccountFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getChildFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container1, fragment)
                            .commit();
                }
            }
        });



        return view;
    }

    private class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            // Create some layout params
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

            // Create some text
            TextView textView = getTextView(container.getContext());
            textView.setText(String.valueOf(position));
            textView.setLayoutParams(layoutParams);

            RelativeLayout layout = new RelativeLayout(container.getContext());
            layout.setBackgroundColor(ContextCompat.getColor(container.getContext(), R.color.colorPrimary));
            layout.setLayoutParams(layoutParams);

            layout.addView(textView);
            container.addView(layout);
            return layout;
        }

        private TextView getTextView(Context context) {
            TextView textView = new TextView(context);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(30);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }
}
