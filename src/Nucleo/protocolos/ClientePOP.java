/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nucleo.protocolos;

import Nucleo.utilidades.Constantes;
import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;


public class ClientePOP {

    public static String[] readMail() {
        String resultado[] = new String[4];
        try {
            // connect to my pop3 inbox in read-only mode
            Properties properties = System.getProperties();
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("pop3");
            store.connect(Constantes.MAIL_SERVER_HOST, Constantes.MAIL_USER, Constantes.MAIL_PASSWORD);
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);

            // search for all "unseen" messages
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            Message messages[] = inbox.search(unseenFlagTerm);

            if (messages.length == 0) {
                System.out.println("No se han encontrado mensajes.");
                return null;
            }
            System.out.println("SUBJECT: " + messages[0].getSubject());
            resultado[0] = messages[0].getSubject();
            String dest = messages[0].getFrom()[0].toString();
            int a = dest.indexOf("<");
            int b = dest.indexOf(">");
            resultado[1] = dest.substring(a+1, b);
//            resultado[1] = dest;
            String file = getTextFromMessage(messages[0]);
            if (!file.isEmpty()) {
                String str[] = file.split("---");
                resultado[2] = str[0];
                resultado[3] = str[1];
            }
            messages[0].setFlag(Flags.Flag.DELETED, true);
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            System.out.println("ERROR EL MENSAJE FUE CAPTURADO");
            System.out.println(e.getMessage());
            System.out.println(e);
            return null;
        }
        return resultado;
    }
  

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.getContent() instanceof MimeMultipart) {
                result = getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            } else if (bodyPart.isMimeType("image/*")) {
                String name = bodyPart.getFileName();
                String ext = "";
                boolean image = true;
                if (name.contains("jpg") || name.contains("JPG")) {
                    ext = "jpg";
                }
                if (name.contains("png") || name.contains("PNG")) {
                    ext = "png";
                }

                if (bodyPart.getContent() instanceof com.sun.mail.util.BASE64DecoderStream) {
                    result = "archivos/imagenes/image" + new Date().getTime() + "." + ext;
                    File f = new File(result);
                    System.out.println("Leyendo Imagen......");
                    DataOutputStream output = new DataOutputStream(
                            new BufferedOutputStream(new FileOutputStream(f)));
                    com.sun.mail.util.BASE64DecoderStream test
                            = (com.sun.mail.util.BASE64DecoderStream) bodyPart
                                    .getContent();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = test.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    output.close();
                    System.out.println("Imagen procesada!!");
                    result += "---image";
                }

            } else if (bodyPart.isMimeType("video/*")) {
                String name = bodyPart.getFileName();
                String ext = "";
                if (name.contains("mkv") || name.contains("MKV")) {
                    ext = "mkv";
                }
                if (name.contains("mp4") || name.contains("MP4")) {
                    ext = "mp4";
                }

                if (bodyPart.getContent() instanceof com.sun.mail.util.BASE64DecoderStream) {
                    result = "archivos/videos/video" + new Date().getTime() + "." + ext;
                    File f = new File(result);
                    System.out.println("Leyendo Video......");
                    DataOutputStream output = new DataOutputStream(
                            new BufferedOutputStream(new FileOutputStream(f)));
                    com.sun.mail.util.BASE64DecoderStream test
                            = (com.sun.mail.util.BASE64DecoderStream) bodyPart
                                    .getContent();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = test.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    output.close();
                    System.out.println("Video Procesado");
                    result += "---video";
                }
            }
        }
        return result;
    }

    public static boolean verifyInbox() {
        boolean sw = false;
        String result = null;
        BufferedReader reader;
        DataOutputStream writer;
        String command;

        try {
            // Estableciendo Connections Socket
            Socket socket = new Socket(Constantes.MAIL_SERVER_HOST, 110);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

            if (socket != null && reader != null && writer != null) {
                reader.readLine();
                // Autenticando DUsuario
                command = "USER " + Constantes.MAIL_USER + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                command = "PASS " + Constantes.MAIL_PASSWORD + "\r\n";
                writer.writeBytes(command);
                reader.readLine();

                // Listar los correos 5
                command = "LIST \r\n";
                writer.writeBytes(command);
                // Revisar si hay correos
                char cant = reader.readLine().charAt(4);
                System.out.println("MENSAJES: " );
                getMultiline(reader);
                if (cant != '0') { // Hay mensajes
                   sw = true;
                }

                command = "QUIT\r\n";
                writer.writeBytes(command);
                reader.readLine();
            }

            // Cerrar Connections
            writer.close();
            reader.close();
            socket.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return sw;
    }
    
    static protected String getMultiline(BufferedReader in) throws IOException {
        String lines = "";
        while (true) {
            String line = in.readLine();
            if (line == null) {
                // Server closed connection
                throw new IOException(" S : Server unawares closed the connection.");
            }
            if (line.equals(".")) {
                // No more lines in the server response
                break;
            }
            if ((line.length() > 0) && (line.charAt(0) == '.')) {
                // The line starts with a "." - strip it off.
                line = line.substring(1);
            }
            // Add read line to the list of lines
            lines = lines + "\n" + line;
        }
        return lines;
    }
}
