package org.example.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class HasAttributeKey implements Serializable {
    @Column(name = "gemstone_id")
    private String gemstoneId;

    @Column(name = "attribute_id")
    private String attributeId;

}
