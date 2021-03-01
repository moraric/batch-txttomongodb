package com.example.batchtxttomongodb.step.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import com.example.batchtxttomongodb.model.Person;
import com.example.batchtxttomongodb.repository.PersonRepository;


@Component
public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void write(List<? extends Person> personas) throws Exception {
        personRepository.saveAll(personas);
    }
    
}