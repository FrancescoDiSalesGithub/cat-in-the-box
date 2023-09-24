package com.francescodisalesgithub.catinthebox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstallerController
{

    @GetMapping("/qemu/installed")
    public boolean installationQemu(@RequestParam String installed)
    {
        if(installed.equalsIgnoreCase("true"))
            return true;

        return false;
    }

}
