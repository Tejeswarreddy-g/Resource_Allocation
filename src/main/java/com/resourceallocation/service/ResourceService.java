package com.resourceallocation.service;

import com.resourceallocation.model.Resource;
import com.resourceallocation.repository.ResourceRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private static final Logger logger = LoggerFactory.getLogger(ResourceService.class);
   
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

//    public List<Resource> getResourcesForMicroserviceProject(List<String> skills) {
//        return resourceRepository.findBySkillsIn(skills);
//    }
    
    public List<Resource> getResourcesForMicroserviceProject(List<String> skills) {
    	logger.info("Fetching all resources:{}",skills);
        return resourceRepository.findBySkillsIn(skills, skills.size());
    }


//    public List<Resource> getResourcesForCloudProject(List<String> skills, int maxExperience) {
//        return resourceRepository.findBySkillsInAndExperienceLessThan(skills, maxExperience);
//    }
    
    public List<Resource> getResourcesForCloudProject(List<String> skills, int maxExperience) {
    	logger.info("Fetching all resources :{} and experience:{}",skills,maxExperience);
        return resourceRepository.findBySkillsInAndExperienceLessThan(skills, skills.size(), maxExperience);
    }

}
