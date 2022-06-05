package com.epam.conf.conference.controller;

import com.epam.conf.conference.entity.Conference;
import com.epam.conf.conference.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ConferenceController {
    @Autowired
    private ConferenceService conferenceService;

    @GetMapping("/conferences")
    public Iterable<Conference> findAll() {
        return conferenceService.findAll();
    }

    @GetMapping("/conferences/{id}")
    public ResponseEntity<Conference> findById(@PathVariable("id") Long id) {
        return conferenceService.findById(id)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/conferences")
    public Conference create(@RequestBody Conference conference) {
        return conferenceService.save(conference);
    }

    @PutMapping("/conferences/{id}")
    public Conference update(@PathVariable("id") Long id,
                             @RequestBody Conference conference) {
        conference.setId(id);

        return conferenceService.save(conference);
    }

    @DeleteMapping("/conferences/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        conferenceService.deleteById(id);
    }
}
