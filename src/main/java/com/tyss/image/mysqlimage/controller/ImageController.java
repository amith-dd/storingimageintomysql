package com.tyss.image.mysqlimage.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.image.mysqlimage.entity.Image;
import com.tyss.image.mysqlimage.imageservice.ImageService;
@RestController
@RequestMapping("/image")
public class ImageController {
	@Autowired
	private ImageService service;
	
	@PostMapping
	public ResponseEntity<Image> saveImage(@RequestParam MultipartFile file) throws IOException{
		return service.saveImage(file);
	}
	@GetMapping
	public ResponseEntity<byte[]> findImage(@RequestParam int id){
		return service.findImage(id);
	}
	@DeleteMapping
	public ResponseEntity<byte[]> deleteimage(@RequestParam int id){
		return service.deleteImage(id);
	}
	@GetMapping("/pdf")
	public ResponseEntity<byte[]> findpdf(@RequestParam int id){
		return service.findImage(id);
	}
}
