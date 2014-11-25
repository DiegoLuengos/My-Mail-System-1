
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // El que envía el mensaje.
    private String From;
    // El que lo recibe.
    private String To;
    // El mensaje.
    private String Message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String de, String para, String mensaje)
    {
         From = de;
         To = para;
         Message = mensaje;
    }

    /**
     * Devuelve el nombre de la persona que ha enviado el mensaje.
     */
    public String getFrom()
    {
        return From;
    }
    
    /**
     * Devuelve el nombre de la persona que ha recibido el mensaje.
     */
    public String getTo()
    {
        return To;
    }
    
    /**
     * Devuelve el contenido del mensaje.
     */
    public String getMessage()
    {
        return Message;
    }
    
    /**
     * Imprime en la pantalla los atributos del objeto.
     */
    public void printMail()
    {
        System.out.println("De: " + From);
        System.out.println("Para: " + To);
        System.out.println("Mensaje: " + Message);
    }
}
