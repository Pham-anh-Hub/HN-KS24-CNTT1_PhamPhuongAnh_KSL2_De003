package gameitem_ratity.hnks24cntt1_phamphuonganh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.time.LocalDate;


@Entity
@Table(name = "game_items")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GameItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "gameTitle")
    private String gameTitle;
    @Column(name = "marketPrice")
    private Double marketPrice;
    @Column(name = "dropDate")
    private LocalDate dropDate;
    @Column(name = "itemImage")
    private String itemImage;
    @Column(name = "isTradeable")
    private Boolean isTradeable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ratity_id")
    private Ratity ratity;

    public String getFormatPrice(){
        NumberFormat nf = NumberFormat.getNumberInstance();
        return nf.format(marketPrice);
    }
}
