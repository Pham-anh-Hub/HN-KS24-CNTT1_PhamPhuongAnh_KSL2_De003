package gameitem_ratity.hnks24cntt1_phamphuonganh.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ratiry")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Ratity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "dropRate")
    private Double dropRate;

    @OneToMany(mappedBy = "ratity", cascade = CascadeType.ALL)
    private List<GameItem> gameItems;

}
