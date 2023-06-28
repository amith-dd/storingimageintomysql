package com.tyss.image.mysqlimage.imageservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.image.mysqlimage.entity.Image;
import com.tyss.image.mysqlimage.imagedao.ImageDao;
@Service
public class ImageService {
	@Autowired
	private ImageDao dao;
	
	
	public ResponseEntity<Image> saveImage(MultipartFile file) throws IOException{
		Image image = new Image();
		image.setImagedata(file.getBytes());
		dao.saveImage(image);
		return new ResponseEntity<Image>(image,HttpStatus.CREATED);
	}
	
	public ResponseEntity<byte[]> findImage(int id){
		Image image = dao.findImage(id);
		if(image!=null) {
			return  ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(image.getImagedata().length).body(image.getImagedata());
		}
		else {
			return null;
		}
	}
	
	public ResponseEntity<byte[]> deleteImage(int id){
		Image image = dao.deleteImage(id);
		if(image!=null) {
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).contentLength(image.getImagedata().length).body(image.getImagedata());
		}else {
			return null;
		}
	}
	
	public ResponseEntity<byte[]> findpdf(int id){
		Image image = dao.findImage(id);
		if(image!=null) {
			return  ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).contentLength(image.getImagedata().length).body(image.getImagedata());
		}
		else {
			return null;
		}
	}
}

