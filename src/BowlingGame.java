import java.util.LinkedList;

public class BowlingGame {

    private int score;
    private static final int SCORE_SPARE_STRIKE = 10; 
    LinkedList<AbstractFrame> frames = new LinkedList<>();
    
    /**
     * Méthode de calcul du score
     * @return score
     */
    public int calculateScore() {
    	int score = 0;
    	LinkedList<AbstractFrame> frames = this.getFrames();
    	
    	// get all the frames from the game
    	for (AbstractFrame frame :frames) {
    	    // get the score of the frames' rolls
    	    if (FrameDetail.FAULT.equals(frame.getFrameDetail())) {
    		score += 0;
    		
    	    } else if (FrameDetail.STRIKE.equals(frame.getFrameDetail())) {
    		score += SCORE_SPARE_STRIKE + frame.getThisNextFrameStrikeBonus(frames);
    		
    	    } else if (FrameDetail.SPARE.equals(frame.getFrameDetail())) {
    		score += SCORE_SPARE_STRIKE + frame.getThisNextFrameSpareBonus(frames);
    		
    	    } else {
    		score += frame.getFirstRoll().getKeelCount() + frame.getSecondRoll().getKeelCount();
    	    }
    	}
    	
    	return score;
    }
    
    /**
     * Constructeur
     * @param casualFrames
     * @param finalFrame
     */
    public BowlingGame(NormalFrame[] normalFrames, FinalFrame finalFrame) {
    	int i = 0;
    	
    	while (i <= 8) {
    	    this.frames.addLast(normalFrames[i]);
    	    
    	    if (i == 8) {
    		this.frames.addLast(finalFrame);
    	    }
    	    i++;
    	}
 
    	this.score = calculateScore();
    }
    
    
// GETTERS SETTERS
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
	this.score = score;
    }

    public LinkedList<AbstractFrame> getFrames() {
	return frames;
    }

    public void setFrames(LinkedList<AbstractFrame> frames) {
	this.frames = frames;
    }  
}
