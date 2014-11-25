
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    // Representa el servidor asociado con ese cliente.
    private MailServer server;
    // Representa la dirección de correo del usuario que usa ese cliente.
    private String user;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer servidor, String usuario)
    {
       server = servidor;
       user = usuario;
    }

    /**
     * Devuelve del servidor el siguiente correo que tenga el usuario. 
     */
    public MailItem getNextMailItem()
    {
      return server.getNextMailItem(user);
    }
    
    /**
     * Devuelve del servidor el siguiente correo e imprime los datos de dicho mensaje.
     */
    public void printNextMailItem()
    {
        MailItem item;
        item = server.getNextMailItem(user);
        if (item == null) {
            System.out.println("No hay mensajes nuevos");
        }
        else {
            item.printMail();
        }
    }
    
    /**
     * Envía un mensaje a un usuario dado.
     */
    public void sendMailItem(String para, String mensaje)
    {
        MailItem mensaje1;
        mensaje1 = new MailItem(user, para, mensaje);
        server.post(mensaje1);
    }
}
        
