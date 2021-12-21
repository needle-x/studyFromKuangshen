package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("小妹你好");
        mailMessage.setText("Be Stronger!");
        mailMessage.setTo("1472233788@qq.com");
        mailMessage.setFrom("1472233788@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        //正文
        helper.setSubject("小妹你好plus");
        helper.setText("<p style='color:red'>Be Happy!</p>",true);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));

        helper.setTo("1472233788@qq.com");
        helper.setFrom("1472233788@qq.com");

        mailSender.send(mimeMessage);
    }

    /**
     *
     * @param html
     * @param subject
     * @param text
     * @throws MessagingException
     * @Author needle
     */
    /*public void sendMail(Boolean html, String subject, String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,html);

        //正文
        helper.setSubject(subject);
        helper.setText(text,html);

        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Desktop\\1.jpg"));

        helper.setTo("1472233788@qq.com");
        helper.setFrom("1472233788@qq.com");

        mailSender.send(mimeMessage);
    }*/

}
