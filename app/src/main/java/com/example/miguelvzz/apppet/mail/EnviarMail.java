package com.example.miguelvzz.apppet.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Miguel Vzz on 28/06/2016.
 */
public class EnviarMail {

    private String host = "smtp.gmail.com";
    private String puerto = "587";
    private String mailDe = "miguelpruebas9@gmail.com";
    private String contraDe = "Cualquiera642";
    private String mailPara;
    private String asunto = "AppPet";
    private String mensaje;

    public EnviarMail(String mailPara, String mensaje) {
        this.mailPara = mailPara;
        this.mensaje = mensaje;
    }

    public void enviar() {
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", puerto);
            props.setProperty("mail.smtp.user", mailDe);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailDe));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(mailPara));
            message.setSubject(asunto);
            message.setText(mensaje);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(mailDe, contraDe);
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
