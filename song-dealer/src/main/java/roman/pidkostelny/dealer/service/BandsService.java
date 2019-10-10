package roman.pidkostelny.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import roman.pidkostelny.dealer.dto.request.BandsRequest;
import roman.pidkostelny.dealer.dto.request.SongsRequest;
import roman.pidkostelny.dealer.dto.respons.BandsResponse;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.entity.Bands;
import roman.pidkostelny.dealer.entity.Songs;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.repository.BandsRepository;
import roman.pidkostelny.dealer.specification.BandsSpecification;

import java.util.stream.Collectors;

@Service
public class BandsService {

    @Autowired
    private BandsRepository bandsRepository;

    public Long save(BandsRequest bandsRequest) {
        Bands bands = new Bands();
        bands.setName(bandsRequest.getName());
        bands.setGenreName(bandsRequest.getGenreName());
        bands.setAlive(bandsRequest.getAlive());
        bands = bandsRepository.save(bands);
        return bands.getId();
    }


    public BandsResponse update(Long id, BandsRequest bandsRequest) throws WrongInp {
        return new BandsResponse(bandsRequestToBands(findOne(id), bandsRequest));
    }

    public Bands findOne(Long id) throws WrongInp {
        return bandsRepository.findById(id).orElseThrow(() -> new WrongInp("Bands with id " + id + " not exists"));
    }

    private Bands bandsRequestToBands(Bands bands, BandsRequest request) {
        if (bands == null) {
            bands = new Bands();
        }
        bands.setName(request.getName());
        bands.setGenreName(request.getGenreName());
        bands.setAlive(request.getAlive());
        return bandsRepository.save(bands);
    }

    public void delete(Long id) throws WrongInp {
        bandsRepository.delete(findOne(id));
    }


    public BandsResponse findOneById(Long id) throws WrongInp {
        return new BandsResponse(findOne(id));
    }

    public DataResponse<BandsResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Bands> pageBands;
        if (value != null && !value.equals("")) {
            BandsSpecification specification = new BandsSpecification(value);
            pageBands = bandsRepository.findAll((Specification<Bands>) specification, pageRequest);
        } else {
            pageBands = bandsRepository.findAll(pageRequest);
        }
        return new DataResponse<BandsResponse>(pageBands.stream().map(BandsResponse::new).collect(Collectors.toList()), pageBands);
    }


}
