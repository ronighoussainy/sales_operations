package com._oostorage.salesOpp.services.generalService;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class GeneralServiceImpl implements GeneralService {

    /**
     * update the entity passed
     *
     * @param entityDTO           (inputs to update)
     * @param entityToUpdate      (object of entity to update it)
     * @param entityToUpdateClass (entity class to work on)
     */
    @Override
    public void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass) {
        // Map key is field name, v is value
        entityDTO.forEach((k, v) -> {
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findField(entityToUpdateClass, k);
            if (field != null) {
                field.setAccessible(true);

                ReflectionUtils.setField(field, entityToUpdate, v);
            }

        });
    }
}
