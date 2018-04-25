import java.util.LinkedList;

public class FinalFrame extends AbstractFrame {

	private Roll thirdRoll;

	@Override
	public int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames) {
		return this.getThirdRoll().getKeelCount();
	}

	@Override
	public int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames) {
		return this.getThirdRoll().getKeelCount();
	}

	public FinalFrame(int i, int j, int k, RollDetail rollDetail, RollDetail rollDetailSecond, RollDetail rollDetailThird) {
		this.firstRoll = new Roll(i, rollDetail);
		this.secondRoll = new Roll(j, rollDetailSecond);
		this.thirdRoll = new Roll(k, rollDetailThird);
		rollType();
	}

	// GETTER SETTER
	public Roll getThirdRoll() {
		return thirdRoll;
	}

	public void setThirdRoll(Roll thirdRoll) {
		this.thirdRoll = thirdRoll;
	}
}
