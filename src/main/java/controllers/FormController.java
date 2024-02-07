package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

    @Controller
    public class FormController {

        @Autowired
        private JavaMailSender emailSender;

        @PostMapping("/enviar-formulario")
        @ResponseBody
        public String enviarFormulario(
                @RequestParam String nombre,
                @RequestParam String apellidos,
                @RequestParam String telefono,
                @RequestParam String fechaNacimiento,
                @RequestParam String email,
                @RequestParam String comentarios) {

            // Aquí puedes realizar alguna lógica adicional si es necesario

            // Envío del correo electrónico
            enviarCorreo(email);

            return "¡Formulario enviado con éxito!";
        }

        private void enviarCorreo(String destinatario) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatario);
            message.setSubject("Gracias por tu formulario");
            message.setText("Hemos recibido tu formulario. Nos pondremos en contacto contigo pronto.");

            emailSender.send(message);
        }
    }

