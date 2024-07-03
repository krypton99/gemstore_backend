package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.key.HasAttributeKey;
import org.example.key.RatingKey;

@Entity
@Table(name = "rating")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @EmbeddedId
    RatingKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "rate", nullable = false)
    private int rate;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

}
