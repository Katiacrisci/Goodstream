package crisci.caterina.goodstream.service;

import crisci.caterina.goodstream.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;


}
