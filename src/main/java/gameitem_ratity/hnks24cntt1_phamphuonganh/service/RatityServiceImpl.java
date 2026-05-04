package gameitem_ratity.hnks24cntt1_phamphuonganh.service;

import gameitem_ratity.hnks24cntt1_phamphuonganh.entity.Ratity;
import gameitem_ratity.hnks24cntt1_phamphuonganh.repository.IRatityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatityServiceImpl implements IRatityService{
    private final IRatityRepository ratityRepository;

    @Override
    public List<Ratity> getAllRatity() {
        return ratityRepository.findAll();
    }

    @Override
    public Ratity getRatityById(Long id) {
        return ratityRepository.getReferenceById(id);
    }
}
