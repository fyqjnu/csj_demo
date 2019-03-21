package demo.cwsdktt;

import android.app.Application;

import com.xdad.CWAPI;

/**
 * Created by Administrator on 2019/3/4 0004.
 */

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化：传入开发者后台申请的appid，跟渠道id（可传null）
        //db69044e47fb488ea46203fb
        //b1b1679cbe4345aab5850e84  俊澎

        CWAPI.init(this, "830de89e28fb4c7b8d2112e3", null);

    }
}
