package gameitem_ratity.hnks24cntt1_phamphuonganh.service;

import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.Ratity;

import java.util.List;

public interface IRatityService {
    List<Ratity> getAllRatity();

    Ratity getRatityById(Long id);
}
