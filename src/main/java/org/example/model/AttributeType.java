package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name="attribute_type")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AttributeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_type_id")
    private long attributeTypeId;
    @Column(name = "name")
    private String name;
    @Column(name = "is_deleted")
    private boolean isDelete;
}
