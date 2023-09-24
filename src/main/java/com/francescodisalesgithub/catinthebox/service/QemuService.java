package com.francescodisalesgithub.catinthebox.service;

import com.francescodisalesgithub.catinthebox.model.InstalledQemu;
import com.francescodisalesgithub.catinthebox.model.QemuMachine;
import com.francescodisalesgithub.catinthebox.model.QemuOperation;
import com.francescodisalesgithub.catinthebox.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystem;

@Service
public class QemuService
{

    @Autowired
    Security security;

    public QemuOperation createMachine(QemuMachine qemuMachine)
    {
        QemuOperation qemuOperation = new QemuOperation();

        try
        {
            RestTemplate restTemplate = new RestTemplate();
            String urlInstallation = "http://localhost:6543/qemu/installed?application=qemu-system-x86_64";
            URI uriInstallation = new URI(urlInstallation);
            InstalledQemu responseInstallation = restTemplate.getForObject(uriInstallation, InstalledQemu.class);

            assert responseInstallation != null;
            if(responseInstallation.isInstalled())
            {
                security.isPathInjection(qemuMachine.getPath());

                if(security.isSecured())
                {
                    if(qemuMachine.getDrive() != null)
                    {
                        File directoryMachine = new File(qemuMachine.getPath()+"/"+qemuMachine.getName());

                        if(directoryMachine.isDirectory() && !directoryMachine.exists())
                        {
                            directoryMachine.mkdir();
                        }
                        else
                        {
                            qemuOperation.setOperation("create");
                            qemuOperation.setStatus("KO");
                            qemuOperation.setError("A virtual machine with the given name already exists.");
                            return  qemuOperation;
                        }

                        qemuOperation.setOperation("create");
                        qemuOperation.setStatus("OK");
                        qemuOperation.setError(null);
                    }
                    else
                    {
                        qemuOperation.setOperation("create");
                        qemuOperation.setStatus("KO");
                        qemuOperation.setError("Hard-drive parameter not present");
                        return  qemuOperation;
                    }


                }
                else
                {
                    qemuOperation.setOperation("create");
                    qemuOperation.setStatus("KO");
                    qemuOperation.setError("An invalid operation was done");
                }
            }
            else
            {
                qemuOperation.setOperation("create");
                qemuOperation.setStatus("KO");
                qemuOperation.setError("application qemu is not installed");
            }


        }
        catch (Exception e)
        {
            qemuOperation.setOperation("create");
            qemuOperation.setStatus("KO");
            qemuOperation.setError(e.getMessage());
        }

        return qemuOperation;
    }

    public void updateMachine(QemuMachine qemuMachine)
    {

    }

    public void deleteMachine(QemuMachine qemuMachine)
    {

    }

    public void run()
    {

    }

    public void status(String machineId)
    {
    }
}
