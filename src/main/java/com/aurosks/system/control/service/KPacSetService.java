package com.aurosks.system.control.service;

import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.domain.KPacSetSaveRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface KPacSetService {
    /**
     * Create new kpac set
     * @param request params
     */
    void save(KPacSetSaveRequest request);
    /**
     * Delete kpac set by id
     * @param id - kpac set's identifier
     */
    void deleteById(int id);
    /**
     * Find all kpac sets
     */
    List<KPacSet> getAll();

    /**
     * Find kpac set by id
     * @param id - kpac set's identifier
     */
    KPacSet getById(int id);
}
