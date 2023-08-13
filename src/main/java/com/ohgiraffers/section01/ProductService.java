package com.ohgiraffers.section01;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.Template.getSqlSession;


public class ProductService {

    private ProductMapper productMapper;
    public List<ProductDTO> selectAllProduct() {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        // ProductMapper 인터페이스에서 selectAllProduct 메소드를 호출하여 ProductDTO의 리스트 형태로 productList에 저장
        List<ProductDTO> productList = productMapper.selectAllProduct();

        sqlSession.close();

        return productList;
    }


    public void searchProductByCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        // ProductMapper 인터페이스에서 searchProductBySupCategory 메소드를 호출하여 ProductDTO의 리스트 형태로 productList에 저장
        List<ProductDTO> productList = productMapper.searchProductByCategory(searchCriteria);
        // productList 값이 null이 아니고 0보다 클 때 리스트의 각 항목들은 출력
        if (productList != null && productList.size() > 0){
            productList.forEach(System.out::println);
        } else { // 위의 조건을 만족하지 않을 경우 아래 구문 출력
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();

    }

    public void searchProductByAlcohol(double alcohol) {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);

        Map<String, Double> map = new HashMap<>();
        map.put("alcohol", alcohol);
        // ProductMapper 인터페이스에서 searchProductByAlcohol 메소드를 호출하여 ProductDTO의 리스트 형태로 productList에 저장
        List<ProductDTO> productList = productMapper.searchProductByAlcohol(map);
        // productList 값이 null이 아니고 0보다 클 때 리스트의 각 항목들은 출력
        if (productList != null && productList.size() > 0){
            productList.forEach(System.out::println);
        } else { // 위의 조건을 만족하지 않을 경우 아래 구문 출력
            System.out.println("검색 결과가 존재하지 않습니다.");
        }
        sqlSession.close();
    }

    public boolean registProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        // ProductMapper 인터페이스에서 insertProduct 메소드를 호출하여 그 값을 정수 result에 할당
        int result = productMapper.insertProduct(product);
        // result 값이 0보다 크면 결과를 DB에 저장
        if(result > 0){
            sqlSession.commit();
        }else { // 위의 조건이 충족되지 않으면 저장되지 않고 이전 상태로 돌아감
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;

    }

    public boolean modifyProduct(ProductDTO product) {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        // ProductMapper 인터페이스에서 modifyProduct 메소드를 호출하여 그 값을 정수 result에 할당
        int result = productMapper.modifyProduct(product);
        // result 값이 0보다 크면 결과를 DB에 저장
        if(result > 0){
            sqlSession.commit();
        }else { // 위의 조건이 충족되지 않으면 저장되지 않고 이전 상태로 돌아감
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }

    public boolean deleteProduct(int code) {

        SqlSession sqlSession = getSqlSession();
        productMapper = sqlSession.getMapper(ProductMapper.class);
        // ProductMapper 인터페이스에서 deleteProduct 메소드를 호출하여 그 값을 정수 result에 할당
        int result = productMapper.deleteProduct(code);
        // result 값이 0보다 크면 결과를 DB에 저장
        if(result > 0){
            sqlSession.commit();
        }else { // 위의 조건이 충족되지 않으면 저장되지 않고 이전 상태로 돌아감
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0;
    }


}
