package sv.edu.udb.problemas_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        //Contadores
    public String[] organizados;
    private int escalenos=0;
    private int isosceles=0;
    private int equilateros=0;
    private int cant =0;
    private int posicion =0;
    //Objeto clase
    Triangulos triangulo = new Triangulos();
    //Entrada de valores
    EditText  eN, e1,e2,e3;
    TextView salida;
    Button  btnAdd,btnOrg, btnaddT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (Button)findViewById(R.id.btnAñadirN);
        btnaddT = (Button)findViewById(R.id.btnAgregarT);
        btnaddT.setEnabled(false);
        btnOrg = (Button)findViewById(R.id.btnOrganizar);
        btnOrg.setEnabled(false);
        salida= (TextView) findViewById(R.id.txtResultado);
    }


    public void ObtenerN (View v){
        eN = (EditText) findViewById(R.id.txtCantidad);
        cant = Integer.parseInt(eN.getText().toString());
        if (cant >0 ){
            btnaddT.setEnabled(true);
            //ASIGNANDO ESPACIOS DE MEMORIA AL ARRAY
            organizados = new String[cant];
        }
        else{
            btnaddT.setEnabled(false);

        }
        //Imprimir int a string t1.setText(Integer.toString(cant));
    }

    public void AñadirTriangulo (View v) {
        e1 = (EditText) findViewById(R.id.txtLadoA);
        e2 = (EditText) findViewById(R.id.txtLadoB);
        e3 = (EditText) findViewById(R.id.txtLadoC);
        //Arreglo de las posicion inicial


       // TextView t1 = (TextView) findViewById(R.id.txtCantidad);
        int cantR = cant -1;
        if (posicion < (cantR) ){
            organizados[posicion] = triangulo.Clasificar(Integer.parseInt(e1.getText().toString()), Integer.parseInt(e2.getText().toString()), Integer.parseInt(e3.getText().toString()) );
            posicion++;
            LimpiarForm();
            }
        else{
            btnaddT.setEnabled(false);
            btnAdd.setEnabled(false);
            btnOrg.setEnabled(true);
            LimpiarForm();
        }
    }

    public void LimpiarForm () {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        salida.setText("");
    }

    public void Impresion(View v){
        String res = "";
        int i=0;
            do {

                if (organizados[i] == "Equilatero") {
                    equilateros = equilateros + 1;
                } else if (organizados[i] == "Isosceles") {
                    isosceles = isosceles + 1;
                } else if (organizados[i] == "Escalenos") {
                    escalenos = escalenos + 1;
                }
                i++;
            }while (i < organizados.length );
        if ( (escalenos  < equilateros) && (escalenos < isosceles) ){
                res = "El menor son escaleros";
        }
        else if ( (equilateros < escalenos) && (equilateros < isosceles) )
            res = "El menor son equilateros";
        else{
            res = "El menor son isosceles";
        }

        salida.setText("La cantidad de triangulos equilateros son: " + equilateros + "\n"+
                        "La cantidad de triangulos isosceles son: " + isosceles + "\n"+
                        "La cantidad de triangulos escalenos son: " + escalenos+ "\n"
                        + res + "\t");
    }
}
