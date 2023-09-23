package com.francescodisalesgithub.catinthebox.model;

public class SecurityPathModel
{
    private String securityMessage;
    private boolean secured;


    public void setSecurityMessage(String securityMessage) {
        this.securityMessage = securityMessage;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public String getSecurityMessage() {
        return securityMessage;
    }

    public boolean isSecured() {
        return secured;
    }
}
