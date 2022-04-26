package com.model2.mvc.service.product;

import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;

public interface ProductService {

	// 제품 추가 
	public void addProduct(Product product) throws Exception;
	
	//제품 업데이트
	public void updateProduct(Product product) throws Exception;

	//제품 가져오기
	public Product getProduct (int prodNo) throws Exception;

	//리스트 가져오기
	public  Map<String, Object> getProductList(Search search)  throws Exception;
	
	// public int findTrandtranNo(int prodNo )  throws Exception; 이건 아직 

	//트랜코드 찾기 
	public int findTrandtranNo(int prodNo )  throws Exception;

	
	
}
