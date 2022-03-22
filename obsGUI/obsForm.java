package obsGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class obsForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtVize;
	private JTextField txtFinal;
	private String HNotu ;
	private JLabel lblProfil;
	private double ort;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					obsForm frame = new obsForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void print(int a)
	{
		harfNotuHesapla(ort);
		switch (a) 
		{
		    case 1:  lblProfil.setText("<html>Mehmet Akif Ersoy Üniversitesi <br/>Not Ortalamasý : "+ort+"<br/>Harf Notu : "+HNotu+" </html>");
			    break;
		    case 2:  lblProfil.setText("<html>Milli Savunma Üniversitesi <br/> Not Ortalamasý : "+ort+" <br/> Harf Notu : "+HNotu+" </html>");
		        break;
		    case 3:  lblProfil.setText("<html>Kara Deniz Üniversitesi <br/> Not Ortalamasý : "+ort+" <br/> Harf Notu : "+HNotu+" </html>");
		        break;
		    case 4:  lblProfil.setText("<html>Ýstanbul Teknik Üniversitesi <br/> Not Ortalamasý : "+ort+" <br/> Harf Notu : "+HNotu+" </html>");
		        break;
	       default : lblProfil.setText("<html>Lütfen bir üniversite seçtiðinizden <br/>emin olun!!</html>");
	            break;

		}
	}
	
	public void calculate(int a) 
	{
		
		
		double vize = Double.parseDouble(txtVize.getText());
		double finall =  Double.parseDouble(txtFinal.getText());

		 switch (a)		
		 {
		 	case 1:  ort = vize*0.4 +finall*0.6;  print(1);
			    break;
		 	case 2:  ort = vize*0.35 +finall*0.65;  print(2);
	            break;        
		 	case 3:  ort = vize*0.25 +finall*0.75;  print(3);
                 break;
		 	case 4:  ort = vize*0.5 +finall*0.5; print(4);
                 break;  
            default :  ort = vize*0.5 +finall*0.5;	print(5);           
		          break;   
	
		}
		 
	}
	public void harfNotuHesapla (double ort)
    {
        if(ort>=90) 
        {
        	HNotu="AA";
        }
        else if (ort>=85) 
        {
        	HNotu="BA";
        } 
        else if (ort>=80) 
        {
        	HNotu="BB";
        }
        else if (ort>=75) 
        {
        	HNotu="CB";
        }
        else if (ort>=70)
        {
        	HNotu="CC";
        }
        else  if (ort>=65)
        {
        	HNotu="DC";
        }
        else if (ort>=60) 
        {
        	HNotu="DD";
        }
        else if (ort>=1) 
        {
        	HNotu="FD";
        }
        else if(ort==0) 
        {
        	HNotu="FF";
        }
    }
	

	public static boolean isInteger(String str) 
	{
		 int count = 0 ;
	     for (int i = 0; i < str.length(); i++) 
		 {
			 int ch = (int)str.charAt(i);
			 if (ch>47&&ch<58) 
			 {
			     count++;
			 }
	 
	     }
		 if (count==str.length()) 
		 {
			return true;
		 }
		 if (str.equals(null)) 
		 {
			return false;
		 }
		 return false;
		  
		 
    } 
    public boolean inputControl() 
    {
    	double vizeNot = Double.parseDouble(txtVize.getText());
		double finallNot =  Double.parseDouble(txtFinal.getText());

		if ((vizeNot>100)||(vizeNot<0)|| (finallNot>100)||(finallNot<0)) 
	    {
			 return false;
		}

    	return true;
    }
   

	/**
	 * Create the frame.
	 */
	public obsForm() {
		setTitle("OBS\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> cBox = new JComboBox<String>();
		cBox.setModel(new DefaultComboBoxModel<String>(new String[] {"\u00DCniversite Se\u00E7iniz", "MAK\u00DC", "MS\u00DC", "AKD\u00DC", "\u0130T\u00DC"}));
		cBox.setBounds(34, 165, 136, 33);
		contentPane.add(cBox);
		
		JLabel lblNewLabel = new JLabel("OBS NOT HESAPLAMA ");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(122, 21, 216, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vize Notu :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 93, 84, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Final Notu :");
		lblNewLabel_2.setBounds(31, 127, 64, 28);
		contentPane.add(lblNewLabel_2);
		
		txtVize = new JTextField();
		txtVize.setHorizontalAlignment(SwingConstants.CENTER);
		txtVize.setBounds(96, 96, 74, 19);
		contentPane.add(txtVize);
		txtVize.setColumns(10);
		
		txtFinal = new JTextField();
		txtFinal.setHorizontalAlignment(SwingConstants.CENTER);
		txtFinal.setBounds(96, 132, 74, 19);
		contentPane.add(txtFinal);
		txtFinal.setColumns(10);
		
		JButton btnCalculate = new JButton("Hesapla");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(txtVize.getText().isEmpty()) && !(txtFinal.getText().isEmpty()))
				{
					if ((isInteger(txtVize.getText())  &&  isInteger(txtFinal.getText())) && inputControl())
					{
						calculate(cBox.getSelectedIndex());	
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Hatalý ders notu lütfen tekrar kontrol ediniz!!");		
					}
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Notlar boþ girilemez !!");		
				}

			}
		});
		btnCalculate.setBounds(34, 208, 136, 33);
		contentPane.add(btnCalculate);
		
		lblProfil = new JLabel("");
		lblProfil.setBounds(191, 115, 216, 83);
		contentPane.add(lblProfil);
	}
	
}
