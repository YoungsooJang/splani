package com.splani.jangyoungsoo.splani;

import android.graphics.Path;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.util.Log;
import android.view.View;

import com.splani.jangyoungsoo.splani.databinding.ActivityMainBinding;

import org.apache.commons.io.IOUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ActivityMainBinding m_b = DataBindingUtil.setContentView(this, R.layout.activity_main);
        m_b.setSplash(new SplashForegroundView(this));
        try
        {
            final String pathString = IOUtils.toString(getAssets().open("splash/foreground.path"), "UTF-8");
            final Path path = PathParser.createPathFromPathData(pathString);

            m_b.splash.setPath(path, 400, 400);
            m_b.splash.setFillDrawable(R.drawable.splash_fill);
            //m_b.splash.setOnStateChangeListener(m_onStateChangeListener);
            m_b.splash.start();
        }
        catch (Exception e)
        {
            Log.e("ERROR", e.toString());
            // Nothing
        }
    }
}
