package com.epam.conf.conference.service;

import com.epam.conf.conference.entity.Conference;
import com.epam.conf.conference.repository.ConferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public Optional<Conference> findById(Long id) {
        return conferenceRepository.findById(id);
    }

    public Iterable<Conference> findAll() {
        return conferenceRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public void deleteById(Long id) {
        conferenceRepository.deleteById(id);
    }
}
