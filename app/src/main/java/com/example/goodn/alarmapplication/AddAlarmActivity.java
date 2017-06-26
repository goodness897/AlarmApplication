package com.example.goodn.alarmapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AddAlarmActivity extends BaseActivity {

    private CustomTimePicker mTimePicker;

    private LinearLayout mLLAlarmSave;

    /**
     * 복약/측정 구분하는 플래그
     */
    private String mAlarmFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        initToolbar(getString(R.string.setting_activity_add_alarm));

        Intent intent = getIntent();
        mAlarmFlag = intent.getStringExtra(ManagerConstants.DataBase.COLUMN_NAME_MEDICINE_MEASURE_ALARM_TYPE);

        mLLAlarmSave = (LinearLayout)findViewById(R.id.ll_alarm_save);
        mLLAlarmSave.setVisibility(View.VISIBLE);
        mTimePicker = (CustomTimePicker)findViewById(R.id.timePicker);

        mLLAlarmSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!ManagerUtil.isClicking()) {
                    AlarmUtils.getInstance(AddAlarmActivity.this).setMedicineAlarmData(AddAlarmActivity.this,
                            mTimePicker.getCurrentHour(),
                            mTimePicker.getCurrentMinute(),
                            mAlarmFlag);
                    finish();
                }
            }
        });
    }

}
