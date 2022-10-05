package io.jenkins.plugins.preventexit;

import java.security.Permission;
import java.util.logging.Level;
import java.util.logging.Logger;
import jenkins.util.SystemProperties;

public class PreventExitSecurityManager extends SecurityManager {
    private static final Logger LOGGER = Logger.getLogger(PreventExitSecurityManager.class.getName());

    private static final String PROPERTY_NAME = PreventExitSecurityManager.class.getName() + ".DISABLE";

    private static /* non-final for Groovy */ boolean DISABLE = SystemProperties.getBoolean(PROPERTY_NAME);

    @Override
    public void checkExit(final int status) {
        if (DISABLE) {
            LOGGER.log(Level.INFO, new Exception(), () -> "Allowing exit with status " + status);
            return;
        }
        LOGGER.log(Level.INFO, new Exception(), () -> "Preventing exit with status " + status);
        throw new SecurityException("Preventing exit with status " + status);
    }

    @Override
    public void checkPermission(Permission perm) {
        /* no op to allow all otherwise */
    }
}
