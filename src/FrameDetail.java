
public enum FrameDetail {
	FAULT("F"),
	STRIKE("X"),
	SPARE("/"),
	NONE("");
	
	private String detail;
	
	private FrameDetail(String detail) {
		this.detail = detail;
	}
}
