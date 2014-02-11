package org.experiment.controller;

import org.experiment.model.Series;
import org.experiment.repository.SeriesRepository;
import org.resthub.common.exception.NotFoundException;
import org.resthub.web.controller.RepositoryBasedRestController;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
@RequestMapping(value = "/api/series")
@EnableSpringDataWebSupport
public class SeriesController extends RepositoryBasedRestController<Series, Long, SeriesRepository> {

    @Inject
    @Named("seriesRepository")
    @Override
    public void setRepository(SeriesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Series update(@PathVariable Long id, @RequestBody Series resource) {
        Assert.notNull(id, "id cannot be null");

        Series retrievedResource = this.findById(id);
        if (retrievedResource == null) {
            throw new NotFoundException();
        }

        resource.setId(retrievedResource.getId());
        resource.setAlbums(retrievedResource.getAlbums());

        return this.repository.save(resource);
    }

}
