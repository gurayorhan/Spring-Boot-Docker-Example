package com.elasticsearch.repository;

import com.elasticsearch.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,String> {

    List<User> findByAdLikeOrSoyadiLike(String ad,String soyadi);

}
