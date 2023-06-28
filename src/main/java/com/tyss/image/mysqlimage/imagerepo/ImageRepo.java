package com.tyss.image.mysqlimage.imagerepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.image.mysqlimage.entity.Image;

public interface ImageRepo extends JpaRepository<Image,Integer> {

}
