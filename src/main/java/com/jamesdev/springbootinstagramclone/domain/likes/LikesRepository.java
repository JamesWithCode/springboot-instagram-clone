package com.jamesdev.springbootinstagramclone.domain.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikesRepository extends JpaRepository<Likes,Integer> {

      @Modifying
      @Query(value="INSERT INTO likes(imageId, userId, createDate) VALUES (:imageId, :principalId, now())",nativeQuery = true)

      int like(int imageId, int principalId);
      @Modifying
      @Query(value="DELETE FROM likes WHERE imageId=:imageId AND userId=:principalId",nativeQuery = true)
      int unlike(int imageId, int principalId);



}
