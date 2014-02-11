package org.experiment.controller;

import org.experiment.model.Album;
import org.experiment.model.Series;
import org.experiment.repository.AlbumRepository;
import org.experiment.repository.SeriesRepository;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/api/albums")
public class AlbumController extends RepositoryBasedRestController<Album, Long, AlbumRepository> {

    @Inject
    @Named("albumRepository")
    @Override
    public void setRepository(AlbumRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, params="ids[]")
    @ResponseBody
    public List<Album> getByIds(@RequestParam(value="ids[]") Long[] idArray){
        List<Long> ids = Arrays.asList(idArray);

        return this.repository.findAll(ids);
    }
}
