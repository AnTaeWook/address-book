package assignment.address.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Address extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 100)
    private String phoneNumber;

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
