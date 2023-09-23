package com.francescodisalesgithub.catinthebox.utils;

import com.francescodisalesgithub.catinthebox.model.SecurityPathModel;
import org.springframework.stereotype.Component;


@Component
public class Security
{

    private String securityMessage;
    private boolean secured;


    public void isPathInjection(String path)
    {


        try
        {
                if(path.contains("../"))
                {
                    this.securityMessage = "Security - path is not fine";
                    this.secured = false;
                }
                else
                {
                    this.securityMessage = "Security - path is fine";
                    this.secured = true;
                }
        }
        catch (NullPointerException nullPointerException)
        {
            this.securityMessage = "Exception occurred the path given is null";
            this.secured = false;

        }

    }

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
