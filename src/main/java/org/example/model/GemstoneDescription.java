package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gemstone_description")
public class GemstoneDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "gemstone_id")
    private Gemstone gemstone;

    @Column(name = "story", columnDefinition = "TEXT")
    private String story;
    @Column(name = "message", columnDefinition = "TEXT")
    private String message;
    @Column(name = "benefit", columnDefinition = "TEXT")
    private String benefit;
    @Column(name = "is_deleted")
    private boolean isDelete;

}
