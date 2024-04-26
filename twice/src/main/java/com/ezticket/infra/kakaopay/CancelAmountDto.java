package com.ezticket.infra.kakaopay;

public class CancelAmountDto {
	private int total; // 이번 요청으로 취소된 전체 금액
    private int tax_free; // 이번 요청으로 취소된 비과세 금액
    private int vat; // 이번 요청으로 취소된 부가세 금액
    private int point; // 이번 요청으로 취소된 포인트 금액
    private int discount; // 이번 요청으로 취소된 할인 금액
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTax_free() {
		return tax_free;
	}
	public void setTax_free(int tax_free) {
		this.tax_free = tax_free;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
    
    

}
