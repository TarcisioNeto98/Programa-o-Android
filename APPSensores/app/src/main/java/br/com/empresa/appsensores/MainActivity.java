package br.com.empresa.appsensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.EventListener;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {//Interface que capta o sensor, osensor fica ativo toda hora, e essa interface fica captando-o

    private SensorManager gerenciadorSensor;//Objeto que gerencia os sensores que serão usados.
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gerenciadorSensor = (SensorManager) getSystemService(Context.SENSOR_SERVICE);//Método que retorna uma instancia, passando nele o tipo de serviço que será utilizado.
        //No caso o SENSOR_SERVICE, serviço de sensores.

        List<Sensor> listaSensores = gerenciadorSensor.getSensorList(Sensor.TYPE_ALL);//Método que retorna uma lista de sensores que podem ser usados no dispositivo.
        //Passando nele o tipo dos sensores que eu quero pegar, no caso o TYPE_ALL, ou seja, todos os sensores.
        sensor = gerenciadorSensor.getDefaultSensor(Sensor.TYPE_LIGHT);//Método que retorna um sensor, nele é passado o tipo do senssor que será utilizado.

        for (Sensor s: listaSensores) {
            Toast.makeText(getApplicationContext(), "Nome do sensor: "+s.getStringType().toString()+" Fabricante: " + s.getName().toString(), Toast.LENGTH_SHORT).show();//O método getStringType() retorna o nome do sensor, o getName(), retorna
            //o nome do fabricante do sensor.
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {//Método utilizado quando o sensor foi captado.
        //sensorEvent, é o evento que ocorreu e foi captado.
        Toast.makeText(getApplicationContext(), sensorEvent.values[0] + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        gerenciadorSensor.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);//Método que registra um sensor em meu gerenciador.
    }

    @Override
    protected void onPause(){
        super.onPause();
        gerenciadorSensor.unregisterListener(this);
    }

}