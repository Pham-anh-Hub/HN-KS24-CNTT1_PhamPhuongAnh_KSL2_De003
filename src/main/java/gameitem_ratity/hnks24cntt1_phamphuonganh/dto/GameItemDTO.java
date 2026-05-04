package gameitem_ratity.hnks24cntt1_phamphuonganh.dto;

import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.Ratity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class GameItemDTO {
    private Long id;
    @NotNull(message = "Vui lòng không bỏ trống tên vật phẩm")
    @Size(min = 5, max = 150, message = "Độ dài tối đa 5-150 ký tự")
    private String itemName;
    @NotNull(message = "Vui lòng không bỏ trống tựa game")
    @NotBlank(message = "Vui lòng không bỏ trống tựa game")
    private String gameTitle;

    @NotNull(message = "Vui lòng không bỏ trống giá vật phẩm")
    private Double marketPrice;

    @PastOrPresent(message = "Vui lòng chọn ngày hợp lệ ")
    private LocalDate dropDate;

    private MultipartFile itemImage;
    private Boolean isTradeable;
    private Long ratityId;
}
