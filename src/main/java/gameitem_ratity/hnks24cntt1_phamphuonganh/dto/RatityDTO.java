package gameitem_ratity.hnks24cntt1_phamphuonganh.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RatityDTO {
    private Long id;

    @NotNull(message = "Vui lòng không bỏ trống độ hiếm")
    @Size(min = 3, max = 50, message = "Độ dài tối đa 3-50 ký tự")
    private String name;
    private Double dropRate;
}
