package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.key.HasAttributeKey;

@Entity
@Getter @Setter
public class HasAttribute {
    @EmbeddedId
    HasAttributeKey id;

    @ManyToOne
    @MapsId("gemstoneId")
    @JoinColumn(name = "gemstone_id")
    private Gemstone gemstone;

    @ManyToOne
    @MapsId("attributeId")
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

}
