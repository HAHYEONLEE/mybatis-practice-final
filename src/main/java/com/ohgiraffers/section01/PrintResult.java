package com.ohgiraffers.section01;

import java.util.List;

public class PrintResult {
    public void printProductList(List<ProductDTO> productList) {
        productList.forEach(System.out::println);
    }

    public void printProduct(ProductDTO product){

        System.out.println(product);
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode) { //각 케이스마다 동작에 실패할 시 출력할 구문들
            case "selectList" : errorMessage = "상품 목록 조회에 실패하였습니다."; break;
            case "insert" : errorMessage = "상품 등록에 실패하였습니다."; break;
            case "update" : errorMessage = "상품 수정에 실패하였습니다"; break;
            case "delete" : errorMessage = "상품 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

    public void printSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode){ //각 케이스마다 동작에 성공할 시 출력할 구문들
            case "insert" : successMessage = "신규 상품 등록이 완료 되었습니다."; break;
            case "update" : successMessage = "상품 수정이 완료 되었습니다."; break;
            case "delete" : successMessage = "상품 삭제가 완료 되었습니다."; break;
        }
        System.out.println(successMessage);
    }

}
