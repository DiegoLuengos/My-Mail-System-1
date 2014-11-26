
/**
 * Esta clase representa un mensaje de email.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // El que envía el mensaje.
    private String from;
    // El que lo recibe.
    private String to;
    // El mensaje.
    private String message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from, String to, String message)
    {
         this.from = from;
         this.to = to;
         this.message = message;
    }

    /**
     * Devuelve el nombre de la persona que ha enviado el mensaje.
     */
    public String getFrom()
    {
        return from;
    }
    
    /**
     * Devuelve el nombre de la persona que ha recibido el mensaje.
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * Devuelve el contenido del mensaje.
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Imprime en la pantalla los datos del email:
     * dirección de origen, dirección de destino y contenido.
     */
    public void print()
    {
        System.out.println("De: " + from);
        System.out.println("Para: " + to);
        System.out.println("Mensaje: " + message);
    }
}
