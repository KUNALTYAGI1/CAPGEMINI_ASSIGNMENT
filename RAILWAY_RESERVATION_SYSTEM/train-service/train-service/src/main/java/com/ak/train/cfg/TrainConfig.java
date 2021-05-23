/**
 * train module should be a different microservice but I am adding it admin service
 * later with small modification it can be seperated
 */
package com.ak.train.cfg;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages= {"com.ak.train.repo"})
@EntityScan(basePackages= {"com.ak.train.entity"})
@ComponentScan(basePackages= {"com.ak.train.service","com.ak.train.controller"})
public class TrainConfig {

}
