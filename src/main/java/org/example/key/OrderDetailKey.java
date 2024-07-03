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
public class OrderDetailKey implements Serializable {
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_id")
    private long productId;
}
