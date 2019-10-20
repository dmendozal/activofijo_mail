package Email;

import Nucleo.procesador.Anacom;
import Nucleo.procesador.Token;
import Nucleo.protocolos.ClienteSMTP;

public abstract class TemplateMail {

    private boolean messageHelp(Anacom anacom, String email, String comandHelp) {
        anacom.Avanzar();
        Token token = anacom.Preanalisis();

        if (token.getNombre() == Token.HELP) {
//            ClienteSMTP.sendMail(email, "AYUDAS - MARKETING", comandHelp);
            ClienteSMTP.sendMailHTML(email, "AYUDAS - ACTIVOFIJOS", comandHelp);
            System.out.println(comandHelp);
            return true;
        }
        return false;
    }

    public void create(Anacom anacom, String email, String comandHelp) throws Exception {
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.insertar(anacom, email);
        String lista = this.listar();

        if (sw) {
            System.out.println("EXITO T INSERTAR: "+ this.messageCreate(sw));
            ClienteSMTP.sendMailHTML(email, "REGISTRO CON EXITO",  this.messageCreate(sw) + lista);

        }else{
            System.out.println("ERROR T INSERTAR: "+this.messageCreate(sw));
            ClienteSMTP.sendMailHTML(email, "REGISTRO SIN EXITO", this.messageCreate(sw) + lista);
        }
    }


    public void edit(Anacom anacom, String email, String comandHelp) throws Exception {
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.modificar(anacom, email);
        String lista = this.listar();
        if (sw) {
            System.out.println("EXITO T EDITAR: "+ this.messageEdit(sw));
            ClienteSMTP.sendMailHTML(email, "MODIFICACION CON EXITO", this.messageEdit(sw) + lista);
        }else{
            System.out.println("ERROR T EDITAR: "+this.messageEdit(sw));
            ClienteSMTP.sendMailHTML(email, "MODIFICACION SIN EXITO", this.messageEdit(sw) + lista);
        }
    }

    public void remove(Anacom anacom, String email, String comandHelp) throws Exception {
        if (messageHelp(anacom, email, comandHelp)) return;

        boolean sw = this.eliminar(anacom, email);
        String lista = this.listar();

        if (sw) {
            System.out.println("EXITO T ELIMINAR: "+ this.messageRemove(sw));
            ClienteSMTP.sendMailHTML(email, "ELIMINACION CON EXITO", messageRemove(sw) + lista);
        }else{
            System.out.println("ERROR T ELIMINAR: "+ this.messageRemove(sw));
            ClienteSMTP.sendMailHTML(email, "ELIMINACION CON EXITO", messageRemove(sw) + lista);
        }
    }

    public void findAll(Anacom anacom, String email, String comandHelp) throws Exception {
        if (messageHelp(anacom, email, comandHelp)) return;

        String lista = this.listar();

        if (lista.isEmpty()) {
            System.out.println("ERROR T LISTAR: "+this.messageFindAll(false));
//            ClienteSMTP.sendMail(email, "LISTADO CON EXITO", this.messageFindAll(false));
            ClienteSMTP.sendMailHTML(email, "LISTADO SIN EXITO", this.messageFindAll(false));
        }else{
            System.out.println("EXITO T LISTAR: "+ this.messageFindAll(true));
//            ClienteSMTP.sendMail(email, "LISTADO SIN EXITO", this.messageFindAll(true) + lista);
            ClienteSMTP.sendMailHTML(email, "LISTADO CON EXITO", this.messageFindAll(true) + lista);
        }
    }

    protected abstract boolean insertar(Anacom anacom, String correo) throws Exception;
    protected abstract boolean modificar(Anacom anacom, String correo) throws Exception;
    protected abstract boolean eliminar(Anacom anacom, String correo) throws Exception;
    protected abstract String listar() throws Exception;

    protected abstract String messageCreate(boolean sw);
    protected abstract String messageEdit(boolean sw);
    protected abstract String messageRemove(boolean sw);
    protected abstract String messageFindAll(boolean sw);

}
