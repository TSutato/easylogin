package com.example.easylogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.easylogin.model.dao.UserRepository;
import com.example.easylogin.model.entity.User;


@Controller
public class LoginController {

	/*↓new演算子を使うことなくインスタンス化される。*/
	@Autowired
	UserRepository userRepos;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	/*String　のデータを戻り値として返すloginというメソッドを作成。*/
	/*アノテーションを付与された因数はクライアントからのリクエストであることを意味し、HTML側で定義されたname属性を指定することで判断。*/
	@RequestMapping("/login")
	public String login(
		@RequestParam("userName") String userName,
		@RequestParam("password") String password,
		/*Modelは、レスポンスとしてクライアント側ｄに返すためのオブジェクト*/
		Model m) {
	
	  String message = "welcome! ";
	  /*UserRepositoryに追加したメソッドを呼び出してUserの一覧を取得。*/
	  List<User> users = userRepos.findByUserNameAndPassword(userName, password);
	  if(users.size() > 0) {
		  User user = users.get(0);
		  message += user.getFullName();
	  } else {
		  message += "guest";
	  }
	  /*今回は、addAttributeメソッドを使い、"message"というキー文字列に対してログイン結果によって分岐するメッセージを値に設定。*/
	  m.addAttribute("message", message);
	  
		return "login";
	}
	
}
