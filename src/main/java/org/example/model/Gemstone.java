package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gemstone")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Gemstone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gemstone_id")
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    @OneToMany(mappedBy = "gemstone", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Image> images;

}
