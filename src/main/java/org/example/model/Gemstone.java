package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "gemstone")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Gemstone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "is_deleted")
    private boolean isDelete;

    @OneToMany(mappedBy = "gemstone", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Image> images;

    @ManyToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "has_attribute",
    joinColumns = @JoinColumn(name = "gemstone_id"),
    inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private List<Attribute> attributes;
}
