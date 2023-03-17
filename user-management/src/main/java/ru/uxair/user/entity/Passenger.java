package ru.uxair.user.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passengers")
@Data
@ToString(of = {"firstName", "middleName", "last_name", "dateOfBirth"})
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Passenger {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @NonNull
    private String firstName;

    @Column(name = "middle_name")
    @NonNull
    private String middleName;

    @Column(name = "last_name")
    @NonNull
    private String lastName;

    @Column(name = "date_of_birth")
    @NonNull
    private LocalDate dateOfBirth;

    //    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Column(name = "user_id")
    @NonNull
    private String userId; // Temporary type String as plug, ToDo: User service and table links (joins)

    //    @OneToOne(mappedBy = "documents")
    @Column(name = "documents")
    @NonNull
    private String documents; // Temporary type String as plug, ToDo: Document service and table links (joins)

    @Column(name = "field")
    @NonNull
    private String field;
}
