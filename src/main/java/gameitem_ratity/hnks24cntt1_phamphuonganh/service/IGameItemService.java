package gameitem_ratity.hnks24cntt1_phamphuonganh.service;

import gameitem_ratity.hnks24cntt1_phamphuonganh.dto.GameItemDTO;
import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.GameItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGameItemService {
    public Page<GameItem> getAllGameItem(String search, Pageable pageable);

    void save(GameItemDTO gameItemDTO);

    void deleteGameItem(Long id);
}
