package gameitem_ratity.hnks24cntt1_phamphuonganh.controller;


import gameitem_ratity.hnks24cntt1_phamphuonganh.dto.GameItemDTO;
import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.GameItem;
import gameitem_ratity.hnks24cntt1_phamphuonganh.service.IGameItemService;
import gameitem_ratity.hnks24cntt1_phamphuonganh.service.IRatityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("game-items")
@RequiredArgsConstructor
public class GameItemController {
    private final IGameItemService gameItemService;
    private final IRatityService ratityService;

    @GetMapping("/list")
    public String viewGameItems(
            Model model,
            @PageableDefault(
                page = 0,
                    size = 5,
                    sort = "id",
                    direction = Sort.Direction.ASC
            )Pageable pageable,
            @RequestParam (name = "search", defaultValue = "") String search
    ){
        Page<GameItem> gameItems = gameItemService.getAllGameItem(search, pageable);
        model.addAttribute("page", gameItems.getNumber());
        model.addAttribute("pageSize", gameItems.getSize());
        model.addAttribute("totalPage", gameItems.getTotalPages());
        model.addAttribute("gameItems", gameItems.getContent());
            model.addAttribute("search", search);
        return "view-game-items";
    }

    @GetMapping("/view-add")
    public String viewAdd(
            Model model
    ){
        model.addAttribute("ratityList",ratityService.getAllRatity());
        model.addAttribute("gameItemDTO", new GameItemDTO());
        return "form-view-add";
    }

    @PostMapping("/handle-add")
    public String onAdd(
            @Valid@ModelAttribute(name = "gameItemDTO") GameItemDTO gameItemDTO,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()){
            model.addAttribute("ratityList",ratityService.getAllRatity());
            model.addAttribute("gameItemDTO", gameItemDTO);
            return "form-view-add";
        }

        gameItemService.save(gameItemDTO);
        return "redirect:/game-items/list";
    }



    @GetMapping("/delete/{id}")
    public String onDelete(
            @PathVariable(name = "id") String delId
    ){
        gameItemService.deleteGameItem(Long.parseLong(delId));
        return "redirect:/game-items/list";
    }
}
