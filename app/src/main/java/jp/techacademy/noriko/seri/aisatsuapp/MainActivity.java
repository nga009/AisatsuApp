package jp.techacademy.noriko.seri.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });



    }

    private void showTimePickerDialog() {

        Calendar calendar = Calendar.getInstance();

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        TextView textView = (TextView) findViewById(R.id.textView1);

                        Integer input = Integer.parseInt(String.valueOf(hourOfDay) + String.format("%02d",minute));
                        if(input >= 200 && input < 1000 ){
                            textView.setText("おはよう");

                        } else if (input >= 1000 && input < 1800){
                            textView.setText("こんにちは");

                        } else {
                            textView.setText("こんばんは");

                        }

                    }
                },
                calendar.get(Calendar.HOUR_OF_DAY), // 初期値（時間）
                calendar.get(Calendar.MINUTE),  // 初期値（分）
                true);
        timePickerDialog.show();
    }


}

