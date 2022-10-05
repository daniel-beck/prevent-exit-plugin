# Prevent Exit

## Introduction

This plugin installs a security manager that allows every operation except for `System#exit`, `Runtime#exit`, `Runtime#halt`, and similar methods that exit the current process.
This can be useful to troubleshoot issues resulting from poorly written, unsandboxed pipelines and libraries.

Important: This plugin does not improve the security of Jenkins. Users with access to the script console and similar features can remove or disable this security manager and shut down Jenkins that way.

## Getting started

The security manager gets installed when the plugin is loaded, replacing any previously set security manager.
By default, a message including stack trace is logged at attempts to exit the Jenkins controller process, and a `SecurityException` is thrown.

To not prevent the JVM from exiting, set the Java system property `io.jenkins.plugins.preventexit.PreventExitSecurityManager.DISABLE` to `true` on startup.
While this flag is set, only a message is logged, but the attempt to shut down Jenkins succeeds.

While Jenkins is already running, the plugin behavior can be configured by setting the static field `io.jenkins.plugins.preventexit.PreventExitSecurityManager.DISABLE` to `true` in the script console.

## Contributing

Refer to our [contribution guidelines](https://github.com/jenkinsci/.github/blob/master/CONTRIBUTING.md)

## LICENSE

Licensed under MIT, see [LICENSE](LICENSE.md)

