package ru.test.java.planflight.helper.reflection;

import com.google.common.collect.ImmutableMap;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
public class ObjectInfoDto {

    private final String className;

    private final Map<String, Object> fields = new LinkedHashMap<>();

    public Map<String, Object> getFields() {
        return ImmutableMap.copyOf(fields);
    }

    public void putFields(String key, Object value) {
        fields.put(key, value);
    }
}
