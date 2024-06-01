package com.aurosks.system.control.service;

import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.domain.KPacSetSaveRequest;
import com.aurosks.system.control.repository.KPacSetDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPacSetServiceImpl implements KPacSetService {
    @Autowired
    private KPacSetDAO kPacSetDAO;

    @Override
    public void save(KPacSetSaveRequest request) {
        this.kPacSetDAO.save(request);
    }

    @Override
    public void deleteById(int id) {
        this.kPacSetDAO.deleteById(id);
    }

    @Override
    public List<KPacSet> getAll() {
        return this.kPacSetDAO.getAll();
    }

    @Override
    public KPacSet getById(int id) {
        return this.kPacSetDAO.getById(id);
    }
}
