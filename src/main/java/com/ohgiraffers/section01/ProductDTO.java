package com.ohgiraffers.section01;

public class ProductDTO {

    private int code; //상품코드
    private String name; // 상품명
    private double alcohol; //알코올도수
    private String origin; //원산지
    private int categoryCode; //카테고리코드

    public ProductDTO() {
    }

    public ProductDTO(int code, String name, double alcohol, String origin, int categoryCode) {
        this.code = code;
        this.name = name;
        this.alcohol = alcohol;
        this.origin = origin;
        this.categoryCode = categoryCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", alcohol=" + alcohol +
                ", origin='" + origin + '\'' +
                ", categoryCode=" + categoryCode +
                '}';
    }
}
