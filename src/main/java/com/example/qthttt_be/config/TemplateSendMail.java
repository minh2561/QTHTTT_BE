//package com.example.qthttt_be.config;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class TemplateSendMail {
//    @Autowired
//    private JavaMailSender emailSender;
//
//    private interface TemplateMessage {
//        String SUBJECT = "TEST";
//        String MESSAGE_SEND_OTP = "TEST ";
//    }
//
//    @KafkaListener(topics = "SEND_MAIL", groupId = "GROUP_ID", autoStartup = "${spring.kafka.streams.auto-startup}")
//    private void consumerOTPMail(@NonNull String data) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode jsonNode = mapper.readTree(data);
//            String email = jsonNode.get("email").toString();
//            Integer otp = jsonNode.get("otp").asInt();
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setTo(email);
//            message.setSubject(TemplateMessage.SUBJECT);
//            message.setText(TemplateMessage.MESSAGE_SEND_OTP + otp);
//            emailSender.send(message);
//        } catch (JsonProcessingException e) {
//            log.error("Error json process {}", e.getMessage());
//        } catch (Exception e) {
//            log.error("Error send mail {}", e.getMessage());
//        }
//    }
//}