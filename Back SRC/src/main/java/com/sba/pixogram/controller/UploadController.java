package com.sba.pixogram.controller;

import java.io.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.sba.pixogram.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.sba.pixogram.entity.ImageUrl;
import com.sba.pixogram.entity.UploadPic;
import com.sba.pixogram.repository.UploadRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	UploadService uploadService;

	List<String> files = new ArrayList<String>();
	
	@PostMapping("/storeImages/{userId}")
	public UploadPic storeFile(@RequestParam("file") MultipartFile file,@PathVariable long userId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        UploadPic dbFile = new UploadPic(fileName, file.getContentType(),compressBytes(file.getBytes()),userId);
        return uploadService.save(dbFile);
    }

	 @GetMapping("/getUserMedia/{userId}")
	 public List<UploadPic> getUserMedia(@PathVariable long userId ) throws IOException {
		 ArrayList<UploadPic> dbFile = new ArrayList<UploadPic>();
	     dbFile=uploadService.findById(userId);
		 ArrayList<UploadPic> img = new ArrayList<UploadPic>();
	     for(UploadPic u: dbFile )
		 {
		 	UploadPic pic= new UploadPic(u.getFileName(),u.getFileType(),decompressBytes(u.getData()),userId);
		 	img.add(pic);
		 }
	     return img;

	 }
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}

		return outputStream.toByteArray();

	}
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (DataFormatException e) {
e.printStackTrace();
		}
		return outputStream.toByteArray();
	}
}
