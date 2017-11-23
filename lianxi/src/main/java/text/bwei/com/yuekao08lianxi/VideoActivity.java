package text.bwei.com.yuekao08lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import text.bwei.com.yuekao08lianxi.bean.MyString;
import text.bwei.com.yuekao08lianxi.common.PlayerManager;


//import com.bwie.test.liuhaifeng20171118.R;
//import com.bwie.test.liuhaifeng20171118.common.PlayerManager;

public class VideoActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener{
    private PlayerManager player;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        EventBus.getDefault().register(this);

    }
    private void initPlayer() {

        //初始化播放器
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FILLPARENT);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onPlay() {

    }
    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void F(MyString myString){
        url =  myString.getString();
        if(url !=null){
            initPlayer();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
