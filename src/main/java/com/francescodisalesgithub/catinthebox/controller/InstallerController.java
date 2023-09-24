package com.francescodisalesgithub.catinthebox.controller;

import com.francescodisalesgithub.catinthebox.model.InstalledQemu;
import com.francescodisalesgithub.catinthebox.service.InstalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstallerController
{

    @Autowired
    InstalledService installedService;

    @GetMapping("/qemu/installed")
    public InstalledQemu installationQemu(@RequestParam String application)
    {
        return installedService.checkInstallation(application);
    }

}
