package com.tajweed.backend.controller;

import com.tajweed.backend.dao.AudioRepository;
import com.tajweed.backend.model.Audio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudioController {

    public static Logger logger = LoggerFactory.getLogger(AudioController.class);

    @Autowired
    private AudioRepository repository;

    @RequestMapping("/audio")

    public Iterable<Audio> getAudio() {
        logger.info("Get audio");
        return repository.findAll();
    }
}

