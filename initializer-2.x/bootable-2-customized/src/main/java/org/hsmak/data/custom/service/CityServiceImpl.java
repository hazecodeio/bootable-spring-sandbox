/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hsmak.data.custom.service;

import org.hsmak.data.custom.domain.HotelSummary;
import org.hsmak.data.custom.entity.City;
import org.hsmak.data.custom.repository.CityRepository;
import org.hsmak.data.custom.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component("cityService")
@Transactional
public class CityServiceImpl{

    private final CityRepository cityRepository;

    private final HotelRepository hotelRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, HotelRepository hotelRepository) {
        this.cityRepository = cityRepository;
        this.hotelRepository = hotelRepository;
    }

    public Page<City> findCities(String name, Pageable pageable) {

        String country = "";
        int splitPos = name.lastIndexOf(",");

        if (splitPos >= 0) {
            country = name.substring(splitPos + 1);
            name = name.substring(0, splitPos);
        }

        return this.cityRepository
                .findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(),
                        country.trim(), pageable);
    }

    public City getCity(String name, String country) {
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

    public Page<HotelSummary> getHotels(City city, Pageable pageable) {
        return this.hotelRepository.findByCity(city, pageable);
    }
}
