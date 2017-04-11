package com.scujcc.service;

import com.scujcc.dao.CountryDao;
import com.scujcc.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David on 4/11/17.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryDao countryDao;

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        Iterator iterator = countryDao.findAll().iterator();
        while (iterator.hasNext()){
            countries.add((Country) iterator.next());
        }
        return countries;
    }
}
