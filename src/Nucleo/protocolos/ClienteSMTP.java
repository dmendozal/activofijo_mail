/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.protocolos;

import Nucleo.utilidades.Constantes;
import java.io.*;
import java.net.*;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ClienteSMTP {

    private static final int PORT = 25; // SMTP

    public static void sendMail(String toMail, String subject, String content) {
        // Estableciendo variables
        BufferedReader reader;
        DataOutputStream writer;
        String command;

        try {
            // Estableciendo Connections Socket
            Socket socket = new Socket(Constantes.MAIL_SERVER_HOST, PORT);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

            if (socket != null && reader != null && writer != null) {
                reader.readLine();
                // Saludar al servidor
                command = "EHLO " + Constantes.MAIL_SERVER_HOST + "\r\n";
                writer.writeBytes(command);
                getMultiline(reader);

                command = "MAIL FROM : " + Constantes.MAIL_USERMAIL + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                command = "RCPT TO : " + toMail + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                // Escribir Mensaje
                command = "DATA\n";
                writer.writeBytes(command);
                getMultiline(reader);

                command = "Subject: " + subject + "\r\n" + content + "\n.\r\n";
                writer.writeBytes(command);
                reader.readLine();

                command = "QUIT\r\n";
                writer.writeBytes(command);
                reader.readLine();
            }

            // Cerrar Connections
            System.out.println("Se ha enviado un correo de respuesta");
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException(" S : Server unawares closed the connection.");
            }
            if (line.charAt(3) == ' ') {
                lines = lines + "\n" + line;
                // No more lines in the server response
                break;
            }
            // Add read line to the list of lines
            lines = lines + "\n" + line;
        }
        return lines;
    }
    
    public static void sendMailHTML(String toMail, String subject, String content) {
        String to = toMail;
        String from = Constantes.MAIL_USERMAIL;
        final String username = Constantes.MAIL_USER;//change accordingly
        final String password = Constantes.MAIL_PASSWORD;//change accordingly

        Properties props = new Properties();
        props.put("mail.smtp.auth", "false");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", Constantes.MAIL_SERVER_HOST);
        props.put("mail.smtp.port", PORT);
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // Set Subject: header field

            // Create the message part
            message.setContent(content, "text/html");
            message.setSubject(subject);
            
            Transport.send(message);
            System.out.println("Se ha enviado un correo de respuesta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        String remitente = Constantes.MAIL_USERMAIL;  //Para la dirección nomcuenta@gmail.com
        String clave = Constantes.MAIL_PASSWORD;

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", ""); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
}
