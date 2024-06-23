package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "attribute")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attributeId;
    @Column(name = "name")
    private String name;
    @Column(name = "icon_url")
    private String iconUrl;
    @Column(name = "is_deleted")
    private boolean isDelete;
    @OneToOne
    @JoinColumn
    private AttributeType attributeType;
}
