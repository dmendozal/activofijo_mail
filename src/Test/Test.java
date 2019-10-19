package Test;

import Negocio.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Test {

    public static void main(String args[]) throws Exception {

        NEstado o = new NEstado();
        o.add("T15","TALLER");
        System.out.println(o.Mostrar());
//        o.update("T","TALLERES");
//        System.out.println(o.Mostrar());
//        o.delete("Tt");
//        System.out.println(o.Mostrar());

//        NOferta o = new NOferta();
//        o.add("MAESTRIA moto", "ESPECIALIDAD", 2500.0, "M");
//        System.out.println(o.Mostrar());
//        o.update(2, "MAESTRIA MECATRONICA", "MA",5000.0);
//        System.out.println(o.Mostrar());
//        o.delete(2);
//        System.out.println(o.Mostrar());


//        NDirigido d = new NDirigido();
//        d.add("Profesionales", 1);
//        d.add("Estudiantes", 1);
//        System.out.println(d.Mostrar());
//        d.update(2, "Estudiantes motivados");
//        System.out.println(d.Mostrar());
//        d.delete(4);
//        System.out.println(d.Mostrar());


//        NObjetivo o = new NObjetivo();
//        o.add("Profesionales", 1);
//        o.add("Estudiantes", 1);
//        System.out.println(o.Mostrar());
//        o.update(2, "Estudiantes motivados");
//        System.out.println(o.Mostrar());
//        o.delete(2);
//        System.out.println(o.Mostrar());


//        NMetodologia m = new NMetodologia();
//        m.add("Profesionales", 1);
//        m.add("Estudiantes", 1);
//        System.out.println(m.Mostrar());
//        m.update(5, "Estudiantes motivados");
//        System.out.println(m.Mostrar());
//        m.delete(5);
//        System.out.println(m.Mostrar());


//        NCronograma c = new NCronograma();
//        c.add("Profesionales s", "1/2018");
//        c.add("Estudiantes", "1/2018");
//        System.out.println(c.Mostrar());
//        c.update(3, "a","2/2018");
//        System.out.println(c.Mostrar());
//        c.delete(2);
//        System.out.println(c.Mostrar());

//        NCronograma_Detalle c = new NCronograma_Detalle();
//        c.add(1,1);
//        c.add(3,1);
//        System.out.println(c.Mostrar());
//        c.update(3, "a","2/2018");
//        System.out.println(c.Mostrar());
//        c.delete(4);
//        System.out.println(c.Mostrar());

//        NRequisito r = new NRequisito();
//        r.add("TITULADO",1);
//        r.add("BACHILELR",1);
//        r.add("BACHILELR",1);
//        System.out.println(r.Mostrar());
//        r.update(3, "NOSE");
//        System.out.println(r.Mostrar());
//        r.delete(3);
//        System.out.println(r.Mostrar());

//        NRol u = new NRol();
//        u.add("uu");
//        u.add("CLIENTE");
//        u.add("a");
//        System.out.println(u.Mostrar());
//        u.update(2,"aASDF");
//        System.out.println(u.Mostrar());
//        u.delete(3);
//        System.out.println(u.Mostrar());

//        NGrupo u = new NGrupo();
//        u.add("ADMINISTRADO", "ASDF", 1);
//        u.add("CLIENTE", "ASDF", 2);
//        u.add("a", "ASDF",1);
//        System.out.println(u.Mostrar());
//        u.update(3,"aas", "A");
//        System.out.println(u.Mostrar());
//        u.delete(3);
//        System.out.println(u.Mostrar());


//        NUsuario u = new NUsuario();
//        u.add("JUAN","asd@MAIL.COM","123456", 1, "ESTUDIANTE", "UAGRME", "789456", 1);
//        u.add("MARIA","aqas@MAIL.COM","123456", 2, "ESTUDIANTE", "UAGRME", "789456", 1);
//        u.add("NOSE","asas2@MAIL.COM","123456", 2, "ESTUDIANTE", "UAGRME", "789456", 1);
//        System.out.println(u.Mostrar());
//        u.update(9,"B","B@MAIL.COM","B", 4, "B", "B", "B");
//        System.out.println(u.Mostrar());
//        u.delete(9);
//        System.out.println(u.Mostrar());

//        NReserva re = new NReserva();
//        re.add("21/12/2018", "HOOA", 7, 1);
//        re.add("2S/12/2018", "QUIER", 8, 1);
//        System.out.println(re.Mostrar());
//        re.update(1, "25/s/2018", "xa");
//        System.out.println(re.Mostrar());
//        re.delete(4);
//        System.out.println(re.Mostrar());

//        NPago p = new NPago();
//        p.add(500.0, "DEPOSITO");
//        p.add(220.0, "DEPOSITO");
//        System.out.println(p.Mostrar());
//        p.update(3,1.0, "a");
//        System.out.println(p.Mostrar());
//        p.delete(3);
//        System.out.println(p.Mostrar());

//        NVenta v = new NVenta();
//        v.add(500.0, 7);
//        v.add(300.0, 8);
//        System.out.println(v.Mostrar());
//        v.update(2, 60.0);
//        System.out.println(v.Mostrar());
//        v.delete(3);
//        System.out.println(v.Mostrar());

//        NVenta_Detalle v = new NVenta_Detalle();
//        v.add("20/20/2013", 2,1, 1, 7);
//        v.add("20/20/2013", 2,1, 1, 7);
//        System.out.println(v.Mostrar());
//        v.update(2, "21/12/21015");
//        System.out.println(v.Mostrar());
//        v.delete(2);
//        System.out.println(v.Mostrar());

//        NBoleta b = new NBoleta();
//        b.add(500, 1);
//        b.add(500, 2);
//        System.out.println(b.Mostrar());
//        b.update(2, 100);
//        System.out.println(b.Mostrar());
//        b.delete(2);
//        System.out.println(b.Mostrar());

//        NPostgraduante_Oferta p = new NPostgraduante_Oferta();
//        p.add(7,1);
//        p.add(8,1);
//        System.out.println(p.Mostrar());
//        p.delete(2);
//        System.out.println(p.Mostrar());


//        NDocente_Oferta d = new NDocente_Oferta();
//        d.add(1, 8);
//        d.add(1, 7);
//        System.out.println(d.Mostrar());
//        d.delete(2);
//        System.out.println(d.Mostrar());



    }
}
