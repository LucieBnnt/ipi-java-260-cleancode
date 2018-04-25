import java.util.LinkedList;

public abstract class AbstractFrame {
	
    protected FrameDetail frameDetail = FrameDetail.NONE;
    protected Roll firstRoll;
    protected Roll secondRoll;
    
    // Bonus des prochains lancés avec strike et spare
    abstract int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames);
    abstract int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames);
	
    /**
     * Méthode pour donner le type de lancé
     */
    public void rollType() {
	if (RollDetail.FAULT.equals(this.firstRoll.getRollDetail()) 
		|| (!this.frameDetail.equals(FrameDetail.STRIKE) && RollDetail.FAULT.equals(this.secondRoll.getRollDetail()))) {
	    this.frameDetail = FrameDetail.FAULT;
	    
	} else if (this.getFirstRoll().getKeelCount() == 10) {
	    this.frameDetail = FrameDetail.STRIKE;
	    
	} else if (this.getFirstRoll().getKeelCount() + this.getSecondRoll().getKeelCount() == 10) {
	    this.frameDetail = FrameDetail.SPARE;
	}
    }

// GETTERS SETTERS
    public FrameDetail getFrameDetail() {
	return frameDetail;
    }

    public void setFrameDetail(FrameDetail frameDetail) {
	this.frameDetail = frameDetail;
    }

    public Roll getFirstRoll() {
	return firstRoll;
    }

    public void setFirstRoll(Roll firstRoll) {
	this.firstRoll = firstRoll;
    }

    public Roll getSecondRoll() {
	return secondRoll;
    }

    public void setSecondRoll(Roll secondRoll) {
	this.secondRoll = secondRoll;
    }
}
