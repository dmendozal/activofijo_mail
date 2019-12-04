/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DActivo;
import Datos.DBien;
import Datos.DUbicacion;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 *
 * @author D-M-7
 */
public class NActivo {

    private DActivo o;

    public NActivo() throws Exception {
        this.o = new DActivo();
    }

    public DActivo getInfo() {
        return o;
    }

    public void add(String codigo, int fkidestado, int fkidbien, int fkidubicacion) throws Exception {
        try {
            String ubicacion = o.findUbicaion(fkidubicacion);
            ResultSet rx = o.consultarDatos(ubicacion);
            rx.next();
            this.GenerarQR(codigo, "" + rx.getObject(1), "" + rx.getObject(2));
            o.setCodigo(codigo);
            o.setFkidestado(fkidestado);
            o.setFkidbien(fkidbien);
            o.setFkidubicacion(fkidubicacion);
            o.setEstado(1);
            o.setQr("./src/Image/" + codigo + ".png");
            o.add();

        } catch (Exception e) {
            throw e;
        }
    }

    public void GenerarQR(String Codigo, String aula, String piso) throws WriterException, FileNotFoundException, IOException {
        int getTamaño = 150;
        int getAncho = 150;
        String formato = "png";
        String ruta = "./src/Image/" + Codigo + ".png";

        BitMatrix matriz = null;
        QRCodeWriter qr = new QRCodeWriter();

        matriz = qr.encode("Codigo del activo :" + Codigo + "\n" + "Aula :" + aula + "\n" + "piso :" + piso, BarcodeFormat.QR_CODE, getTamaño, getAncho);

        BufferedImage imagen = new BufferedImage(getTamaño, getAncho, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < getTamaño; i++) {
            for (int j = 0; j < getAncho; j++) {
                int valor = (matriz.get(i, j) ? 0 : 1) & 0xff;
                imagen.setRGB(i, j, (valor == 0 ? 0 : 0xFFFFFF));

            }
        }

        FileOutputStream codigo = new FileOutputStream(new File(ruta).getCanonicalFile());
        ImageIO.write(imagen, formato, codigo);
    }

    public String ConvertirBase64(String ruta) throws IOException {

        File file = new File(ruta).getCanonicalFile();
        BufferedInputStream bufferis = new BufferedInputStream(new FileInputStream(file));
        int bytes = (int) file.length();
        byte[] buffer = new byte[bytes];
        int readBytes = bufferis.read(buffer);
        bufferis.close();
        String encodedString = Base64.encode(buffer);
        return encodedString;
    }

    public void update(int id, String codigo, int fkidestado, int fkidbien, int fkidubicacion) throws Exception {
        try {
            o.setIdactivo(id);
            o.setCodigo(codigo);
            o.setFkidestado(fkidestado);
            o.setFkidbien(fkidbien);
            o.setFkidubicacion(fkidubicacion);
            o.update();
        } catch (Exception e) {
            throw e;
        }
    }

    public void delete(int id) throws Exception {
        try {
            o.setIdactivo(id);
            o.delete();
        } catch (Exception e) {
            throw e;
        }

    }

    private List<DActivo> getAll() throws Exception {
        List<DActivo> ob = new ArrayList<>();
        List<Object> lista = (List<Object>) this.o.getAll();
        try {
            for (Object objecto : lista) {
                List<Object> obj = (List<Object>) objecto;
                DActivo oo = new DActivo();
                oo.setIdactivo(Integer.valueOf(obj.get(0).toString()));
                oo.setCodigo(obj.get(1).toString());
                oo.setFkidestado(Integer.valueOf(obj.get(2).toString()));
                oo.setFkidbien(Integer.valueOf(obj.get(3).toString()));
                oo.setFkidubicacion(Integer.valueOf(obj.get(4).toString()));
                oo.setQr((obj.get(5).toString()));
                ob.add(oo);
            }
        } catch (Exception e) {
            throw e;
        }
        return ob;
    }


    public String ubicacionActivo() {
        String rx = "";

        return rx;

    }

    public String Mostrar() throws Exception {
        String rx = "";
        try {
            List<DActivo> lObj = this.getAll();

            rx = "<center><h2>LISTA DE ACTIVOS</h2></center><br>";
            rx += " <table style=\"width:100%; border-style: outset; text-align: left;\" >"
                    + "             <thead>\n"
                    + "                   <tr >\n"
                    + "                         <th>ID</th>\n"
                    + "                         <th>CODIGO</th>\n"
                    + "                         <th>ESTADO</th>\n"
                    + "                         <th>BIEN</th>\n"
                    + "                         <th>UBICACION</th>\n"
                    + "                         <th>QR</th>\n"
                    + "                   </tr>\n"
                    + "             </thead>\n"
                    + "                  <tbody> ";
            for (DActivo obj : lObj) {
                rx = rx
                        + "<tr style=\"\">\n"
                        + "   <td>" + obj.getIdactivo() + "</td>\n"
                        + "   <td>" + obj.getCodigo() + "</td>\n"
                        + "   <td>" + obj.getFkidestado() + "</td>\n"
                        + "   <td>" + obj.getFkidbien() + "</td>\n"
                        + "   <td>" + obj.getFkidubicacion() + "</td>\n"
                        + "   <td>" + "   <img src='"+"data:image/png;base64,"+this.ConvertirBase64(obj.getQr())+"'/>"+"</img>"+ "</td>\n"
                        + "</tr>\n";
            }
            rx += "  </tbody>\n"
                    + "</table>\n";
        } catch (Exception e) {
            throw e;
        }
        return rx;
    }
}
