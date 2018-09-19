package com.exochain.ice;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import com.exochain.ice.IDB;
import com.exochain.ice.mock.MockDB;

@Configuration
public class DBConfig {
    @Bean
    public IDB getDB() {
        // Until we have a real DB
        return new MockDB();
    }
}

