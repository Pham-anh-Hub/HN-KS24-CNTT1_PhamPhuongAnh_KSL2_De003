package gameitem_ratity.hnks24cntt1_phamphuonganh.repository;

import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.GameItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameItemRepository extends JpaRepository<GameItem, Long> {

    Page<GameItem> getGameItemsByItemNameContainingIgnoreCase(Pageable pageable, String search);
}
