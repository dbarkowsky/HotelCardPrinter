import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;

public class HelloWorldPringer implements Printable, ActionListener {

	int count = 0;
	CardPrinter arrivals = new CardPrinter();

    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
      CardPrinter arrivals = new CardPrinter();
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        Font nameFont = new Font("Comic Sans MS", 1, 20);
        FontMetrics metrics1 = g.getFontMetrics(nameFont);
        Font internetFont = new Font("Comic Sans MS", 1, 16);
        FontMetrics metrics2 = g.getFontMetrics(internetFont);
        	
      //  for(int i = 0; i < arrivals.names.length; i++)
       // {
        
        	String name = arrivals.names[count];
        	if(name != null)
        	{
	        	int width = metrics1.stringWidth(name);
	        	g.setFont(nameFont);
	        	g.drawString(name, (300-(width/2)), 25);
	        	width = metrics2.stringWidth(arrivals.login);
	        	g.setFont(internetFont);
	        	g.drawString(arrivals.login, (300-(width/2)), 320);
	        	width = metrics2.stringWidth(arrivals.password);
	        	g.drawString(arrivals.password, (300-(width/2)), 340);
        	}
     //   }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         PageFormat pf = job.defaultPage();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             
         for(int i = 0; i < arrivals.count; i++)
         {
        	 try {
                  job.print();
                  count++;
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
        	 
         }
    }

    public static void main(String args[]) 
    {
    	
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        JFrame f = new JFrame("Card Printer");
        f.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        JButton printButton = new JButton("Print Cards");
        printButton.addActionListener(new HelloWorldPringer());
        f.add("Center", printButton);
        f.pack();
        f.setVisible(true);
    }
}