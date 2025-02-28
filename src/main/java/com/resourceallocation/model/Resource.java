package com.resourceallocation.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "resource_skills", joinColumns = @JoinColumn(name = "resource_id"))
    @Column(name = "skill")
    private Set<String> skills = new HashSet<>();
    
  
    public Resource() {
        super();
    }

    public Resource(Long id, String name, int experience, Set<String> skills) {
        super();
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
}
