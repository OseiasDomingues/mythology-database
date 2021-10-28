package com.projectsdl.mythologydatabase.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Gods")
public class GodModel implements Serializable {

    private static final long serialVersionUID = 50585560893586437L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "Role", nullable = false)
    private String role;
    @Column(name = "Culture", nullable = false)
    private String culture;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "Story", nullable = false)
    @ToString.Exclude
    private String story;

    @JoinColumn(name = "pantheon_ID")
    @ManyToOne
    @ToString.Exclude
    private PantheonModel pantheon;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GodModel godModel = (GodModel) o;
        return id != null && Objects.equals(id, godModel.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
