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
    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name", nullable = false)
    private String className;
    @Column(name = "required_point", nullable = false)
    private Long requirePoint;
    @Column(name = "class_benefit", columnDefinition = "TEXT")
    private String classBenefit;

    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UserDetail> userDetails;
}
