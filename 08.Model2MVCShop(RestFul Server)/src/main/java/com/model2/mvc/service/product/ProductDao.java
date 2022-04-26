package com.model2.mvc.service.product;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;


public interface ProductDao {

	public   Product getProduct(int prodNo) throws Exception 	 ; // 제품 찾기
	
	public  List<Product>getProductList (Search search) throws Exception  ; // 리스트 가져오기 
	
	public void insertProduct(Product product) throws Exception  ; // 제품 넣기
	
	public void updateProduct(Product product) throws Exception  ;  // 제품 업뎃!

	public int getTotalCount(Search search) throws Exception ; 
	// 게시판 Page 처리를 위한 전체Row(totalCount)  return

	public int findTrandtranNo(int prodNo )  throws Exception; // 트랜코드 찾기 

}
