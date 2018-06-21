package jianqiang.com.receivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {
    static final String ACTION = "weishu";

    public MyReceiver2() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "接收到200万" + intent.getAction() + intent.getStringExtra("msg"),
                Toast.LENGTH_LONG).show();

        context.sendBroadcast(new Intent(ACTION));
    }
}
