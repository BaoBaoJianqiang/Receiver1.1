package jianqiang.com.receivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,
                "接收到100万" + intent.getAction() + intent.getStringExtra("msg"),
                Toast.LENGTH_LONG).show();
        context.sendBroadcast(new Intent("baobao2"));
    }
}
