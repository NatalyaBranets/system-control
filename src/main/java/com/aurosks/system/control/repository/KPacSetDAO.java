package com.aurosks.system.control.repository;

import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.domain.KPacSetSaveRequest;

import java.util.List;

public interface KPacSetDAO {
    void save(KPacSetSaveRequest request);
    void deleteById(int id);
    List<KPacSet> getAll();
    KPacSet getById(int id);
}
