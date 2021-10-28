package com.projectsdl.mythologydatabase.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "Pantheons")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PantheonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Temple", nullable = false)
    private String temple;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pantheon")
    @ToString.Exclude
    @JsonIgnore
    private List<GodModel> gods = new ArrayList<>();

    public PantheonModel(Long id, String name, String temple) {
        this.id = id;
        this.name = name;
        this.temple = temple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PantheonModel that = (PantheonModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}