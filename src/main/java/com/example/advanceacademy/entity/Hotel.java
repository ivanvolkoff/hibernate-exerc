package com.example.advanceacademy.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "hotel",fetch = FetchType.EAGER)
    @JsonManagedReference
    @Cascade(CascadeType.ALL)
    private Set<Room> rooms;

    @OneToMany(mappedBy = "hotel",fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Reservation> reservations;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", reservations=" + reservations +
                '}';
    }
}
