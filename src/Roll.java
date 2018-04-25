public class Roll {
	
    private int keelCount;
    private RollDetail rollDetail;

    public Roll(int fallenKeels, RollDetail rollDetail) {
	this.rollDetail = rollDetail;
	
	if (RollDetail.FAULT.equals(this.rollDetail)) {
	    this.keelCount = 0;
	} else {
	    this.keelCount = fallenKeels;
	}
    }
	
// GETTERS SETTERS
    public int getKeelCount() {
	return keelCount;
    }

    public void setKeelCount(int keelCount) {
	this.keelCount = keelCount;
    }

    public RollDetail getRollDetail() {
	return rollDetail;
    }

    public void setRollDetail(RollDetail rollDetail) {
	this.rollDetail = rollDetail;
    }
}
