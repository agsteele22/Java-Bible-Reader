import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.io.File;
//import java.nio.file.Paths;
//import java.util.stream.Stream;
import java.io.*;

class Bible extends JFrame implements ItemListener {
	// frame
	static JFrame f, ff;
	// label
	static JLabel l, l1, l3;
	// combobox
	static JComboBox c1;
	static JComboBox c2;
	static JComboBox c3;
	
	// textbox
	static JTextArea textArea;
	final static JPanel p = new JPanel();
	// main class
	public static void main(String[] args)
	{
		// create a new frame
		
		f = new JFrame("Bible");
		// create a object
		final Bible s = new Bible();
		// set layout of frame
		f.getContentPane().setLayout(new FlowLayout());
		// array of string containing cities
		String s1[] = {"Genesis","Exodus","Leviticus","Numbers","Deuteronomy","Joshua","Judges","Ruth","1 Samuel","2 Samuel","1 Kings","2 Kings","1 Chronicles","2 Chronicles","Ezra","Nehemiah","Esther","Job","Psalms","Proverbs","Ecclesiastes","SongofSolomon","Isaiah","Jeremiah","Lamentations","Ezekiel","Daniel","Hosea","Joel","Amos","Obadiah","Jonah","Micah","Nahum","Habakkuk","Zephaniah","Haggai","Zechariah","Malachi"};
		// create checkbox
		c1 = new JComboBox(s1);
		// add ItemListener
		c1.addItemListener(s);
		// create labels
		l = new JLabel("Old Testament");
		l1 = new JLabel("New Testament");
		String s2[] = {"Matthew","Mark","Luke","John","Acts","Romans","1 Corinthians","2 Corinthians","Galatians","Ephesians","Philippians","Colossians","1 Thessalonians","2 Thessalonians","1 Timothy","2 Timothy","Titus","Philemon","Hebrews","James","1 Peter","2 Peter","1 John","2 John","3 John","Jude","Revelation"};
		// create checkbox
		c2 = new JComboBox(s2);
		c2.setSelectedItem(null);
		// add ItemListener
		c2.addItemListener(s);
		// create a new panel
		//p = = new JPanl;
		p.setLayout(new GridLayout(3,1,0,3));
		p.add(l);
		// add combobox to panel
		p.add(c1);
		p.add(l1);
		p.add(c2);
		// add panel to frame
		f.getContentPane().add(p,BorderLayout.WEST);
		// text
		textArea = new JTextArea(28, 60);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		f.getContentPane().add(scrollPane, BorderLayout.CENTER);
		textArea.setText(ReadFileToString("Genesis.txt"));
		textArea.setCaretPosition(0);
		
		// bible image button 
        JButton button = new JButton("Bible Image Gallery");
		button.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
  			f.getContentPane().removeAll();
  			p.removeAll();
  			String s11[] = {"1","2","3","4","5","6","7","8"};
  			c3 = new JComboBox(s11);
  			c3.addItemListener(s);
  			l = new JLabel("Bible Images:");
  			p.setLayout(new GridLayout(4,0,2,2));
  			p.add(l);
  			p.add(c3);
  			f.getContentPane().add(p,BorderLayout.WEST);		
  			l3 = new JLabel("");
  			ImageIcon imageIcon = new ImageIcon(new ImageIcon(Bible.class.getResource("1.jpg")).getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH));
  			l3.setIcon(imageIcon);
  			f.getContentPane().add(l3);
  			// frame code
  			//f.pack();
  			f.setSize(950, 800);
  			//f.show();
		  } 
		} );
		p.add(button);
		
		// frame code
		f.pack();
		// set the size of frame
		f.setSize(800, 600);
		f.show();
	}
	public void itemStateChanged(ItemEvent e)
	{
		// if the state combobox is changed
		if (e.getSource() == c1) {
			textArea.setText(ReadFileToString(c1.getSelectedItem() + ".txt"));
			textArea.setCaretPosition(0);
		}
		if (e.getSource() == c2) {
			textArea.setText(ReadFileToString(c2.getSelectedItem() + ".txt"));
			textArea.setCaretPosition(0);
		}
		if (e.getSource() == c3) {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(c3.getSelectedItem() + ".jpg")).getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH));
			l3.setIcon(imageIcon);
		}
		
	}
    private static String ReadFileToString(String filePath) 
       {
		   String bbtext = "";
		   
		   try
		   {
			   InputStream inn = Bible.class.getResourceAsStream(filePath); 
			   BufferedReader in = new BufferedReader(new InputStreamReader(inn));
			   
			  // FileReader filer = new FileReader(filePath);
			  // BufferedReader in = new BufferedReader(filer);
			   while (true) {
			     String line = in.readLine();
				 bbtext = bbtext + line + "\n";
			     if (line == null) { break; }
			   }
			   in.close();
		   }
		   catch(IOException except)
		   {
			   
		   }

		   return bbtext;
       }
}