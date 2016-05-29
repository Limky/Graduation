package zebra.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import example.zxing.R;

/**
 * Created by multimedia on 2016-05-29.
 */
public class LoadaingActivity extends AppCompatActivity {

    AnimationDrawable frameAnimation;
    ImageView imageAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        setAnimation();

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler() , 2000);
    }

    private class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(), MainActivity.class)); // 로딩이 끝난후 이동할 Activity
            LoadaingActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }
    }

    public void setAnimation(){
        imageAnimation = (ImageView) findViewById(R.id.imageAnimation);
        // animation_list.xml 를 ImageView 백그라운드에 셋팅한다
        imageAnimation.setBackgroundResource(R.drawable.zebra_animation);
        // 이미지를 동작시키기위해  AnimationDrawable 객체를 가져온다.
        frameAnimation = (AnimationDrawable)imageAnimation.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // 어플에 포커스가 갈때 시작된다
            frameAnimation.start();
        } else {
            // 어플에 포커스를 떠나면 종료한다
            frameAnimation.stop();
        }
    }
}
