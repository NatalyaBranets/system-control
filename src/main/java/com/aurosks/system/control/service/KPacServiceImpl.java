package com.aurosks.system.control.service;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;
import com.aurosks.system.control.repository.KPacDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPacServiceImpl implements KPacService {

    @Autowired
    private KPacDAO kPacDAO;

    @Override
    public void save(KPacSaveRequest request) {
        this.kPacDAO.save(request);
    }

    @Override
    public void deleteById(int id) {
        this.kPacDAO.deleteById(id);
    }

    @Override
    public List<KPac> getAll() {
        return this.kPacDAO.getAll();
    }
}
