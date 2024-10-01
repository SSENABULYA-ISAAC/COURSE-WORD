// package Class;

// import java.net.Authenticator;
// import java.net.PasswordAuthentication;
// import java.util.Properties;
// import javax.mail.*;
// import javax.mail.internet.*;

// import com.mysql.cj.protocol.Message;
// import com.mysql.cj.xdevapi.Session;

// public class JavaMailAPI {
//     public static void sendEmail(int orderID, String status) {
//         String to = "user@example.com"; // Change to user's email
//         String from = "admin@example.com";
//         String host = "smtp.example.com"; // Change to your SMTP server

//         Properties properties = System.getProperties();
//         properties.setProperty("mail.smtp.host", host);
//         properties.setProperty("mail.smtp.port", "587"); // Change to your SMTP port
//         properties.setProperty("mail.smtp.auth", "true");
//         properties.setProperty("mail.smtp.starttls.enable", "true");

//         Session session = Session.getInstance(properties, new Authenticator() {
//             protected PasswordAuthentication getPasswordAuthentication() {
//                 return new PasswordAuthentication("your-email@example.com", "your-email-password"); // Change to your email and password
//             }
//         });

//         try {
//             MimeMessage message = new MimeMessage(session);
//             message.setFrom(new InternetAddress(from));
//             message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//             message.setSubject("Order Status Update");
//             message.setText("Your order with ID " + orderID + " is now " + status);

//             Transport.send(message);
//             System.out.println("Email sent successfully.");
//         } catch (MessagingException mex) {
//             mex.printStackTrace();
//         }
//     }
// }