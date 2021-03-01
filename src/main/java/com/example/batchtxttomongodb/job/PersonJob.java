package com.example.batchtxttomongodb.job;

import com.example.batchtxttomongodb.step.PersonStep;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private PersonStep personStep;

    // private final StepBuilderFactory personStep;

    // public PersonJob(
    //     @Named("PersonStep") final StepBuilderFactory personStep
    // ){
    //     this.personStep = personStep;
    // }


    @Bean
    public Job job() throws Exception {
        return jobBuilderFactory.get("job")
            .incrementer(new RunIdIncrementer())
            .start(personStep.step1())
            .build();
    }
    
}