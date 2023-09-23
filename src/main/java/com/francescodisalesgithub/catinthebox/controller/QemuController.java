package com.francescodisalesgithub.catinthebox.controller;


import com.francescodisalesgithub.catinthebox.model.QemuMachine;
import com.francescodisalesgithub.catinthebox.model.QemuOperation;
import com.francescodisalesgithub.catinthebox.service.QemuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class QemuController
{

    @Autowired
    private QemuService qemuService;

    @PostMapping("/qemu/create")
    public QemuOperation createMachine(@RequestBody QemuMachine qemuMachine)
    {
        return qemuService.createMachine(qemuMachine);
    }

    @PostMapping("/qemu/update")
    public void updateMachine(@RequestBody QemuMachine qemuMachine)
    {
        qemuService.updateMachine(qemuMachine);
    }

    @PostMapping("/qemu/delete")
    public void deleteMachine(@RequestBody QemuMachine qemuMachine)
    {
        qemuService.deleteMachine(qemuMachine);
    }

    @PostMapping("/qemu/run")
    public void runMachine(@RequestBody QemuMachine qemuMachine)
    {
        qemuService.run();
    }

    @GetMapping("/qemu/status")
    public void statusMachine(@RequestParam String machineId)
    {
        qemuService.status(machineId);
    }


}
