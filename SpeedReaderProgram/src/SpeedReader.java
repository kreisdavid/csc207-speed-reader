import java.awt.*;
import java.io.IOException;

public class SpeedReader {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {
		// TODO Auto-generated method stub
		
		//checks to make sure that the program is called correctly
		//quits program otherwise, with message indicating correct usage
		if(args.length != 5){
			System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
			System.exit(0);
		}
		
		DrawingPanel panel = new DrawingPanel(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		Graphics g = panel.getGraphics();
		Font f = new Font("Courier", Font.BOLD, Integer.parseInt(args[3]));
		g.clearRect(0, 0, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		g.setFont(f);
		g.setColor(new Color(255, 255, 255));
		WordGenerator read = new WordGenerator(args[0]);
		
		while(read.hasNext()){
			g.drawString(read.next(), Integer.parseInt(args[1]) / 2, Integer.parseInt(args[2]) / 2);
			Thread.sleep(60000 / Integer.parseInt(args[4]));
			g.clearRect(0, 0, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		}
		g.drawString("Word Count: " + read.getWordCount(), Integer.parseInt(args[1]) / 5, Integer.parseInt(args[2]) / 3);
		g.drawString("Sentence Count: " + read.getSentenceCount(), Integer.parseInt(args[1]) / 5, Integer.parseInt(args[2]) / 2);
	}

}