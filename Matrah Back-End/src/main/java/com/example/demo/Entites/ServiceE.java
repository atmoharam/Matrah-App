package com.example.demo.Entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Services")
@Table(name = "Services", indexes = {
        @Index(name = "idx_services_name",columnList = "name")
})
public class ServiceE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private int id;

    @Column(name = "name")
    private String name;

        @ManyToMany(mappedBy = "services")
    private Set<Venue> venues;

    public Set<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }

    public ServiceE() {
    }

    public ServiceE(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceE{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
