package com.sba.pixogram.service;

import com.sba.pixogram.entity.UploadPic;
import com.sba.pixogram.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UploadServiceImpl implements UploadService {
    private UploadRepository  uploadRepository;
    @Autowired
    public UploadServiceImpl(UploadRepository uploadRepository) {
        this.uploadRepository = uploadRepository;
    }

    @Override
    public UploadPic save(UploadPic dbFile)  {
        return uploadRepository.save(dbFile);
    }

    @Override
    public ArrayList<UploadPic> findById(long fileId) {
        return uploadRepository.findById(fileId);
    }
}
