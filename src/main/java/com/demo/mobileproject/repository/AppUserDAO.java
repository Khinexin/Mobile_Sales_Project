package com.demo.mobileproject.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.demo.mobileproject.domain.login.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
//@Transactional
//@PropertySource({"classpath:application.properties"})
//public class AppUserDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public AppUser findUserAccount(String userName) {
//        try {
//            String sql = "Select e from " + AppUser.class.getName() + " e " //
//                    + " Where e.userName = :userName ";
//
//            Query query = entityManager.createQuery(sql, AppUser.class);
//            query.setParameter("userName", userName);
//
//            return (AppUser) query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
//    }
//
//}

@Repository
public interface AppUserDAO extends JpaRepository<AppUser,Integer> {
    @Query("SELECT e FROM AppUser e WHERE e.userName = :userName")
    AppUser findUserAccount(@Param("userName") String userName);

}