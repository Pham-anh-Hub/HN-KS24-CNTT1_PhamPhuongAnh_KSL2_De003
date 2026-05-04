package gameitem_ratity.hnks24cntt1_phamphuonganh.config;

import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.GameItem;
import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.Ratity;
import gameitem_ratity.hnks24cntt1_phamphuonganh.repository.IGameItemRepository;
import gameitem_ratity.hnks24cntt1_phamphuonganh.repository.IRatityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final IGameItemRepository gameItemRepository;
    private final IRatityRepository ratityRepository;

    @Override
    public void run(String... args) throws Exception {
        if (ratityRepository.count() > 0 ){
                return;
        }

        Ratity immortal = new Ratity();
        immortal.setName("Immortal");
        immortal.setDropRate(0.20);
        immortal.setGameItems(new ArrayList<>());
        immortal = ratityRepository.save(immortal);

        Ratity legendary = new Ratity();
        legendary.setName("Legendary");
        legendary.setDropRate(0.15);
        legendary.setGameItems(new ArrayList<>());
        legendary = ratityRepository.save(legendary);

        Ratity covert = new Ratity();
        covert.setName("Covert");
        covert.setDropRate(0.25);
        covert.setGameItems(new ArrayList<>());
        covert = ratityRepository.save(covert);


        // immortal
        GameItem gameItem1 = new GameItem();
        gameItem1.setItemName("ImmortalItem1");
        gameItem1.setGameTitle("About Immortal");
        gameItem1.setMarketPrice(300000.0);
        gameItem1.setDropDate(LocalDate.of(2026, 3, 15));
        gameItem1.setIsTradeable(true);
        gameItem1.setItemImage("");
        gameItem1.setRatity(immortal);

        GameItem gameItem2 = new GameItem();
        gameItem2.setItemName("ImmortalItem2");
        gameItem2.setGameTitle("About Immortal P2");
        gameItem2.setMarketPrice(320000.0);
        gameItem2.setDropDate(LocalDate.of(2026, 4, 11));
        gameItem2.setIsTradeable(false);
        gameItem2.setItemImage("");
        gameItem2.setRatity(immortal);


        GameItem gameItem3 = new GameItem();
        gameItem3.setItemName("Immortal Item3");
        gameItem3.setGameTitle("About Immortal");
        gameItem3.setMarketPrice(250000.0);
        gameItem3.setDropDate(LocalDate.of(2026, 4, 22));
        gameItem3.setIsTradeable(true);
        gameItem3.setItemImage("_");
        gameItem3.setRatity(immortal);


        GameItem gameItem4 = new GameItem();
        gameItem4.setItemName("Immortal Item4");
        gameItem4.setGameTitle("About Immortal");
        gameItem4.setMarketPrice(250000.0);
        gameItem4.setDropDate(LocalDate.of(2026, 2, 25));
        gameItem4.setIsTradeable(true);
        gameItem4.setItemImage("");
        gameItem4.setRatity(immortal);



        // legendary
        GameItem gameItem5 = new GameItem();
        gameItem5.setItemName("Legendary Item 1 ");
        gameItem5.setGameTitle("About Legendary");
        gameItem5.setMarketPrice(260000.0);
        gameItem5.setDropDate(LocalDate.of(2026, 4, 15));
        gameItem5.setIsTradeable(false);
        gameItem5.setItemImage("");
        gameItem5.setRatity(legendary);


        GameItem gameItem6 = new GameItem();
        gameItem6.setItemName("Legendary Item 2 ");
        gameItem6.setGameTitle("About Legendary");
        gameItem6.setMarketPrice(360000.0);
        gameItem6.setDropDate(LocalDate.of(2026, 1, 28));
        gameItem6.setIsTradeable(true);
        gameItem6.setItemImage("");
        gameItem6.setRatity(legendary);


        GameItem gameItem7 = new GameItem();
        gameItem7.setItemName("Legendary Item 3 ");
        gameItem7.setGameTitle("About Legendary P3");
        gameItem7.setMarketPrice(220000.0);
        gameItem7.setDropDate(LocalDate.of(2026, 9, 22));
        gameItem7.setIsTradeable(false);
        gameItem7.setItemImage("");
        gameItem7.setRatity(legendary);


        GameItem gameItem8 = new GameItem();
        gameItem8.setItemName("Legendary Item 4 ");
        gameItem8.setGameTitle("About Legendary");
        gameItem8.setMarketPrice(200000.0);
        gameItem8.setDropDate(LocalDate.of(2026, 4, 15));
        gameItem8.setIsTradeable(true);
        gameItem8.setItemImage("");
        gameItem8.setRatity(legendary);



        // covert
        GameItem gameItem9 = new GameItem();
        gameItem9.setItemName("Covert Item 1 ");
        gameItem9.setGameTitle("A Game of Covert");
        gameItem9.setMarketPrice(360000.0);
        gameItem9.setDropDate(LocalDate.of(2026, 5, 15));
        gameItem9.setIsTradeable(true);
        gameItem9.setItemImage("");
        gameItem9.setRatity(covert);

        GameItem gameItem10 = new GameItem();
        gameItem10.setItemName("Covert Item 2 ");
        gameItem10.setGameTitle("A Game of Covert P2");
        gameItem10.setMarketPrice(460000.0);
        gameItem10.setDropDate(LocalDate.of(2026, 9, 25));
        gameItem10.setIsTradeable(true);
        gameItem10.setItemImage("");
        gameItem10.setRatity(covert);


        GameItem gameItem11 = new GameItem();
        gameItem11.setItemName("Covert Item 3 ");
        gameItem11.setGameTitle("A Game of Covert");
        gameItem11.setMarketPrice(500000.0);
        gameItem11.setDropDate(LocalDate.of(2026, 4, 15));
        gameItem11.setIsTradeable(false);
        gameItem11.setItemImage("");
        gameItem11.setRatity(covert);


        GameItem gameItem12 = new GameItem();
        gameItem12.setItemName("Covert Item 4 ");
        gameItem12.setGameTitle("A Game of Covert");
        gameItem12.setMarketPrice(260000.0);
        gameItem12.setDropDate(LocalDate.of(2026, 1, 25));
        gameItem12.setIsTradeable(true);
        gameItem12.setItemImage("");
        gameItem12.setRatity(covert);

//        ratityRepository.saveAll(List.of(immortal, legendary, covert));
        gameItemRepository.saveAll(List.of(gameItem1,gameItem2, gameItem3, gameItem4, gameItem5, gameItem6, gameItem7, gameItem8, gameItem9, gameItem10, gameItem11, gameItem12));




    }
}
