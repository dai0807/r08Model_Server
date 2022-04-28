package com.model2.mvc.web.product;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserService;

 

@RestController
@Controller
@RequestMapping("/product/*")
public class ProductRestController {
	
	///Field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
 	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService ;
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
 	
	public ProductRestController(){
		System.out.println(this.getClass());
	}
	
	//==> classpath:config/common.properties  ,  classpath:config/commonservice.xml 참조 할것
	//==> 아래의 두개를 주석을 풀어 의미를 확인 할것
	
	@Value("#{commonProperties['pageUnit']}")
	//@Value("#{commonProperties['pageUnit'] ?: 3}")
	int pageUnit;
	
	@Value("#{commonProperties['pageSize']}")
	//@Value("#{commonProperties['pageSize'] ?: 2}")
	int pageSize;
	
	@RequestMapping( value="json/getProduct/{prodNo}/{tranCode}" ,  method=RequestMethod.GET )
	public Product getProduct(@PathVariable  int prodNo, @PathVariable String tranCode,   HttpServletRequest request ,   HttpSession session ) throws Exception {

		System.out.println("getProduct:: prodNo ::: 출력하기 " + prodNo );
		System.out.println("/user/getProduct : get");
		System.out.println("product ::: 출력하기 " + tranCode );

		Product product  = productService.getProduct(prodNo) ;
		product.setProTranCode(tranCode)  ;
		System.out.println("product ::: 출력하기 " + product );
 
		return product;
	}
	
	/*
	@RequestMapping( value="json/getProduct/{prodNo}/{tranCode}" ,  method=RequestMethod.GET )
	public Map getProduct(@PathVariable  int prodNo, @PathVariable String tranCode,   HttpServletRequest request ,   HttpSession session ) throws Exception {

		System.out.println("getProduct:: prodNo ::: 출력하기 " + prodNo );
		System.out.println("/user/getProduct : get");
		System.out.println("product ::: 출력하기 " + tranCode );

		Product product  = productService.getProduct(prodNo) ;
		System.out.println("product ::: 출력하기 " + product );

		Map <String,Object>  map = new HashMap<>();
		map.put("Product" , product ) ;
		map.put("tranCode" , tranCode ) ;

		return map;
	}
*/
	/*
	 	@RequestMapping(value = "getProduct" ,method=RequestMethod.GET  )
	public String getProduct(@RequestParam("prodNo" ) int prodNo,@RequestParam("tranCode" ) String tranCode ,  Model model ,  HttpServletRequest request ,   HttpSession session ) throws Exception 
	{
		System.out.println("getProduct:: prodNo ::: 출력하기 " + prodNo );

		System.out.println("/getProduct.do");
		
		
		
		Product product  = productService.getProduct(prodNo) ;
		
//		
//		String userId =((User)request.getSession(true).getAttribute("user")).getUserId(); //유저 아이디 뽑기 
//		User user = userService.getUser(userId);  // role이 유저만 구매하게 하려고
//
//		
		
		
		
		System.out.println("product ::: 출력하기 " + product );
		model.addAttribute("Product" , product ) ;
		model.addAttribute("tranCode" , tranCode ) ;
	//	model.addAttribute("user" , user ) ;

	
		return "forward:/product/getProduct.jsp";
		
	
	} 
	  
	 
	 * */
	
	
}