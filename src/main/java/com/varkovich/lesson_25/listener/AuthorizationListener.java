package com.varkovich.lesson_25.listener;

import com.varkovich.lesson_25.logger.Logger;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AuthorizationListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (event.getName().equals("login")) {
            Logger.logInfo("User with login: '" + event.getValue() + "' has logged in.");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if (event.getName().equals("login")) {
            Logger.logInfo("User with login: '" + event.getValue() + "' has logged out.");
        }
    }
}
