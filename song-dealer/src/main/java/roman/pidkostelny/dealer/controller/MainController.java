package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import roman.pidkostelny.dealer.dto.request.SongsRequest;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
import roman.pidkostelny.dealer.dto.respons.SongsRespons;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.service.SongsService;

import javax.validation.Valid;

//@CrossOrigin
@RestController
@RequestMapping("/public/mp3")

public class MainController {
    @Autowired
    private SongsService songsService;

    @GetMapping
    public DataResponse<SongsRespons> getSongs(@RequestParam(required = false) String value,
                                               @RequestParam Integer page,
                                               @RequestParam Integer size,
                                               @RequestParam String sortFieldName,
                                               @RequestParam Sort.Direction direction) {
        System.out.println("GET ALL Songs");
        return songsService.findAll(value, page, size, sortFieldName, direction);
    }

    @PutMapping
    public SongsRespons Update(@RequestParam Long id, @RequestBody SongsRequest songsRequest) throws WrongInp {
        return songsService.update(id, songsRequest);
    }

    @GetMapping("/one")
    public SongsRespons findOne(@RequestParam Long id) throws WrongInp {
        return songsService.findOneById(id);
    }

    @PostMapping
    public Long save(@RequestBody @Valid SongsRequest songsRequest) {
        System.out.println("SAVE SONGS IN DB with first name -> " + songsRequest.getName());
        return songsService.save(songsRequest);
    }

    @DeleteMapping("/{id}")
    public void search(@PathVariable Long id) throws WrongInp {
        System.out.println("Delete song by id " + id);
        songsService.delete(id);
    }

}
