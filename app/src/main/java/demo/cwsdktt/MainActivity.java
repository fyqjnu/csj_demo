package demo.cwsdktt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import com.xdad.BannerAdView;
import com.xdad.CWAPI;
import com.xdad.RewardVideoLoadListener;
import com.xdad.RewardVideoPlayListener;

public class MainActivity extends AppCompatActivity {


    BannerAdView ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_splash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SplashActivity.class));
            }
        });

        findViewById(R.id.btn_cp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CWAPI.display(false);
            }
        });
        findViewById(R.id.btn_banner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FrameLayout container = (FrameLayout) findViewById(R.id.container);

                if(ba==null) {
                    ba = new BannerAdView(MainActivity.this);
                    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
                    lp.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
                    container.addView(ba, lp);
                }
            }

        });

        findViewById(R.id.btn_reward).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CWAPI.loadRewardVideo("111", "金币", 100, new RewardVideoLoadListener() {
                    @Override
                    public void onReady() {
                        System.out.println("视频广告加载成功");
                        CWAPI.showRewardVideo(MainActivity.this, new RewardVideoPlayListener() {
                            @Override
                            public void onVideoComplete() {
                                System.out.println("播放完成");
                            }

                            @Override
                            public void onVideoClosed() {
                                System.out.println("视频广告关闭");
                            }

                            @Override
                            public void onVideoShow() {
                                System.out.println("开始播放视频广告");
                            }
                        });
                    }

                    @Override
                    public void onError(String s) {
                        System.out.println("视频广告加载失败>>" + s);
                    }
                });
            }
        });



    }
}
