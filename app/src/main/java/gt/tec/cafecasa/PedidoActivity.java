package gt.tec.cafecasa;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static gt.tec.cafecasa.R.drawable.cafe;
import static gt.tec.cafecasa.R.id.resultado0;
import static gt.tec.cafecasa.R.id.resultado1;

public class PedidoActivity extends Activity {
    // los totales comienzan en 0 para luego sumar segun contadores
    public int total = 0;
    public int total0 = 0;
    public int total1 = 0;
    public int total2 = 0;
    public int total3 = 0;
    public int total4 = 0;
    // se declara los contadores a 0 para aumentar segun cliente lo solicita
    int contador0 = 0;
    int contador1 = 0;
    int contador2 = 0;
    int contador3 = 0;
    int contador4 = 0;
    //se declara precio para luego ser llamados en suma de contador
    int precio0 = 14;
    int precio1 = 18;
    int precio2 = 16;
    int precio3 = 30;
    int precio4 = 30;
    String mensaje;
    Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido_main);
        Enviar = (Button) findViewById(R.id.Ordenar);
    }

    /*** Genera Orden segun seleccion del cliente */
    public void desplegarTotal(View view) {

        mensaje = " Hola " + ((EditText) findViewById(R.id.nombrecliente)).getText() + ", su pedido es: ";
 //si contador es mayor o igual a 1, entonces se mostrara en mensaje
        if (contador0 >= 1) {
            mensaje = mensaje + "\n" + contador0 + " Cafe Tradicional ";
        }

        if (contador1 >= 1) {
            mensaje = mensaje + "\n" + contador1 + " Cappuchino ";
        }

        if (contador2 >= 1) {
            mensaje = mensaje + "\n" + contador2 + " Latte ";
        }

        if (contador3 >= 1) {
            mensaje = mensaje + "\n" + contador3 + " Desayuno ";
        }

        if (contador4 >= 1) {
            mensaje = mensaje + "\n" + contador4 + " Pasta ";
        }
        //se muestra un pequeño toast simulando procedo de pedido
        Toast.makeText(getApplicationContext(), "Procesando Pedido", Toast.LENGTH_SHORT).show();
        //selecciona forma de pago (efectivo o tarjeta)
        // solo permite selecionar 1 opcion
        if (((RadioButton) findViewById(R.id.pago_tarjeta)).isChecked()) {
            mensaje = mensaje + " \nformade pago: " + " tarjeta ";
            //se le recuerda al cliente mostra DPI
            Toast.makeText(getApplicationContext(), "Presentar DPI", Toast.LENGTH_LONG).show();
        }
        if (((RadioButton) findViewById(R.id.pago_efectivo)).isChecked()) {
            mensaje = mensaje + " \nformade pago: " + " Efectivo " + ((EditText) findViewById(R.id.cambio)).getText();
        }
        //cliente coloca tiempo estimado en llegar a traer su pedido
        if (((RadioButton) findViewById(R.id.button_recoger)).isChecked()) {
            mensaje = mensaje + "\nPasara a Recoger " + ((EditText) findViewById(R.id.tiempo)).getText() + "minutos";
        }
        //cliente coloca #Oficina al cual debe llevarse el pedido
        if (((RadioButton) findViewById(R.id.button_oficina)).isChecked()) {
            mensaje = mensaje + "\nPara llevar a Oficina " +  ((EditText) findViewById(R.id.oficina)).getText();
        }
        //suma de contadores + precios de menu (ultima actualizacion 5 agosto)
        total0 = contador0 * precio0;
        total1 = contador1 * precio1;
        total2 = contador2 * precio2;
        total3 = contador3 * precio3;
        total4 = contador4 * precio4;
        // suma de todos los contadores
        total = total0 + total1 + total2 + total3 + total4;
        //se agrega comentario del cliente
        mensaje = mensaje + "\n" + ((EditText) findViewById(R.id.ingreseComentario)).getText() + "\nSu total es de: Q." + total;
        // se visualiza pedido en mostrar_pedido ubicado en layout/pedido_main
        //TextView priceTextView = (TextView) findViewById(R.id.mostrar_pedido);
        //priceTextView.setText(mensaje);
        AlertDialog.Builder dialog  = new AlertDialog.Builder(view.getContext());
        dialog.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ordenar();
            }
        })
                .setMessage(mensaje)
                .setTitle("Su orden");
        Dialog dialogConstruido = dialog.create();
        dialogConstruido.show();
    }

    public void ordenar() {
        //al precionar ordenar se procede a agregar pedido a email, solicitando seleccionar correo electronico
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                //SE DEBE CAMBIAR CORREO ELECTRONICO A somoscafecasaz4tec@gmail.com
                "mailto", "somoscafecasaz4tec@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Orden");
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    /*** contador cafe tradicional*/
    public void pedirMascafe(View view) {
        if (contador0 == 50) {
            return;
        }
        contador0 = contador0 + 1;
        display0(contador0);
    }

    public void pedirMenoscafe(View view) {
        if (contador0 == 0) {
            return;
        }
        contador0 = contador0 - 1;
        display0(contador0);

    }
    /**TextView contadortextview = (TextView) findViewById(resultado0);
     contadortextview.setText(contador0 + " Cafe Tradicional");    } */

    /*** contador Cappuchino*/
    public void pedirMasCappuchino(View view) {
        contador1 = contador1 + 1;
        display1(contador1);

    }
    public void pedirMenosCappuchino(View view) {
        if (contador1 == 0) {
            return;
        }
        contador1 = contador1 - 1;
        display1(contador1);
    }

    /*** contador Latte*/
    public void pedirMaslatte(View view) {
        contador2 = contador2 + 1;
        display2(contador2);

    }
    public void pedirMenoslatte(View view) {
        if (contador2 == 0) {
            return;
        }
        contador2 = contador2 - 1;
        display2(contador2);
    }

    /*** contador Desayuno*/
    public void pedirMaspanino(View view) {
        if (contador3 == 50) {
            return;
        }
        contador3 = contador3 + 1;
        display3(contador3);
    }
    public void pedirMenospanino(View view) {
        if (contador3 == 0) {
            return;
        }
        contador3 = contador3 - 1;
        display3(contador3);
    }

    /*** contador Pasta*/
    public void pedirMaspasta(View view) {
        if (contador4 == 50) {
            return;
        }
        contador4 = contador4 + 1;
        display4(contador4);
         }
    public void pedirMenospasta(View view) {
        if (contador4 == 0) {
            return;
        }
        contador4 = contador4 - 1;
        display4(contador4);
    }

    //se muestra el resultado individual de los contadores

    private void display0(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.resultado_cafe);
        quantityTextView.setText(" " + number);
    }

    private void display1(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.resultado_Cappuchino);
        quantityTextView.setText(" " + number);
    }

    private void display2(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.resultado_latte);
        quantityTextView.setText(" " + number);
    }

    private void display3(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.resultado_panino);
        quantityTextView.setText(" " + number);
    }

    private void display4(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.resultado_pasta);
        quantityTextView.setText(" " + number);
    }
}
