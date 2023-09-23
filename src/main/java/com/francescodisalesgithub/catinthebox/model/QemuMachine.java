package com.francescodisalesgithub.catinthebox.model;

public class QemuMachine
{

    private String machineId;

    private String name;
    private String path;


    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getMachineId() {
        return machineId;
    }
}
