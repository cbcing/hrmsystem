package com.scujcc.dao;

import com.scujcc.entity.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by David on 4/11/17.
 */
public interface CountryDao extends CrudRepository<Country, Integer> {
}
