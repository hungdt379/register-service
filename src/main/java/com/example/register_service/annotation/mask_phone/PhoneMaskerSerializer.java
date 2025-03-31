package com.example.register_service.annotation.mask_phone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PhoneMaskerSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String phone, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(phone.substring(0, 4) + "xxxxxx");
    }

}
