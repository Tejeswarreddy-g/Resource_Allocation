package com.resourceallocation.service;

import com.resourceallocation.model.Resource;
import com.resourceallocation.repository.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class ResourceServiceTest {

    private ResourceRepository repository;
    private ResourceService service;

    @BeforeEach
    void setUp() {
        repository = mock(ResourceRepository.class); // Mock the repository
        service = new ResourceService(repository); // Inject mock into service
    }

    @Test
    void testGetMicroserviceResources() {
    	List<Resource> mockResources = List.of(
    		    new Resource(2L, "Thompson", 7, new HashSet<>(Set.of("Java", "Oracle", "React", "Angular", "Javascript", "REST API", "Redis"))),
    		    new Resource(6L, "Kumar", 3, new HashSet<>(Set.of("Java", "Redis", "Mysql", "Javascript")))
    		);

//        when(repository.findBySkillsIn(List.of("Java", "Redis", "Javascript"))).thenReturn(mockResources);
        
        List<String> skills = List.of("Java", "Redis", "Javascript");
        int skillSize = skills.size();  

        when(repository.findBySkillsIn(skills, skillSize)).thenReturn(mockResources);


        List<Resource> result = service.getResourcesForMicroserviceProject(List.of("Java", "Redis", "Javascript"));

        assertEquals(2, result.size());
        assertEquals("Thompson", result.get(0).getName());
        assertEquals("Kumar", result.get(1).getName());
    }

    @Test
    void testGetCloudProjectResources() {
    	List<Resource> mockResources = List.of(
    		    new Resource(4L, "Aisha", 9, new HashSet<>(Set.of("Angular", "Javascript", "Nodejs", "Rest API", 
    		        "Web services", "Docker", "SQL", "Server", "PostgreSQL", "Mysql", "Spring", "React"))),
    		    
    		    new Resource(1L, "Dennis", 4, new HashSet<>(Set.of("Java", "Spring", "JMS", "Mysql", "Angular", 
    		        "React", "Web services", "Nodejs", "Docker")))
    		);

//        when(repository.findBySkillsInAndExperienceLessThan(List.of("Mysql", "Docker", "Spring", "React"), 10))
//                .thenReturn(mockResources);
        
        List<String> skills = List.of("Mysql", "Docker", "Spring", "React");
        int skillSize = skills.size();  // Dynamically calculate skill size
        int maxExperience = 10; // Make experience dynamic

        when(repository.findBySkillsInAndExperienceLessThan(skills, skillSize, maxExperience))
                .thenReturn(mockResources);


        List<Resource> result = service.getResourcesForCloudProject(List.of("Mysql", "Docker", "Spring", "React"), 10);

        assertEquals(2, result.size());
        assertEquals("Aisha", result.get(0).getName());
        assertEquals("Dennis", result.get(1).getName());
    }
}
