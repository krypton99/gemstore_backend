package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "change_reason")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_reason_id")
    private long changeReasonId;

    @Column(name = "reason")
    private String reason;

    @OneToMany(mappedBy = "reason", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<ProductQuantityChange> productQuantityChanges;
}
