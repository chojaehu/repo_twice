package com.ezticket.infra.kakaopay;

public class CanceledAmountDto {
	private int total; // 취소된 전체 누적 금액
    private int tax_free; // 취소된 비과세 누적 금액
    private int vat; // 취소된 부가세 누적 금액
    private int point; // 취소된 포인트 누적 금액
    private int discount; // 취소된 할인 누적 금액
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
