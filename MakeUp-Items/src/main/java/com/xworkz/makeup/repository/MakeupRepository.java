package com.xworkz.makeup.repository;

import com.xworkz.makeup.entity.MakeupEntity;

import java.util.List;

public interface MakeupRepository {
    boolean save(MakeupEntity makeupEntity);
    List<MakeupEntity> getAllEntity();
}
