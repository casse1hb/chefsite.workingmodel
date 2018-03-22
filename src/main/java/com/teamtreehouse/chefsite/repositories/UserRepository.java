package com.teamtreehouse.chefsite.repositories;

import java.util.List;

import com.teamtreehouse.chefsite.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Users", path = "Users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByUsername(@Param("name") String username);

}
