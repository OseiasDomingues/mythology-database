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
@Table(name = "Table_of_Gods")
public class GodModel implements Serializable {

    private static final long serialVersionUID = 50585560893586437L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String expertise;
    @Lob@Basic(fetch = FetchType.LAZY)
    private String story;
    //todo private Pantheon pantheon;
    //todo HATEOS
    //todo API PUT - DELETE

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
