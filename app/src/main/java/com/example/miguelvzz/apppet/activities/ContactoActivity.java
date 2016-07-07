package com.example.miguelvzz.apppet.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miguelvzz.apppet.R;
import com.example.miguelvzz.apppet.mail.EnviarMail;
import com.example.miguelvzz.apppet.mail.SendMail;

public class ContactoActivity extends AppCompatActivity {

    private Button btn_envia;
    private EditText et_nombre;
    private EditText et_email;
    private EditText et_comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_email = (EditText) findViewById(R.id.et_email);
        et_comentario = (EditText) findViewById(R.id.et_comentario);


        btn_envia = (Button) findViewById(R.id.btn_envia);
        btn_envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = et_email.getText().toString();
                String message = et_comentario.getText().toString();

                EnviarMail mail = new EnviarMail(email, message);
                mail.enviar();
                //sendEmail();
            }
        });

    }

    private void sendEmail() {
        //Getting content for email
        String email = et_email.getText().toString().trim();
        String subject = et_nombre.getText().toString().trim();
        String message = et_comentario.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();

        Toast.makeText(getBaseContext(), "Mensaje Enviado", Toast.LENGTH_SHORT).show();
    }
}
