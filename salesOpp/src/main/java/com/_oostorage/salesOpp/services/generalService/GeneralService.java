package com._oostorage.salesOpp.services.generalService;

import java.util.Map;

public interface GeneralService {
    void updateEntity(Map<String, Object> entityDTO, Object entityToUpdate, Class entityToUpdateClass);
}
