
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
    //Guarda el último correo recibido.
    private MailItem savedMail;
    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(MailServer server, String user)
    {
       this.server = server;
       this.user = user;
       savedMail = null;
    }

    /**
     * Devuelve del servidor el siguiente correo que tenga el usuario, en caso de no haber correos 
     * devuelve null.
     */
    public MailItem getNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null) {
            savedMail = email;
        }
        return email;
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
            //Aquí van las comprobaciones de si un email es spam.
            boolean isSpam = false;
            String message = email.getMessage();
            if ((message.contains("oferta") || message.contains("viagra")) && !message.contains("proyecto")){
                //Seguramente es spam.
                isSpam = true;
                }
                
            if (isSpam) {
                //Cosas que hacer si es spam.
                email = null;
            }
            else {
                //Cosas que hacer si no es spam.
                savedMail = email;
            }
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
    
    /**Método que imprime por pantalla los mensajes que tiene
     * el usuario que está utilizando el cliente.
     */
    public void howManyMails()
    {
        System.out.println("Número de emails en el servidor: " + server.howManyMailItems(user));
    }
    
    /**
     * Método que descarga un email y lo responde automáticamente
     * con un mensaje predefinido.
     */
    public void getNextMailItemAutoRespond()
    {
        MailItem email = server.getNextMailItem(user);
        if (email != null) {
            String newTo = email.getFrom();
            String newSubject = "RE: " + email.getSubject();
            String newMessage = "Estamos de vacaciones.\n" + email.getMessage();
            MailItem newMail = new MailItem(user, newTo, newSubject, newMessage);
            server.post(newMail);
        }
    }
    
    /**
     * Método que permite que podamos ver por pantalla cuantas veces queramos
     * los datos del último mensaje recibido.
     */
    public void printLastMailItem()
    {
        if (savedMail != null) {
            savedMail.print();
        }
        else {
            System.out.println("No hay mensajes nuevos");
        }
    }
}

        
