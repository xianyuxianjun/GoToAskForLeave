package com.chenxianyu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.chenxianyu")
@Configuration
public class SpringMvcConfig {
}
