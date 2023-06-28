package com.tyss.image.mysqlimage.imagedao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.image.mysqlimage.entity.Image;
import com.tyss.image.mysqlimage.imagerepo.ImageRepo;

@Repository
public class ImageDao {
	@Autowired
	private ImageRepo repo;
	
	public Image saveImage(Image image) {
		return repo.save(image);
	}
	
	public Image findImage(int id) {
		Optional<Image> opimage = repo.findById(id);
		if(opimage.isPresent()) {
			return opimage.get();
		}
		return null;
	}
	
	public Image deleteImage(int id) {
		Image existingimage = findImage(id);
		Image temp = findImage(id);
		if(existingimage!=null) {
			repo.delete(existingimage);
			return temp;
		}return null;
	}
}
