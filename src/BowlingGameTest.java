import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    BowlingGame game;
    
    @Before
    public void clean() {
    	this.game = null;
    	NormalFrame[] normalFrames = {
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE),
    		new NormalFrame(0, 0, RollDetail.NONE, RollDetail.NONE)
    		};
    	
    	FinalFrame finalFrame = new FinalFrame(0, 0, 0, RollDetail.NONE, RollDetail.NONE, RollDetail.NONE);
    	this.game = new BowlingGame(normalFrames, finalFrame);
    }
    
    /**
     * Simple game
     */
    @Test
    public void game(){
    	game.getFrames().remove(0);
    	game.getFrames().add(0, new NormalFrame(4, 3, RollDetail.NONE, RollDetail.NONE));
    	
    	game.getFrames().remove(3);
    	game.getFrames().add(3, new NormalFrame(2, 5, RollDetail.NONE, RollDetail.NONE));
    	
    	game.getFrames().remove(5);
    	game.getFrames().add(5, new NormalFrame(0, 6, RollDetail.NONE, RollDetail.NONE));
    	
    	game.getFrames().remove(6);
    	game.getFrames().add(6, new NormalFrame(5, 2, RollDetail.NONE, RollDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateScore(), is(27));
    }
    
    /**
     * Score à 0
     */
    @Test
    public void score0() { 
        assertThat(game.getScore(), is(0));
    	assertThat(game.getFrames().size(), is(10));
    }
    
    /**
     * Frames avec fautes
     */
    @Test
    public void framesWithFault(){
    	game.getFrames().remove(0);
    	game.getFrames().add(0, new NormalFrame(6, 2, RollDetail.NONE, RollDetail.NONE));
    	
    	game.getFrames().remove(3);
    	game.getFrames().add(3, new NormalFrame(1, 5, RollDetail.NONE, RollDetail.NONE));
    	
    	game.getFrames().remove(5);
    	game.getFrames().add(5, new NormalFrame(1, 6, RollDetail.FAULT, RollDetail.NONE));
    	
    	game.getFrames().remove(6);
    	game.getFrames().add(6, new NormalFrame(3, 4, RollDetail.FAULT, RollDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateScore(), is(14));
    }
    
    /** 
     * Strike dans la dernière frame
     */
    @Test
    public void strikeOnLastFrame(){
    	game.getFrames().remove(9);
    	game.getFrames().addLast(new FinalFrame(10, 0, 10, RollDetail.NONE, RollDetail.NONE, RollDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateScore(), is(20));
    }
    
    /** 
     * Spare dans la dernière frame
     */
    @Test
    public void spareOnLastFrame(){
    	game.getFrames().remove(9);
    	game.getFrames().addLast(new FinalFrame(7, 3, 4, RollDetail.NONE, RollDetail.NONE, RollDetail.NONE));
    	
    	assertThat(game.getFrames().size(), is(10));
        assertThat(game.calculateScore(), is(14));
    }
}
