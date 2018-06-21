package jianqiang.com.receiverhook;

import android.app.Application;
import android.content.Context;

import java.io.File;

import jianqiang.com.receiverhook.classloder_hook.BaseDexClassLoaderHookHelper;

/**
 * 这个类只是为了方便获取全局Context的.
 *
 * @author weishu
 * @date 16/3/29
 */
public class UPFApplication extends Application {

    private static Context sContext;

    static final String apkName = "receivertest.apk";
    static final String dexName = "receivertest.dex";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = base;

        //解压到本地
        Utils.extractAssets(this, apkName);

        File dexFile = getFileStreamPath(apkName);
        File optDexFile = getFileStreamPath(dexName);

        try {
            BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        File testPlugin = getFileStreamPath(apkName);
        ReceiverHelper.preLoadReceiver(this, testPlugin);
    }

    public static Context getContext() {
        return sContext;
    }
}
