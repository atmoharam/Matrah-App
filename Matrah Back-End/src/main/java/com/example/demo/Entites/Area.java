package com.example.demo.Entites;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Areas")
@Table(name = "Areas", indexes = {
        @Index(name = "idx_areas_name", columnList = "name"),
        @Index(name = "idx_areas_city_id", columnList = "city_id")
})
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "area" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Venue> venues;

    public Area() {
    }

    public Area(String name, City city) {
        this.name = name;
        this.city = city;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                '}';
    }
}
