package com.aurosks.system.control.repository;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;

import java.util.List;

public interface KPacDAO {
    void save(KPacSaveRequest request);
    KPac getById(int id);
    void deleteById(int id);
    List<KPac> getAll();
}
