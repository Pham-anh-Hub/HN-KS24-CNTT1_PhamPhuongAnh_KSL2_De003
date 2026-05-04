package gameitem_ratity.hnks24cntt1_phamphuonganh.service;

import gameitem_ratity.hnks24cntt1_phamphuonganh.dto.GameItemDTO;
import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.GameItem;
import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.Ratity;
import gameitem_ratity.hnks24cntt1_phamphuonganh.repository.IGameItemRepository;
import gameitem_ratity.hnks24cntt1_phamphuonganh.repository.IRatityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GameItemServiceImpl implements IGameItemService{
    private final IGameItemRepository gameItemRepository;
    private final IRatityRepository ratityRepository;

    @Override
    public Page<GameItem> getAllGameItem(String search, Pageable pageable) {
        if (search.isEmpty()){
            return gameItemRepository.findAll(pageable);
        }
        return gameItemRepository.getGameItemsByItemNameContainingIgnoreCase(pageable, search);
    }

    @Override
    public void save(GameItemDTO gameItemDTO) {
        //
        GameItem gameItem = new GameItem();

        if (gameItem.getId() != null){
            gameItem.setId(gameItemDTO.getId());
        }

        gameItem.setItemName(gameItemDTO.getItemName());
        gameItem.setGameTitle(gameItemDTO.getGameTitle());
        gameItem.setDropDate(gameItemDTO.getDropDate());
        gameItem.setMarketPrice(gameItemDTO.getMarketPrice());
        gameItem.setIsTradeable(gameItemDTO.getIsTradeable());

        // 2. Xử lý chuyển đổi và lưu file Avatar
        MultipartFile file = gameItemDTO.getItemImage();
        if (file != null && !file.isEmpty()) {
            try {
                String path = "D:\\JavaWeb App\\PTIT_CNTT1_IT210_Sessions\\HN-KS24-CNTT1_PhamPhuongAnh\\src\\main\\resources\\static\\images\\";
                // Tạo tên file duy nhất bằng timestamp
                String originalFileName = file.getOriginalFilename();

                // Tạo tên file duy nhất
                String fileName = System.currentTimeMillis() + "_" + originalFileName;

                // Lưu file
                file.transferTo(new File(path + fileName));;

                // Lưu tên file vào cột avatar trong database
                gameItem.setItemImage(fileName);

            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }

            // 3. Ánh xạ Department dựa trên ID
            if (gameItemDTO.getRatityId() != null) {
                Ratity rat = ratityRepository.findById(gameItemDTO.getRatityId()).orElseThrow(
                        () -> new RuntimeException("Không tìm thấy độ hiếm với ID: " + gameItemDTO.getRatityId()
                ));
                gameItem.setRatity(rat);
            }
            gameItemRepository.save(gameItem);
        }
    }

    @Override
    public void deleteGameItem(Long id) {

    }
}
