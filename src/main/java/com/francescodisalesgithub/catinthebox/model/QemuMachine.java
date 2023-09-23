package com.francescodisalesgithub.catinthebox.model;

public class QemuMachine
{

    private String machineId;

    private String name;
    private String path;

    private QemuHardDrive drive;


    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public void setDrive(QemuHardDrive drive) {
        this.drive = drive;
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

    public QemuHardDrive getDrive() {
        return drive;
    }
}
