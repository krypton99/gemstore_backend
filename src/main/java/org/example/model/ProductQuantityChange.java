package org.example.model;

import jakarta.persistence.*;
import org.springframework.security.core.parameters.P;

import java.util.Date;

@Entity
@Table(name = "product_quantity_change")
public class ProductQuantityChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private long receipt_id;

    @ManyToOne
    @JoinColumn(name = "change_reason_id")
    private ChangeReason reason;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "quantity")
    private long quantity;
}
