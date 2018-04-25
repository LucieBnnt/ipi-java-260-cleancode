import java.util.LinkedList;

public class NormalFrame extends AbstractFrame {
	
	@Override
	int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames) {
		AbstractFrame nextFrame = frames.get(frames.indexOf(this)+1);
		return nextFrame.getFirstRoll().getKeelCount() + nextFrame.getSecondRoll().getKeelCount();
	}

	@Override
	int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames) {
		AbstractFrame nextFrame = frames.get(frames.indexOf(this)+1);
		return nextFrame.getFirstRoll().getKeelCount();
	}
	
	public NormalFrame(int i, int j, RollDetail rollDetail, RollDetail rollDetailSecond) {
		this.firstRoll = new Roll(i, rollDetail);
		this.secondRoll = new Roll(j, rollDetailSecond);
		rollType();
	}
}
