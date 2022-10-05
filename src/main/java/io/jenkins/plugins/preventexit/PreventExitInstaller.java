package io.jenkins.plugins.preventexit;

import hudson.init.Initializer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreventExitInstaller {
    private static final Logger LOGGER = Logger.getLogger(PreventExitInstaller.class.getName());

    @Initializer
    public static void install() {
        final SecurityManager current = System.getSecurityManager();
        if (current == null) {
            LOGGER.log(Level.INFO, "Installing security manager");
            System.setSecurityManager(new PreventExitSecurityManager());
        } else {
            LOGGER.log(Level.INFO, "Replacing security manager " + current);
            System.setSecurityManager(new PreventExitSecurityManager());
        }
    }
}
