package text.bwei.com.yuekao08lianxi.utils;

import android.app.Application;

import text.bwei.com.yuekao08lianxi.gen.DaoMaster;
import text.bwei.com.yuekao08lianxi.gen.DaoSession;
import text.bwei.com.yuekao08lianxi.gen.UserDao;


/**
 * date：2017/11/22
 * 用途：
 */
public class App extends Application {
    public static UserDao userDao;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "lenvess.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        userDao = daoSession.getUserDao();
    }
}
