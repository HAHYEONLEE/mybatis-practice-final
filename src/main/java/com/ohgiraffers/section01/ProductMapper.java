package com.ohgiraffers.section01;

import java.util.List;
import java.util.Map;

public interface ProductMapper { //상품에 대한 CRUD를 제공하는 인터페이스

    // 모든 상품 조회 메소드로 리턴값으로 productDTO를 반환
    List<ProductDTO> selectAllProduct();

    // 상품을 추가하는 메소드로 product 매개변수를 받아 DB에 추가
    int insertProduct(ProductDTO product);

    // 상품을 수정하는 메소드로 product 매개변수를 받아 DB를 수정
    int modifyProduct(ProductDTO product);

    // 상품을 삭제하는 메소드로 정수 code를 매개변수를 받아 해당 code의 상품을 DB에서 삭제
    int deleteProduct(int code);

    // searchCriteria를 매개변수로 받아 해당 조건에 맞는 상품 리스트를 ProductDTO 객체의 리스트로 반환
    List<ProductDTO> searchProductByCategory(SearchCriteria searchCriteria);

    // map을 매개변수로 알콜 도수 범위를 지정하고, 해당 범위에 맞는 상품 리스트를 ProductDTO 객체의 리스트로 반환
    List<ProductDTO> searchProductByAlcohol(Map<String, Double> map);
}
