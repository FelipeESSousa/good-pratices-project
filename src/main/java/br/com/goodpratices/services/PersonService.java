package br.com.goodpratices.services;

import br.com.goodpratices.domain.repository.PersonRepository;
import br.com.goodpratices.services.dto.PersonRequest;
import br.com.goodpratices.services.dto.PersonResponse;
import br.com.goodpratices.services.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonResponse save(PersonRequest person) {
        return personMapper.convert(personRepository.save(personMapper.convert(person)));
    }

    public List<PersonResponse> findAll() {
        return personMapper.convert(personRepository.findAll());
        //return personRepository.findAll().parallelStream().map(personMapper::convert).toList();
    }

    public PersonResponse findById(Long id) {
        return personMapper.convert(personRepository.getById(id));
    }
}
