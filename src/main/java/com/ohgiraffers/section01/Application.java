package com.ohgiraffers.section01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController productController = new ProductController();

        do{ // 최상위 메뉴 출력
            System.out.println("======== 메뉴 관리 ========");
            System.out.println("1. 상품 전체 조회");
            System.out.println("2. 조건별 상품 조회");
            System.out.println("3. 신규 상품 추가");
            System.out.println("4. 상품 수정");
            System.out.println("5. 상품 삭제");
            System.out.print("메뉴 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch (no) { // 선택한 메뉴 별 연결되는 기능
                         // 상품 전체 조회
                case 1 : productController.selectAllProduct(); break;
                         // 조건별 상품 조회
                case 2 : ifSubMenu(); break;
                         // 신규 상품 추가
                case 3 : productController.registProduct(inputProduct()); break;
                         // 상품 수정
                case 4 : productController.modifyProduct(inputModifyProduct()); break;
                         // 상품 삭제
                case 5 : productController.deleteProduct(inputProductCode()); break;
                default: // 주어진 케이스 외의 번호 입력 시 출력 구문
                    System.out.println("잘못 된 메뉴를 선택하셨습니다.");
            }

        }while (true);

    }

    private static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        do{ // 최상위 메뉴에서 case 2 선택 시 출력되는 메뉴
            System.out.println("======== 조건별 상품 조회 ========");
            System.out.println("1. 카테고리별 상품 조회");
            System.out.println("2. 알코올 도수로 상품 조회");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) { // 카테고리별 상품 조회
                case 1 : productService.searchProductByCategory(inputSupCategory()); break;
                          // 알코올 도수로 상품 조회
                case 2 : productService.searchProductByAlcohol(inputAlcohol()); break;
                          // 최상위 메뉴로 이동
                case 9 : return;
            }

        }while (true);
    }


    private static SearchCriteria inputSupCategory() {

        Scanner sc = new Scanner(System.in);
        // 원하는 카테고리명을 입력
        System.out.print("카테고리명을 입력해주세요(IPA, 라거, 필스너, 에일) : ");
        String value  = sc.nextLine();

        return new SearchCriteria("category", value);
    }

    private static double inputAlcohol() {

        Scanner sc = new Scanner(System.in);
        // 원하는 알코올 최대 도수 입력
        System.out.print("검색하실 최대 도수를 입력해주세요 : ");
        double alcohol = sc.nextDouble();

        return alcohol;
    }



    private static Map<String, String> inputProduct() {
        // 추가하고 싶은 상품의 정보를 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("상품 도수를 입력하세요 : ");
        double alcohol = sc.nextDouble();
        sc.nextLine();
        System.out.print("상품 원산지를 입력하세요 : ");
        String origin = sc.nextLine();
        System.out.print("상품 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("alcohol", Double.toString(alcohol));
        parameter.put("origin", origin);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyProduct() {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 상품 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 상품 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("수정할 상품 도수를 입력하세요 : ");
        double alcohol = sc.nextDouble();
        sc.nextLine();
        System.out.print("수정할 상품 원산지를 입력하세요 : ");
        String origin = sc.nextLine();
        System.out.print("수정할 상품 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("alcohol", Double.toString(alcohol));
        parameter.put("origin", origin);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputProductCode() {

        Scanner sc = new Scanner(System.in);
        // 삭제하고 싶은 상품코드 입력
        System.out.print("상품 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

}
