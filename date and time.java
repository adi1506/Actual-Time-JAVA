public class NewApplet extends Applet implements Runnable{

     Thread t = null;
    int  hours=0,minutes=0,seconds=0;
    String timeString ="";
    
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
            setBackground(Color.red);
    }
    public void start()
    {
        t= new Thread (this);
        t.start();
    }
    public void run()
    {
        try
        {
            while(true)
            {
                Calendar cal = Calendar.getInstance();
                hours = cal.get(Calendar.HOUR_OF_DAY);
                if(hours > 12) hours-=12;
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);
                repaint();
                t.sleep(1000);
                
            }
        }
        catch(Exception e) {}
    
    
}
   public void paint(Graphics g)
   {
        g.setColor(Color.blue);
        g.drawString(timeString,50,50);
   }
}
