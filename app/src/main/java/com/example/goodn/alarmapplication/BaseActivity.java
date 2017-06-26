package com.example.goodn.alarmapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 최상단 Activity
 */
public class BaseActivity extends AppCompatActivity {

    protected Context context;

    public void initToolbar(String title) {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.ll_navi_back);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
        LinearLayout llTitle = (LinearLayout)findViewById(R.id.ll_title);
        TextView titleView = (TextView)findViewById(R.id.tv_title);

        if (title.length() > 26) {
            llTitle.setGravity(Gravity.CENTER_HORIZONTAL);
            titleView.setText(title);
        } else {
            llTitle.setGravity(Gravity.CENTER_HORIZONTAL);
            titleView.setGravity(Gravity.CENTER_VERTICAL);
            titleView.setText(title);
        }
    }

}
