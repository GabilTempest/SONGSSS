package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelny.dealer.dto.request.BandsRequest;
import roman.pidkostelny.dealer.dto.request.SongsRequest;
import roman.pidkostelny.dealer.dto.respons.BandsResponse;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.SongsRespons;
import roman.pidkostelny.dealer.entity.Bands;
import roman.pidkostelny.dealer.entity.Songs;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.service.BandsService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandsController {

    @Autowired
    private BandsService bandsService;


    @GetMapping
    public DataResponse<BandsResponse> getBands(@RequestParam(required = false) String value,
                                                @RequestParam Integer page,
                                                @RequestParam Integer size,
                                                @RequestParam String sortFieldName,
                                                @RequestParam Sort.Direction direction) {
        System.out.println("GET ALL Bands");
        return bandsService.findAll(value, page, size, sortFieldName, direction);
    }

    @PutMapping
    public BandsResponse Update(@RequestParam Long id, @RequestBody BandsRequest bandsRequest) throws WrongInp {
        return bandsService.update(id, bandsRequest);
    }

    @GetMapping("/one")
    public BandsResponse findOne(@RequestParam Long id) throws WrongInp {
        return bandsService.findOneById(id);
    }

    @PostMapping
    public Long save(@RequestBody @Valid BandsRequest bandsRequest) {
        System.out.println("SAVE BANDS IN DB with first name -> " + bandsRequest.getName());
        return bandsService.save(bandsRequest);
    }

    @DeleteMapping("/{id}")
    public void search(@PathVariable Long id) throws WrongInp {
        System.out.println("Delete bands by id " + id);
        bandsService.delete(id);
    }

}
