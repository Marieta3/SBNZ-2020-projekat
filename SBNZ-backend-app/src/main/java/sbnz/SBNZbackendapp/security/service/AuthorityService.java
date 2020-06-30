package sbnz.SBNZbackendapp.security.service;

import sbnz.SBNZbackendapp.security.domain.Authority;
import sbnz.SBNZbackendapp.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository repository;

    public Authority findAuthorityByName(String name){
        return repository.findAuthorityByName(name);
    }
}
