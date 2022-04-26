package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;

@Service("productServiceImpl")  // 구현 
public class ProductServiceImpl implements ProductService{

	@Autowired
	@Qualifier("productDaoImpl")
		private ProductDao productDao ;	
		public void setProudDao(ProductDao productDao) {
			this.productDao = productDao ;
			// u원래는 xml 맵핑을 했었는데 Service와 dao 맵핑을 service 에서 이것을 쓴다를 맵핑함 

		}
		// findTrannNo 단위 테스트는 곧 하기를 바람 
	
		public ProductServiceImpl() {
			System.out.println(this.getClass());
	 	}
	 	public void addProduct(Product product) throws Exception {
	  		System.out.println("product service impp :  " + product  );
	 		productDao.insertProduct(product ) ;
	  		
		}

	 	public void updateProduct(Product product) throws Exception {
	  		productDao.updateProduct(product);
		}

	 	public Product getProduct(int prodNo) throws Exception {
	  		System.out.println("서비스 다오 getProduct  :: " + prodNo );
	  		System.out.println( "나와라 " +productDao.getProduct(prodNo));
			return productDao.getProduct(prodNo);
		}

	 	public Map<String, Object> getProductList(Search search) throws Exception {
			// DAO에서 List랑 get TotalCount 받아서 Map 넣어서 던지기 
	 		List<Product> list = productDao.getProductList(search) ;
	 		int totalCount 		=  productDao.getTotalCount(search) ;
//	 		System.out.println("totalCount ::" + totalCount );
//	 		System.out.println("list ::" + list );

	 		Map<String,Object>map = new HashMap<String, Object>() ;
	 		map.put("list", list ) ;
	 		map.put("totalCount", new Integer(totalCount) ) ;

	 		return map;
	 		
	 
		}

 	 	public int findTrandtranNo(int prodNo) throws Exception {
			// TODO Auto-generated method stub
			return productDao.findTrandtranNo(prodNo);
		}

	}
