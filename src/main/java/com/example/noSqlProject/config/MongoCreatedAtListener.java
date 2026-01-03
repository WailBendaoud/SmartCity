package com.example.noSqlProject.config;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.Instant;

@Component
public class MongoCreatedAtListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        try {
            Field field = event.getSource().getClass().getDeclaredField("createdAt");
            field.setAccessible(true);

            if (field.get(event.getSource()) == null) {
                field.set(event.getSource(), Instant.now());
            }
        } catch (Exception ignored) {}
    }
}

