
/**
 * Representa un cliente de correo electrónico.
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
    public MailClient(MailServer server, String user)
    {
       this.server = server;
       this.user = user;
    }

    /**
     * Devuelve del servidor el siguiente correo que tenga el usuario. 
     */
    public MailItem getNextMailItem()
    {
      return server.getNextMailItem(user);
      
    }
    
    /**
     * Obtiene del servidor el siguiente correo del usuario
     * y lo imprime en la pantalla. Si no había correos en el
     * servidor informa de ello.
     */
    public void printNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if (email == null) {
            System.out.println("No hay mensajes nuevos");
        }
        else {
            email.print();
        }
    }
    
    /**
     * Envía un mensaje a un usuario dado con el contenido pasado por parámetro.
     */
    public void sendMailItem(String address, String subject, String message)
    {
        MailItem emailToSend = new MailItem(user, address, subject, message);
        server.post(emailToSend);
    }
    
    /**Devuelve la cantidad de correos que hay en el servidor para
     * ese cliente y lo imprime en la pantalla.
     */
    public int howManyMails()
    {
        System.out.println("Tienes" + server.howManyMailItems(user) + "mensajes nuevos");
        return server.howManyMailItems(user);
    }
}
        
