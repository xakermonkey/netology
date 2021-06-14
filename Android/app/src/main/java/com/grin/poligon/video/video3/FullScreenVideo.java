package com.grin.poligon.video.video3;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Rational;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.afollestad.materialdialogs.MaterialDialog;
import com.grin.poligon.R;

import java.util.ArrayList;

class FullScreenVideo extends AppCompatActivity implements EasyVideoCallback {

    private static final String TEST_URL = "file:///storage/emulated/0/Hold_Control/S.mp4";
    final Rational rationalLimitWide = new Rational(239, 100);
    final Rational rationalLimitTall = new Rational(100, 239);
    private EasyVideoPlayer player;
    private Object mPictureInPictureParamsBuilder;
    private static final String ACTION_MEDIA_CONTROL = "media_control";
    private static final String EXTRA_CONTROL_TYPE = "control_type";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.full_screen_video);

        player = (EasyVideoPlayer) findViewById(R.id.player);


        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) player.getLayoutParams();


        player.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int heig;
                int weig;
                player.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                heig = player.getHeight();
                weig = player.getWidth();


                layoutParams.height = (int) ((weig*9.0)/16.0);
                player.setLayoutParams(layoutParams);
            }
        });


        //   assert player != null;
        player.setCallback(this);
        player.setSource(Uri.parse(TEST_URL));
        player.setAutoPlay(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mPictureInPictureParamsBuilder = new PictureInPictureParams.Builder();

            //     enterPiP();
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void enterPiP() {
        final AppOpsManager appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
        if (AppOpsManager.MODE_ALLOWED != appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_PICTURE_IN_PICTURE, android.os.Process.myUid(), getPackageName())) {
            startActivity(new Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS", Uri.fromParts("package", getPackageName(), null)));
            return;
        }

        //     playerView.setControllerAutoShow(false);
        //    playerView.hideController();

        //  final Format format = player.getVideoFormat();

        //      if (format != null)
        {
            // https://github.com/google/ExoPlayer/issues/8611
            // TODO: Test/disable on Android 11+
//            final View videoSurfaceView = playerView.getVideoSurfaceView();
//            if (videoSurfaceView instanceof SurfaceView) {
//                ((SurfaceView)videoSurfaceView).getHolder().setFixedSize(format.width, format.height);
//            }


            //     if (Utils.isRotated(format))
            //    rational = new Rational(format.height, format.width);
            //    else
            //  rational = new Rational(format.width, format.height);
            Rational rational;
            rational = new Rational(160,  90);
            if (rational.floatValue() > rationalLimitWide.floatValue())
                rational = rationalLimitWide;
            else if (rational.floatValue() < rationalLimitTall.floatValue())
                rational = rationalLimitTall;
            ((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).setAspectRatio(rational);
        }
        enterPictureInPictureMode(((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).build());
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.pause();
    }
    @TargetApi(26)
    void updatePictureInPictureActions(final int iconId, final String title, final int controlType, final int requestCode) {
        final ArrayList<RemoteAction> actions = new ArrayList<>();
        final PendingIntent intent = PendingIntent.getBroadcast(FullScreenVideo.this, requestCode,
                new Intent(ACTION_MEDIA_CONTROL).putExtra(EXTRA_CONTROL_TYPE, controlType), PendingIntent.FLAG_IMMUTABLE);
        final Icon icon = Icon.createWithResource(FullScreenVideo.this, iconId);
        actions.add(new RemoteAction(icon, title, title, intent));
        ((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).setActions(actions);
        setPictureInPictureParams(((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).build());
    }
    @Override
    public void onPreparing(EasyVideoPlayer player) {
        Log.d("EVP-Sample", "onPreparing()");
    }

    @Override
    public void onPrepared(EasyVideoPlayer player) {
        Log.d("EVP-Sample", "onPrepared()");
    }

    @Override
    public void onBuffering(int percent) {
        Log.d("EVP-Sample", "onBuffering(): " + percent + "%");
    }

    @Override
    public void onError(EasyVideoPlayer player, Exception e) {
        Log.d("EVP-Sample", "onError(): " + e.getMessage());
        new MaterialDialog.Builder(this)
                .title("R.string.e")
                .content(e.getMessage())
                .positiveText(android.R.string.ok)
                .show();
    }

    @Override
    public void onCompletion(EasyVideoPlayer player) {
        Log.d("EVP-Sample", "onCompletion()");
    }

    @Override
    public void onRetry(EasyVideoPlayer player, Uri source) {
        Toast.makeText(this, "Retry", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSubmit(EasyVideoPlayer player, Uri source) {
        Toast.makeText(this, "Submit", Toast.LENGTH_SHORT).show();
    }



}