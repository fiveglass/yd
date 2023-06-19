package co.shop.kakaopay.service;

public class KakaopayResponseVO {

	private String tid;
	private String nextRedirectPcUrl;
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getNextRedirectPcUrl() {
		return nextRedirectPcUrl;
	}
	public void setNextRedirectPcUrl(String nextRedirectPcUrl) {
		this.nextRedirectPcUrl = nextRedirectPcUrl;
	}
	
	
}
