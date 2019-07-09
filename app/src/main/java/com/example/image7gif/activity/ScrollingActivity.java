package com.example.image7gif.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.image7gif.R;
import com.example.image7gif.fragment.ChristineWallaceFragment;
import com.example.image7gif.fragment.LorenTurnerFragment;
import com.example.image7gif.fragment.LoriPerezFragment;

import java.util.HashMap;

public class ScrollingActivity extends AppCompatActivity implements ViewPagerEx.OnPageChangeListener {

    private SliderLayout mDemoSlider;

    private LorenTurnerFragment lorenTurnerFragment;
    private ChristineWallaceFragment christineWallaceFragment;
    private LoriPerezFragment loriPerezFragment;
    TextView txtFollower,txtFollowing,txtPost;
    LinearLayout linearLayout;
    Animation slideUp;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.bottomNavigationView);
        txtFollower = findViewById(R.id.txtFollower);
        txtFollowing = findViewById(R.id.txtFollowing);
        txtPost = findViewById(R.id.txtPost);
        linearLayout = findViewById(R.id.linearlayout);

        setSlider();

        navigationView.getMenu().getItem(2).setChecked(true);
        slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        lorenTurnerFragment = new LorenTurnerFragment();
        christineWallaceFragment = new ChristineWallaceFragment();
        loriPerezFragment = new LoriPerezFragment();

        linearLayout.startAnimation(slideUp);
        txtFollower.setText("403");
        txtFollowing.setText("589");
        txtPost.setText("904");
        replaceFragment(lorenTurnerFragment);
    }

    private void setSlider() {

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.mipmap.image_one);
        file_maps.put("Big Bang Theory",R.mipmap.image_two);
        file_maps.put("House of Cards",R.mipmap.image_three);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
            mDemoSlider.stopAutoCycle();
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Toast.makeText(this,"Slider Page Scrolled"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageSelected(int position) {
//        Toast.makeText(this,"Slider Page Selected"+position,Toast.LENGTH_SHORT).show();

        if (position == 0){
            linearLayout.startAnimation(slideUp);
            txtFollower.setText("403");
            txtFollowing.setText("589");
            txtPost.setText("904");
            replaceFragment(lorenTurnerFragment);
        }else if (position == 1){
            linearLayout.startAnimation(slideUp);
            txtFollower.setText("5688");
            txtFollowing.setText("845");
            txtPost.setText("1086");
            replaceFragment(christineWallaceFragment);
        }else if (position == 2){
            linearLayout.startAnimation(slideUp);
            txtFollower.setText("511");
            txtFollowing.setText("485");
            txtPost.setText("452");
            replaceFragment(loriPerezFragment);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
//        Toast.makeText(this,"Slider Page Scroll State Changed"+state,Toast.LENGTH_SHORT).show();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }
}
