package com.aurosks.system.control.service;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;

import java.util.List;

public interface KPacService {
    /**
     * Create new kpac
     * @param request params
     */
    void save(KPacSaveRequest request);
    /**
     * Delete kpac by id
     * @param id - kpac's identifier
     */
    void deleteById(int id);

    /**
     * Find all kpacs
     */
    List<KPac> getAll();
}
