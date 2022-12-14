package assignment.address.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString(callSuper = true)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Setter
    @Column(length = 100)
    private String phoneNumber;

    @Setter
    private String residence;

    private Address(String name, String phoneNumber, String residence) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.residence = residence;
    }

    public static Address of(String name, String phoneNumber, String residence) {
        return new Address(name, phoneNumber, residence);
    }
}
