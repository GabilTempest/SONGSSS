package roman.pidkostelny.dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import roman.pidkostelny.dealer.dto.request.*;
import roman.pidkostelny.dealer.dto.respons.DataResponse;
//import roman.pidkostelny.dealer.dto.respons.PersonRespons;
import roman.pidkostelny.dealer.dto.respons.SongsRespons;

//import roman.pidkostelny.dealer.dto.respons.UserRespons;
//import roman.pidkostelny.dealer.entity.Person;
import roman.pidkostelny.dealer.entity.Songs;

import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.repository.SongsRepository;
import roman.pidkostelny.dealer.specification.SongSpecification;
//import roman.pidkostelny.dealer.specification.UserSpecification;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongsService {

    @Autowired
    private SongsRepository songsRepository;

    public Long save(SongsRequest songsRequest) {
        Songs songs = new Songs();
        songs.setName(songsRequest.getName());
        songs.setBame(songsRequest.getBame());
        songs.setGenreName(songsRequest.getGenreName());
        songs.setUrlname(songsRequest.getUrlname());
        songs = songsRepository.save(songs);
        return songs.getId();
    }

    public SongsRespons update(Long id, SongsRequest songsRequest) throws WrongInp {
        return new SongsRespons(songsRequestToSongs(findOne(id), songsRequest));
    }

    public Songs findOne(Long id) throws WrongInp {
        return songsRepository.findById(id).orElseThrow(() -> new WrongInp("Song with id " + id + " not exists"));
    }

    private Songs songsRequestToSongs(Songs songs, SongsRequest request) {
        if (songs == null) {
            songs = new Songs();
        }
        songs.setName(request.getName());
        songs.setBame(request.getBame());
        songs.setGenreName(request.getGenreName());
        songs.setUrlname(request.getUrlname());
        return songsRepository.save(songs);
    }

    public void delete(Long id) throws WrongInp {
        songsRepository.delete(findOne(id));
    }


    public SongsRespons findOneById(Long id) throws WrongInp {
        return new SongsRespons(findOne(id));
    }

    public DataResponse<SongsRespons> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Songs> pageSongs;
        if (value != null && !value.equals("")) {
            SongSpecification specification = new SongSpecification(value);
            pageSongs = songsRepository.findAll((Specification<Songs>) specification, pageRequest);
        } else {
            pageSongs = songsRepository.findAll(pageRequest);
        }
        return new DataResponse<SongsRespons>(pageSongs.stream().map(SongsRespons::new).collect(Collectors.toList()), pageSongs);
    }


}
