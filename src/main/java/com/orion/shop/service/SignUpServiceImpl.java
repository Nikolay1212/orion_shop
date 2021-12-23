package com.orion.shop.service;

import com.orion.shop.form.SignUpForm;
import com.orion.shop.model.Account;
import com.orion.shop.model.Role;
import com.orion.shop.model.State;
import com.orion.shop.repo.AccountRepo;
import com.orion.shop.util.EmailUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.StringWriter;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    @Qualifier("forMailsFreemarkerConfiguration")
    private Configuration configuration;

    @Transactional
    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .confirmId(UUID.randomUUID().toString())
                .build();

        sendConfirmMail(account);
        accountRepo.save(account);
    }
    private void sendConfirmMail(Account account) {
        try {
            Template template = configuration.getTemplate("mails/confirm_mail.ftlh");
            Map<String, String> attributes = Collections.singletonMap("confirm_id", account.getConfirmId());
            StringWriter writer = new StringWriter();
            template.process(attributes, writer);
            emailUtil.sendEmail(writer.toString(), "Registration", account.getEmail());
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
