package app.example.marichal.manillas;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private Spinner mat;
    private Spinner tip;
    private Spinner dij;
    private Spinner pago;
    private TextView res;
    private EditText n1;
    private Resources resources;
    private String vecMaterial[];
    private String vecDije[];
    private String vecTipo[];
    private String vecpago[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        res = (TextView) findViewById(R.id.txtResultado);
        n1 = (EditText) findViewById(R.id.lblResultado);
        resources = this.getResources();
        pago = (Spinner) findViewById(R.id.cmbpago);
        vecpago = resources.getStringArray(R.array.Pago1);
        mat = (Spinner) findViewById(R.id.cmbMaterial);
        vecMaterial = resources.getStringArray(R.array.Material);
        tip = (Spinner) findViewById(R.id.cmbTipo);
        vecTipo = resources.getStringArray(R.array.Tipo);
        dij = (Spinner) findViewById(R.id.cmbDije);
        vecDije = resources.getStringArray(R.array.Dije);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vecMaterial);
        mat.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vecTipo);
        tip.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vecDije);
        dij.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vecpago);
        pago.setAdapter(adapter3);


    }
    public void calcular(View v) {
        int posicion = mat.getSelectedItemPosition();
        int posicion1 = dij.getSelectedItemPosition();
        int posicion2 = tip.getSelectedItemPosition();
        double var = 0;




        if (posicion == 0) {
            if (posicion1 == 0) {
                if (posicion2 == 0) {
                    var = 100;
                } else if (posicion2 == 1) {
                    var = 100;
                } else if (posicion2 == 2) {
                    var = 80;
                } else if (posicion2 == 3) {
                    var = 70;
                }
            } else {
                if (posicion == 1) {
                    if (posicion1 == 0) {
                        var = 120;
                    } else if (posicion1 == 1) {
                        var = 90;
                    } else if (posicion1 == 2) {
                        var = 120;
                    } else if (posicion1 == 3) {
                        var = 100;
                    }
                }
            }
        } else {
            if (posicion1 == 0) {
                if (posicion2 == 0) {
                    var = 90;
                } else if (posicion2 == 1) {
                    var = 90;
                } else if (posicion2 == 2) {
                    var = 70;
                } else if (posicion2 == 2) {
                    var = 50;
                }
            } else {
                if (posicion1 == 1) {
                    var = 110;
                } else if (posicion2 == 1) {
                    var = 110;
                } else if (posicion2 == 2) {
                    var = 90;
                } else if (posicion2 == 2) {
                    var = 80;
                }
            }
        }
        int pos = pago.getSelectedItemPosition();
        int r= Integer.parseInt(n1.getText().toString());
        double total = var * r;
        if( pos == 1) {
            res.setText(" " + total);
        }else{
            total = total*3200;
            res.setText(" " + total);
        }
    }
    public void borrar(View v){
        n1.setText("");
        v.requestFocus();
        tip.requestFocus();
        res.requestFocus();
    }

}
