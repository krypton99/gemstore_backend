package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "member_class")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int class_id;

    @Column(name = "class_name", nullable = false)
    private String className;
    @Column(name = "required_point", nullable = false)
    private Long requirePoint;
    @Column(name = "class_benefit", columnDefinition = "TEXT")
    private String classBenefit;

    @OneToMany(mappedBy = "account_id", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UserDetail> userDetails;
}
