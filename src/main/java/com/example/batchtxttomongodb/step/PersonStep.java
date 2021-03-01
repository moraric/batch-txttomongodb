package com.example.batchtxttomongodb.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.inject.Named;

import com.example.batchtxttomongodb.model.Person;


@Component
public class PersonStep {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private FlatFileItemReader<Person> reader;
    private ItemProcessor<Person, Person> processor;
    private ItemWriter<Person> writer;


    public PersonStep(
        @Named("LeeTxt") FlatFileItemReader<Person> reader,
        @Named("PersonItemProcessor") ItemProcessor<Person, Person> processor,
        @Named("PersonItemWriter") ItemWriter<Person> writer
    ){
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }
    
    
    @Bean
    public Step step1() throws Exception {
        return stepBuilderFactory.get("step1")
            .<Person, Person> chunk(10)
            .reader(reader)
			.processor(processor)
			.writer(writer)
			.build();
    }
    
}