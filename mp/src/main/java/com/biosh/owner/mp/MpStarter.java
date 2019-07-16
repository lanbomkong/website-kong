package com.biosh.owner.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.biosh.owner.mp.dao")
public class MpStarter {

  public static void main(String[] args) {
	SpringApplication.run(MpStarter.class, args);
  }
}
