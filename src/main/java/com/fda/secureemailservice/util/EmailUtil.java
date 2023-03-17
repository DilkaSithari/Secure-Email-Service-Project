package com.fda.secureemailservice.util;
import com.fda.secureemailservice.model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class EmailUtil {

    @Value("${spring.mail.host}")
    String mailHost;

    @Value("${spring.mail.port}")
    String mailPort;

    @Value("${spring.mail.username}")
    String mailUsername;

    @Value("${spring.mail.password}")
    String mailPassword;
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(){


        EmailDetails emailDetails = new EmailDetails();
        String from = mailUsername;
        String to = "sitharidilka@gmail.com" ;

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("This is a plain text email");
        message.setText("Hello guys! This is a plain text email.");
        mailSender.send(message);
    }
    @GetMapping( "/sendemail")
    public String sendmail()    {
        sendEmail();
        return "Email sent successfully";
    }

//    public void sendmail() throws MessagingException {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth","true");
//   props.put("mail.smtp.starttls.enable","true");
//   props.put("mail.smtp.host","smtp.gmail.com");
//   props.put("mail.smtp.port","587");
//    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//        protected PasswordAuthentication getPasswordAuthentication() {
//            return new PasswordAuthentication("dilkasithari255@gmail.com", "aoragjcfhntmjwfu");
//        }
//    });
//    Message msg = new MimeMessage(session);
//   msg.setFrom(new InternetAddress("dilkasithari255@gmail.com",false));
//
//   msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("sitharidilka@gmail.com"));
//   msg.setSubject("subject");
//   msg.setContent("Email content","text/html");
//   msg.setSentDate(new Date());
//
//    MimeBodyPart messageBodyPart = new MimeBodyPart();
//   messageBodyPart.setContent("Tutorials point email","text/html");
//   Transport.send(msg);
//}
//    @RequestMapping(value = "/sendemail")
//    public String sendEmail() throws  MessagingException {
//        sendmail();
//        return "Email sent successfully";
//    }



}




