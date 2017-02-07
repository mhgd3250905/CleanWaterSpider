package skkk.cleanwaterinformation;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebVideoActivity extends AppCompatActivity {


    @Bind(R.id.tb_webViedo)
    Toolbar mTbWebViedo;
    @Bind(R.id.vv_webViedo)
    VideoView mVvWebViedo;

    MediaController mController;
    private String url = null;
    private String title = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
        initUI();
        initVideoView();
    }


    private void initUI() {
        setContentView(R.layout.activity_web_video);
        ButterKnife.bind(this);

        mTbWebViedo.setTitle(title);
        setSupportActionBar(mTbWebViedo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mTbWebViedo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

/*
    * @方法 初始化ViewVideo
    *
    */

    private void initVideoView() {
        //创建MediaController
        mController = new MediaController(this);
        Uri videoUri = Uri.parse(url);
        mVvWebViedo.setVideoURI(videoUri);
        mVvWebViedo.setMediaController(mController);
        mController.setMediaPlayer(mVvWebViedo);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        return super.onKeyDown(keyCode, event);
    }
}
