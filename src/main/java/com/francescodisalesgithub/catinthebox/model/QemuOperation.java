package com.francescodisalesgithub.catinthebox.model;

public class QemuOperation
{

    private String operation;
    private String status;

    private String error;

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }



    public String getOperation() {
        return operation;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
