package co.istad.mbankingapi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cards")
public class Card {
    @Id
    private Long id;
    @Column(unique = true,updatable = false)
    private String number;
    @Column(nullable = false)
    private String cvv;
    private String holder;
    private LocalDate issuedAt;
    private LocalDate expiresAt;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CardType cardType;
    @OneToOne(mappedBy = "card")
    private Account account;

}
