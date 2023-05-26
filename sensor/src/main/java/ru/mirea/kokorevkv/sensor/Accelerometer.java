package ru.mirea.kokorevkv.sensor;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.kokorevkv.sensor.databinding.ActivityMainBinding;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private ActivityMainBinding binding;
    private TextView magneticxTextView;
    private TextView magneticyTextView;
    private TextView magneticzTextView;
    private SensorManager sensorManager;
    private Sensor magneticSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        sensorManager =
                (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        magneticSensor = sensorManager
                .getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        magneticxTextView = findViewById(R.id.textViewAzimuth);
        magneticyTextView = findViewById(R.id.textViewPitch);
        magneticzTextView = findViewById(R.id.textViewRoll);
    }

    public void onClickNewActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, magneticSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float valueX = event.values[0];
            float valueY = event.values[1];
            float valueZ = event.values[2];
            magneticxTextView.setText("Magnit field x: " + valueX);
            magneticyTextView.setText("Magnit field y: " + valueY);
            magneticzTextView.setText("Magnit field z: " + valueZ);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}