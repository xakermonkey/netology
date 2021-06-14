package com.grin.poligon.adam2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.grin.poligon.fragmentForUser.CallLogFragment;
import com.grin.poligon.fragmentForUser.DayInAppFragment;
import com.grin.poligon.fragmentForUser.StackedBarActivity;


public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
    public SectionsPagerAdapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);


    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){


            case 0:
                CallLogFragment screenFragment = new CallLogFragment();
                return screenFragment;
            case 1:
                StackedBarActivity stackedBarActivity = new StackedBarActivity();
                return stackedBarActivity;

            case 2:
                DayInAppFragment dayInAppFragment = new DayInAppFragment();
                return dayInAppFragment;
//            case 3:
//                ContactsFragment contactsFragment = new ContactsFragment();
//                return contactsFragment;
//            case 4:
//                GalleryPhotoFragment galleryPhotoFragment = new GalleryPhotoFragment();
//                return galleryPhotoFragment;
//
//            case 5:
//                CameraPictureFagment makePhotoFragment = new CameraPictureFagment();
//                return makePhotoFragment;
//            case 6:
//                RecordVoiceFragment recordVoiceFragment = new RecordVoiceFragment();
//                return recordVoiceFragment;
//            case 7:
//                SmsFragment smsFragment = new SmsFragment();
//                return smsFragment;
//            case 8:
//                SignalFragment signalFragment = new SignalFragment();
//                return signalFragment;

//            case 10:
//                SettingsFragment settingsFragment = new SettingsFragment();
//                return settingsFragment;

            default:
                return null;
        }


    }


    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
//        switch (position){
//
//            case 0:
//                return "";
//             //   return "screenFragment";
//
//            case 1:
//                return "";
//            case 2:
//                return "";
//
//            case 3:
//                return "";
//            case 4:
//                return "";
//
//            case 5:
//                return "";
//            case 6:
//                return "";
//
//            case 7:
//                return "";
//            case 8:
//                return "";
//
//            case 9:
//                return "";
//
//
//            default:
//                return null;
//
//        }
return "";
    }
}
