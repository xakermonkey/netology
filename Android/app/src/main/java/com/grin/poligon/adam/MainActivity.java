package com.grin.poligon.adam;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import com.grin.poligon.R;
import com.grin.poligon.adam2.AccountFragment;
import com.grin.poligon.adam2.BookFragment;
import com.grin.poligon.adam2.HomeFragment;
import com.grin.poligon.bottomSheet.BottomSheet;
import com.grin.poligon.comunity.UsersActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import me.ibrahimsn.particle.ParticleView;
import nl.joery.animatedbottombar.AnimatedBottomBar;
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.grin.poligon.bottomSheet.Constants.D_COLOR_TV;


public class MainActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener {
    private MenuAdapter mMenuAdapter;
    private ViewHolder mViewHolder;
    public static ParticleView particleView;
    private final OkHttpClient client = new OkHttpClient();




    private ArrayList<String> mTitles = new ArrayList<>();

    @Override
    protected void onPause() {
        super.onPause();
        particleView.pause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        particleView.resume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));

        particleView = findViewById(R.id.particleView);


        SharedPreferences sharedPreferences = getSharedPreferences("design", MODE_PRIVATE);
       //  editor.putInt(D_COLOR_TV, R.color.red_l);


        particleView.setParticleColor((sharedPreferences.getInt(D_COLOR_TV,R.color.red_l)));
        particleView.setParticleLineColor((sharedPreferences.getInt(D_COLOR_TV,R.color.red_l)));

         mViewHolder = new ViewHolder();

         handleToolbar();

         handleMenu();

          handleDrawer();

        // Show main fragment in container
        goToFragment(new MainFragment(), false);
        mMenuAdapter.setViewSelected(0, true);
        setTitle(mTitles.get(0));


        Runnable rw = new Runnable() {
            @Override
            public void run() {
          //      makePost();
           //     doGetRequest();
            }
        };
        Thread sasi  = new Thread(rw);
      //  sasi.start();


    }

    private void handleToolbar() {
        setSupportActionBar(mViewHolder.mToolbar);
    }


    void doGetRequest( )  {


//
//        HttpUrl.Builder httpBuilder = HttpUrl.parse("https://566a2d639918.ngrok.io/api/users/profile").newBuilder();
//          {
//
//                httpBuilder.addEncodedQueryParameter("Host","566a2d639918.ngrok.io");
//                httpBuilder.addEncodedQueryParameter("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//                httpBuilder.addEncodedQueryParameter("Accept-Encoding","gzip, deflate, br");
//                httpBuilder.addEncodedQueryParameter("Accept-Language","ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
//                httpBuilder.addEncodedQueryParameter("Cache-Control","max-age=0");
//                httpBuilder.addEncodedQueryParameter("Cookie","csrftoken=f1BBIpEw6gTyLz1kZfHB8f3H6OjcpVCcQNG0OBGpsJ3JMnpFcry9JVUCsSc0Qrvm; sessionid=ni5aoji85remqjtdv296eexk3g6inkm0");
//                httpBuilder.addEncodedQueryParameter("Dnt","1");
//
//        }
//
//        Request request = new Request.Builder().url(httpBuilder.build()).build();
//
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful())
//                throw new IOException("Unexpected code " + response);
//
//
//            Headers responseHeaders = response.headers();
//            for (int i = 0; i < responseHeaders.size(); i++) {
//                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//            }
//
//            System.out.println(response.body().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Request request = new Request.Builder()
                .url("https://566a2d639918.ngrok.io/api/users/profile?format=json")
       .addHeader("Host","566a2d639918.ngrok.io")
       .addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
       .addHeader("Accept-Encoding","gzip, deflate, br")
       .addHeader("Accept-Language","ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
       .addHeader("Cache-Control","max-age=0")
       .addHeader("Cookie","csrftoken=f1BBIpEw6gTyLz1kZfHB8f3H6OjcpVCcQNG0OBGpsJ3JMnpFcry9JVUCsSc0Qrvm; sessionid=ni5aoji85remqjtdv296eexk3g6inkm0")
       .addHeader("Dnt","1")


                .build();
        try {
        Response response = client.newCall(request).execute();



        System.out.println("1111111   "+response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makePost(){
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("email", "sasat")
                .addFormDataPart("password", "sasat123qQ!")
                .addFormDataPart("first_name", "SasaT")
                .addFormDataPart("last_name", "TTT")
                .build();

        Request request = new Request.Builder()
                .url("https://566a2d639918.ngrok.io/api/users/register")
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);


            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }}


        private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

    }

    private void handleMenu() {
        mMenuAdapter = new MenuAdapter(mTitles);

        mViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);
    }

    @Override
    public void onFooterClicked() {
        BottomSheet bottomSheet = new BottomSheet();
        bottomSheet.show(getSupportFragmentManager(),"TAG");
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show();
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            transaction.addToBackStack(null);
        }

        transaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        // Set the toolbar title
        setTitle(mTitles.get(position));

        // Set the right options selected
        mMenuAdapter.setViewSelected(position, true);

        // Navigate to the right fragment
        switch (position) {
            case 0:
                goToFragment(new MainFragment(), false);
                break;


            default:
                goToFragment(new UsersActivity(), false);
                break;
        }

        // Close the drawer
        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        }
    }
}
