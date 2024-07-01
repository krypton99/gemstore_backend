package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user_detail")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    @OneToOne
    @PrimaryKeyJoinColumn(name = "user_id")
    private User user;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "state")
    private String state;
    @Column(name = "user_address")
    private String userAddress;
    @Column(name = "day_of_birth")
    private Date dayOfBirth;
    @Column(name = "point", nullable = false)
    private Long point;
    @Column(name = "account_balance", nullable = false)
    private Long accountBalance;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private MemberClass memberClass;
}
