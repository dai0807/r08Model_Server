package com.model2.mvc.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;


//==> 회원관리 RestController
@RestController
@RequestMapping("/user/*")
public class UserRestController {
	
	///Field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	//setter Method 구현 않음
	
	@Value("#{commonProperties['pageUnit']}")
	int pageUnit;
	@Value("#{commonProperties['pageSize']}")
	int pageSize;
	
	
	
	public UserRestController(){
		System.out.println(this.getClass());
	}
	
	@RequestMapping( value="json/getUser/{userId}", method=RequestMethod.GET )
	public User getUser( @PathVariable String userId ) throws Exception{
		
		System.out.println("/user/json/getUser : GET :: "+  userId);
		
		//Business Logic
		return userService.getUser(userId);
	}

	@RequestMapping( value="json/login", method=RequestMethod.POST )
	public User login(	@RequestBody User user,
									HttpSession session ) throws Exception{
	
		System.out.println("/user/json/login : POST");
		//Business Logic
		System.out.println("::"+user);
		User dbUser=userService.getUser(user.getUserId());
		
		if( user.getPassword().equals(dbUser.getPassword())){
			session.setAttribute("user", dbUser);
		}
		
		return dbUser;
	}
	
	@RequestMapping( value="json/addUser", method=RequestMethod.POST )
	public String addUser( @RequestBody  User user ) throws Exception {

		System.out.println("/user/addUser : POST");
		System.out.println("유저 왔나뇨"+ user );
		//Business Logic
		int result = userService.addUser(user);

		System.out.println("addUser result " + result );
		return "addUser OK" + result ;
	}
	
	
	@RequestMapping( value="json/updateUser", method=RequestMethod.POST )
	public String updateUser( @RequestBody  User user ) throws Exception {

		System.out.println("/user/updateUser : POST");
		System.out.println("유저 왔나뇨"+ user );
		//Business Logic
		userService.updateUser(user);

		System.out.println("updateUser result " +user  );
		return "updateUser OK" + user ;
	}
	
	
	@RequestMapping( value="json/logout", method=RequestMethod.POST )
	public void logout( HttpSession session ) throws Exception {

		System.out.println("/user/logout : POST");
		session.invalidate();
		System.out.println("logout 세션 없앰 ");
		 

	}

	// 이제부터 해야함 ! 
//	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
//	public Map<String, Object>  checkDuplication( @RequestBody String userId ) throws Exception {
//	
//		
//		System.out.println("/user/checkDuplication : POST");
//		boolean result=userService.checkDuplication(userId);
//		
//		System.out.println("::::"+ userId + "  의  checkDuplication 값은      " + result  );
//		
//		Map <String,Object>  map = new HashMap<>();
//		
//		map.get(userId) ;
//		map.get(result) ;
//		
//		 return map ;
//	}
	
	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
	public Map<String, Object>  checkDuplication_JsonSimpe( @RequestBody User user  ) throws Exception {
	
		
		System.out.println("/user/checkDuplication : POST");
		boolean result=userService.checkDuplication(user.getUserId());
		
		System.out.println("::::"+ user.getUserId() + "  의  checkDuplication 값은      " + result  );
		
		Map <String,Object>  map = new HashMap<>();
		
		map.put("userId",user.getUserId()) ;
		map.put("result",result) ;
		
		 return map ;
	}
	
//	@RequestMapping( value="json/checkDuplication", method=RequestMethod.POST )
//	public Map<String, Object>  checkDuplication_Codehaus ( @RequestBody User user  ) throws Exception {
//	
//		
//		System.out.println("/user/checkDuplication : POST");
//		boolean result=userService.checkDuplication(user.getUserId());
//		
//		System.out.println("::::"+ user.getUserId() + "  의  checkDuplication 값은      " + result  );
//		
//		Map <String,Object>  map = new HashMap<>();
//		
//		map.put("userId",user.getUserId()) ;
//		map.put("result",result) ;
//		
//		 return map ;
//	}
//	
	@RequestMapping( value="json/listUser")
	public Map<String, Object> listUser_Codehaus( @RequestBody Search search  ) throws Exception {
	
	//	 @ModelAttribute("search") Search search
		System.out.println("/user/listUser : GET / POST");
		
		if(search.getCurrentPage() ==0 ){
			search.setCurrentPage(1);
		}
		search.setPageSize(pageSize);
		
 		
		Map<String , Object> map=userService.getUserList(search);
		Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println(resultPage);
		
		
		map.put("list", map.get("list")) ;
		map.put("resultPage", resultPage);
		map.put("search", search);
	
		 return map ;
	}
	
}