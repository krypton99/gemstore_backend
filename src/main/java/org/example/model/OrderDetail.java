package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.key.HasAttributeKey;
import org.example.key.OrderDetailKey;

@Entity
@Table(name = "order_detail")
@Getter @Setter

public class OrderDetail {
    @EmbeddedId
    OrderDetailKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private long quantity;
}
