package com.example.easylogin.model.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*userテーブルのEntityにアクセスするために指定。*/
import com.example.easylogin.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*メソッド宣言*/
	List<User> findByUserNameAndPassword(String userName,String password);
}

