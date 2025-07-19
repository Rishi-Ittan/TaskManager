package com.kasa.task_manager;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import javax.sql.DataSource;

@TestConfiguration
public class TestConfig {
    @MockitoBean
    DataSource dataSource;
}
