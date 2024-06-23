package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @ManyToOne
    @JoinColumn(name = "gemstone_id")
    private Gemstone gemstone;

    @Column(name = "image_url")
    private String imageUrl;
}
