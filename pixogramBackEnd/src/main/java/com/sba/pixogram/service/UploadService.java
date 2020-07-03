package com.sba.pixogram.service;

import com.sba.pixogram.entity.UploadPic;

import java.io.IOException;
import java.util.ArrayList;

public interface UploadService {
    UploadPic save(UploadPic dbFile) throws IOException;
    public ArrayList<UploadPic> findById(long fileId) throws IOException;
}
