package com.resourceallocation.controller;

import com.resourceallocation.model.Resource;
import com.resourceallocation.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/microservice")
    public List<Resource> getMicroserviceResources() {
        return resourceService.getResourcesForMicroserviceProject(Arrays.asList("Java", "Redis", "Javascript"));
    }

    @GetMapping("/cloud")
    public List<Resource> getCloudResources() {
        return resourceService.getResourcesForCloudProject(Arrays.asList("Mysql", "Docker", "Spring", "React"), 10);
    }
}
