package com.francescodisalesgithub.catinthebox.service;

import com.francescodisalesgithub.catinthebox.model.InstalledQemu;
import com.francescodisalesgithub.catinthebox.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;

@Service
public class InstalledService
{

    private String [] applications = {"qemu-img","qemu-system-x86_64","qemu-system-x86"};

    @Autowired
    Security security;

    public InstalledQemu checkInstallation(String application)
    {
        boolean installed = false;
        boolean inAcceptableApplications = false;

        security.isPathInjection("/usr/bin/"+application);
        InstalledQemu installedQemu = new InstalledQemu();

        if(!security.isSecured())
        {
            installedQemu.setInstalled(installed);
        }

        for(String applicationItem : applications)
        {
            if (application.equals(applicationItem))
            {
                inAcceptableApplications = true;
                break;
            }
        }

        if(inAcceptableApplications)
        {
            File qemuFilePath = new File("/usr/bin/"+application);

            if(qemuFilePath.exists())
                installed = true;

            installedQemu.setInstalled(installed);
        }

        return installedQemu;
    }

    public InstalledQemu checkQemuImgInstallation()
    {

        File qemuImgFile = new File("/usr/bin/qemu-img");
        boolean exists = false;

        if(qemuImgFile.exists())
            exists = true;

        InstalledQemu installedQemu = new InstalledQemu();
        installedQemu.setInstalled(exists);

        return installedQemu;
    }


}
