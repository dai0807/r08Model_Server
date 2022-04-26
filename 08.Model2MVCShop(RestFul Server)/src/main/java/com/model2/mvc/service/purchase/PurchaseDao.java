package com.model2.mvc.service.purchase;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseDao {
	
//상품추가
	public void addPurchase(Purchase purchase)throws Exception  ;

	
	//제품 넘버로 트랜 코드 찾기
	public Purchase getPurchase(int tranNo) throws Exception;
 
	// 판매 리스트 가져오기
	//public Map<String, Object> getSaleList(Search search) throws Exception ;
	 public  List<Purchase> getSaleList(Map<String,Object> map )   throws Exception ;
	

	
	// 구매  리스트 가져오기
//	public Map<String, Object> getPurchaseList(Search search , String userId ) throws Exception ;
	public List<Purchase> getPurchaseList(Map<String,Object> map ) throws Exception ;
	//판매내역 업데이트
	public void updatePurchase(Purchase purchase) throws Exception  ;
	
	//트랜코드 변경하기 
//	public void tranCode(Purchase purchase) throws Exception ;
	public void updatetranCode(Purchase purchase) throws Exception ;
	
	
 //게시판 Page 처리를 위한 전체Row(totalCount)  return
 public int getTotalCount(Search search) throws Exception ; 
	
	
	
}
