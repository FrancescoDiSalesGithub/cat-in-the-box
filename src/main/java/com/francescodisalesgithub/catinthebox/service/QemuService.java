package com.francescodisalesgithub.catinthebox.service;

import com.francescodisalesgithub.catinthebox.model.QemuMachine;
import com.francescodisalesgithub.catinthebox.model.QemuOperation;
import com.francescodisalesgithub.catinthebox.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            security.isPathInjection(qemuMachine.getPath());

            if(security.isSecured())
            {
                qemuOperation.setOperation("create");
                qemuOperation.setStatus("OK");
                qemuOperation.setError(null);
            }
            else
            {
                qemuOperation.setOperation("create");
                qemuOperation.setStatus("KO");
                qemuOperation.setError(null);
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
