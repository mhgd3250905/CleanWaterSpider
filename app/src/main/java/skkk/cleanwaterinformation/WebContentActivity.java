package skkk.cleanwaterinformation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebContentActivity extends AppCompatActivity {

    @Bind(R.id.wv_content)
    WebView wvContent;
    private String content;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        ButterKnife.bind(this);
        initData();

        initWebView();
    }

    private void initData() {
        content=getIntent().getStringExtra("content");
        title=getIntent().getStringExtra("title");
    }

    private void initWebView() {
        wvContent.loadDataWithBaseURL(null,content,"text/html","utf-8",null);
    }
}
