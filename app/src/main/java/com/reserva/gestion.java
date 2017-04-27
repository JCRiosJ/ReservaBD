package com.reserva;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class gestion extends Activity {
    String id;
    String nombre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);
    }

    public void eliminar(View v)
    {
        EditText Enombre = (EditText) findViewById(R.id.txtNombre);
        TextView tvId = (TextView) findViewById(R.id.txtID);
        id = tvId.getText().toString();
        nombre = Enombre.getText().toString();
        AuxiliarSQL sql = new AuxiliarSQL(this,"DB_Restaurant", null, 1);
        // Ocupamos la base para escribir
        final SQLiteDatabase db = sql.getWritableDatabase();
        if(db != null){
            try{
                db.execSQL("delete from Reservacion where _id = '"+id+"' and nombre = '"+nombre+"';");
                Toast.makeText(getApplicationContext(),
                        "Usuario eliminado.",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e){
                Toast.makeText(getApplicationContext(),
                        "Error en delete " + e,
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),
                    "No existe la base de datos",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void editar (View v)
    {
        EditText Enombre = (EditText) findViewById(R.id.txtNombre);
        TextView tvId = (TextView) findViewById(R.id.txtID);
        id = tvId.getText().toString();
        nombre = Enombre.getText().toString();
        AuxiliarSQL sql = new AuxiliarSQL(this,"DB_Restaurant", null, 1);
        // Ocupamos la base para escribir
        final SQLiteDatabase db = sql.getWritableDatabase();
        if(db != null){
            try{
                db.execSQL("update Reservacion set nombre = '"+nombre+"' where _id = '"+id+";");
                Toast.makeText(getApplicationContext(),
                        "Usuario actualizado.",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e){
                Toast.makeText(getApplicationContext(),
                        "Error en update " + e,
                        Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(getApplicationContext(),
                    "No existe la base de datos",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void regresar(View v)
    {
        Intent intento = new Intent(this, MainActivity.class);
        finish();
        startActivity(intento);
    }
}
