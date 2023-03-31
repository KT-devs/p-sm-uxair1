package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "users")
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    @NotEmpty(message = "Input user name")
    @NonNull
    private String userName;// Temporary type String as plug, ToDo: User service and table links (joins)

    //    @OneToMany
    @Column(name = "contacts")
    @NotEmpty(message = "contacts")
    @NonNull
    private String contacts;// Temporary type String as plug, ToDo: User service and table links (joins)
}
