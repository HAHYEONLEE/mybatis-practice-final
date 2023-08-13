package com.ohgiraffers.section01;


import java.util.List;
import java.util.Map;

public class ProductController {
    private final ProductService productService;
    private final PrintResult printResult;

    public ProductController(){
        productService = new ProductService();
        printResult = new PrintResult();
    }

    public void selectAllProduct() {

        List<ProductDTO> productList = productService.selectAllProduct();
        // productList 값이 null이 아닐 경우 모든 상품 리스트 출력
        if (productList != null) {
            printResult.printProductList(productList);
        }else {
            printResult.printErrorMessage("selectList");
        }

    }


    public void registProduct(Map<String, String> parameter) {

        String name = parameter.get("name");
        double alcohol = Double.parseDouble(parameter.get("alcohol"));
        String origin = parameter.get("origin");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        ProductDTO product = new ProductDTO();
        product.setName(name);
        product.setAlcohol(alcohol);
        product.setOrigin(origin);
        product.setCategoryCode(categoryCode);
        // 위의 값들이 정상적으로 입력되어 신규 상품 등록에 성공했을 경우 성공메세지 출력
        if (productService.registProduct(product)) {
            printResult.printSuccessMessage("insert");
        }else { // 등록에 실패했을 경우 에러메세지 출력
            printResult.printErrorMessage("insert");
        }
    }


    public void modifyProduct(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        double alcohol = Double.parseDouble(parameter.get("alcohol"));
        String origin = parameter.get("origin");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        ProductDTO product = new ProductDTO();
        product.setCode(code);
        product.setName(name);
        product.setAlcohol(alcohol);
        product.setOrigin(origin);
        product.setCategoryCode(categoryCode);
        // 위의 값들이 정상적으로 입력되어 상품 수정에 성공했을 경우 성공메세지 출력
        if (productService.modifyProduct(product)) {
            printResult.printSuccessMessage("update");
        }else { // 수정에 실패했을 경우 에러메세지 출력
            printResult.printErrorMessage("update");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {

        int code = Integer.parseInt(parameter.get("code"));
        // 상품 삭제에 성공했을 경우 성공메세지 출력
        if (productService.deleteProduct(code)) {
            printResult.printSuccessMessage("delete");
        }else { // 상품 삭제에 실패 했을 경우 에러메세지 출력
            printResult.printErrorMessage("delete");
        }
    }
}
