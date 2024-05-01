package com.ezticket.infra.kakaopay;



import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ezticket.infra.performance.PerformanceDto;

import jakarta.servlet.http.HttpSession;

@Service
public class KakaoPayService {
	
	
	private static final String Host = "https://kapi.kakao.com";

   //@Value("#{sellentProperty['kakao.admin']}")
    private String kakaoAdminKey = "20b0d4eeab076cff4344136c30e210bb";

    private KakaoPayDto kakaoPayDto;
    private KakaoApproveDto kakaoApproveDto;
    private CancelDto kakaoPayCancelDto;

 // 결제요청
    public String kakaoPayReady(PerformanceDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // 정확한 에러 파악을 위해 생성
        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaoAdminKey); // 어드민 키
        headers.add("Accept", "application/json");
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        
        // Server Request Body : 서버 요청 본문
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME"); // 가맹점 코드 - 테스트용
        params.add("partner_order_id", "1001"); // 주문 번호
        params.add("partner_user_id", dto.getMbSeq()); // 회원 아이디
        params.add("item_name", dto.getPrTitle()); // 상품 명
        params.add("quantity", "1"); // 상품 수량
        params.add("total_amount",dto.getTotalprice()); // 상품 가격
        params.add("tax_free_amount", "0"); // 상품 비과세 금액
        params.add("prSeq", dto.getPrSeq());
        params.add("approval_url", "http://localhost:8081/kakaoPaySuccess"+"?"+"pmpaymentMethod=" + 2 + "&" + dto.getTicketurl()); // 성공시 url
        params.add("cancel_url", "http://localhost:8081/kakao"); // 실패시 url
        params.add("fail_url", "http://localhost:8081/useBookBuy" + "?" + dto.getTicketurl());
        
        // 헤더와 바디 붙이기
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
            kakaoPayDto = restTemplate.postForObject(new URI(Host + "/v1/payment/ready"), body, KakaoPayDto.class);
            return kakaoPayDto.getNext_redirect_pc_url();

        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "/kakao";
    }
    
 // 결제결과정보
    public KakaoApproveDto kakaoPayInfo(String pg_token, HttpSession httpSession,PerformanceDto dto) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // 정확한 에러 파악을 위해 생성
        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaoAdminKey); // 어드민 키
        headers.add("Accept", "application/json");
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        
        // Server Request Body : 서버 요청 본문
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");// 가맹점 코드 - 테스트용
        params.add("tid", kakaoPayDto.getTid());
        params.add("partner_order_id", "1001");// 주문 번호
        params.add("partner_user_id", dto.getMbSeq());// 회원 아이디
        params.add("pg_token", pg_token);
        params.add("total_amount", dto.getTotalprice());  
        
        // 헤더와 바디 붙이기
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
        	kakaoApproveDto = restTemplate.postForObject(new URI(Host + "/v1/payment/approve"), body, KakaoApproveDto.class);
        	kakaoApproveDto.setResultInfo(kakaoApproveDto.toString());

            httpSession.setAttribute("sessTid"    , kakaoPayDto.getTid());
            httpSession.setAttribute("sessTotal"  , kakaoApproveDto.getAmount().getTotal());
            httpSession.setAttribute("sessTaxFree", kakaoApproveDto.getAmount().getTax_free());
            httpSession.setAttribute("sessVat"    , kakaoApproveDto.getAmount().getTax());
            
            return kakaoApproveDto;
        
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
 // 결제취소
    public CancelDto kakaoPayCancel(HttpSession httpSession) {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // 정확한 에러 파악을 위해 생성
        // Server Request Header : 서버 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaoAdminKey); // 어드민 키
        headers.add("Accept", "application/json");
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        
        // Server Request Body : 서버 요청 본문
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid"                   , "TC0ONETIME"); // 가맹점 코드 - 테스트용
        params.add("tid"                   , httpSession.getAttribute("sessTid").toString()); // 환불할 결제 고유 번호
        params.add("cancel_amount"         , httpSession.getAttribute("sessTotal").toString()); // 환불 금액
        params.add("cancel_tax_free_amount", httpSession.getAttribute("sessTaxFree").toString()); // 환불 비과세 금액
        params.add("cancel_vat_amount"     , httpSession.getAttribute("sessVat").toString()); // 환불 부가세
        
        // 헤더와 바디 붙이기
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {
        	kakaoPayCancelDto = restTemplate.postForObject(new URI(Host + "/v1/payment/cancel"), body, CancelDto.class);
        	kakaoPayCancelDto.setResultInfo(kakaoPayCancelDto.toString());
        	return kakaoPayCancelDto;

        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        
        return null;
    } 

}
