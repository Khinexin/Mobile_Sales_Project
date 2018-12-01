package com.demo.mobileproject.repository;
import java.util.List;

import javax.persistence.EntityManager;

import com.demo.mobileproject.domain.login.AppRole;
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
//public class AppRoleDAO {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    public List<String> getRoleNames(Integer userId) {
//        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
//                + " where ur.appUser.userId = :userId ";
//
//        Query query = this.entityManager.createQuery(sql, String.class);
//        query.setParameter("userId", userId);
//        return query.getResultList();
//    }
//
//}

@Repository
public interface AppRoleDAO extends JpaRepository<AppRole, Integer> {
    @Query("SELECT ur.appRole.roleName FROM UserRole ur WHERE ur.appUser.userId = :userId ")
    List<String> getRoleNamesByUserId(@Param("userId") Integer userId);
}