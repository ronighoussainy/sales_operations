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
            if (v instanceof LinkedHashMap) {
                LinkedHashMap jsonObject = (LinkedHashMap) v;

                if (jsonObject.get("type").equals("date")) {
                    // if it was more than this format try the other format as discussed with front ent
                    if (jsonObject.get("value").toString().length() > 10) {
                        try {
                            v = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(jsonObject.get("value").toString());
                        } catch (Exception e) {
                        }
                    } else {
                        try {
                            v = new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.get("value").toString());
                        } catch (Exception e) {
                        }
                    }
                }
            }
            // use reflection to get field k on entityToUpdate and set it to value k
            Field field = ReflectionUtils.findField(entityToUpdateClass, k);
            // convert value from type integer to type Long if the field is Long type
            if (field != null && field.getType().equals(Long.class) && v instanceof Integer)
                v = ((Integer) v).longValue();
            if (field != null && field.getType().equals(Double.class) && v instanceof Long)
                v = ((Long) v).doubleValue();
            if (field != null && field.getType().equals(Double.class) && v instanceof Integer)
                v = ((Integer) v).doubleValue();
            if (field != null && field.getType().equals(BigDecimal.class) && v instanceof Integer)
                v = BigDecimal.valueOf(((Integer) v).intValue());
            if (field != null && field.getType().equals(BigDecimal.class) && v instanceof Double)
                v = BigDecimal.valueOf(((Double) v).doubleValue());

            if(field != null && field.getType().equals(Integer.class) && v instanceof String){
                v = Integer.parseInt(v.toString());
            }

            try {
                field.setAccessible(true);
            } catch (NullPointerException e) {
            }
            ReflectionUtils.setField(field, entityToUpdate, v);
        });
    }
}
