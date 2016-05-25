import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class ChessBoard extends JPanel  implements MouseListener
{
	public static final int MARGIN = 40;	//�߾�
	public static final int GRID_SPAN = 40;//������
	public static final int ROWS = 9;		//9��
	public static final int COLS = 9;		//9��
	
	int chessCount;					
	Point[] chessList = new Point[(ROWS+1)*(COLS+1)];		//�����Լ�����
	int xIndex,yIndex;									//x�����Լ�y����
	int val;					//��Ž��
	
	boolean isBlack = true;
	boolean gameOver = false;
	
	
	public ChessBoard()
	{
		setBackground(Color.ORANGE);		//����panel������ɫ
		addMouseListener(this);				//������������
		addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				
			}

			public void mouseMoved(MouseEvent e)
			{
				int x1 = (e.getX()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
				int y1 = (e.getY()-MARGIN+GRID_SPAN/2)/GRID_SPAN;
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			
		});
		
		int[][] chess_init_num={
		{0,6,0,5,9,3,0,0,0},
		{9,0,1,0,0,0,5,0,0},
		{0,3,0,4,0,0,0,9,0},
		{1,0,8,0,2,0,0,0,4},
		{4,0,0,3,0,9,0,0,1},
		{2,0,0,0,1,0,6,0,9},
		{0,8,0,0,0,6,0,2,0},
		{0,0,4,0,0,0,8,0,7},
		{0,0,0,7,8,5,0,1,0},
		};
		
		for(int i = 0;i<9;i++)
		{ 
			for(int j = 0;j<9;j++)
			{
				if(0!=chess_init_num[i][j])
				{
					Color blue       = new Color(0, 0, 255);
					Point ch = new Point(j,i,chess_init_num[i][j],blue);
					chessList[chessCount]=ch;
					chessCount++;
				}
			}
			
		}
	}
	
	public Dimension getPreferredSize()					//����С
	{
		return new Dimension(MARGIN*2+GRID_SPAN*COLS,MARGIN*2+GRID_SPAN*ROWS);
	}
	
	public void paintComponent(Graphics g)
	{	
			

		
			super.paintComponent(g);
			
						
			for(int i=0;i<=ROWS;i++)		//����
			{
				g.drawLine(MARGIN,MARGIN+i*GRID_SPAN,MARGIN+COLS*GRID_SPAN,MARGIN+i*GRID_SPAN);
			}
			for(int i=0;i<=COLS;i++)    //����
			{
				g.drawLine(MARGIN+i*GRID_SPAN,MARGIN,MARGIN+i*GRID_SPAN,MARGIN+ROWS*GRID_SPAN);
			}	
			

			
			//init val in chessboard
			
			
			
					// JTextField
		/*	JTextField JTextField1 = new JTextField();
			JTextField1.setBounds(10,10,500,10);
			add(JTextField1);*/
			
			/*		Object[] possibleValues = { "First", "Second", "Third" };
		Object selectedValue = JOptionPane.showInputDialog(null, 
			"Choose one", "Input123",
			JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues[0]);	*/

			
			for(int i=0;i<chessCount;i++)    //������
			{
				
				Font font = new Font("Verdana",1,15);
				g.setFont(font);
				g.setColor(chessList[i].getColor());
				FontMetrics fm = g.getFontMetrics();
				int stringWidth = fm.stringWidth("1");
				int stringAscent = fm.getAscent();
				int xPos = chessList[i].getX()*GRID_SPAN+MARGIN+GRID_SPAN/2-stringWidth/2;
				int yPos = chessList[i].getY()*GRID_SPAN+MARGIN+GRID_SPAN/2+stringAscent/2;
				int num = chessList[i].getNum();
	
		
				
			//	System.out.print(" ~~~x="+xPos+" ~~~y="+yPos + "\n");
				
				g.drawString(Integer.toString(num), xPos, yPos);
		
			


				
				//huangjinju,�˴���Ҫ��Ϊ�������	
				//ʹ��Graphics���drawString
/*
				g.setColor(chessList[i].getColor());				//ָ����ɫ��Ϊ���������Բ
				
				
				g.fillOval(xPos - Point.DIAMETER/2,yPos-Point.DIAMETER/2,	//�����Բ
						Point.DIAMETER,Point.DIAMETER);
				if(i==chessCount-1)							//�ж��ǲ������һ�����ӣ�
				{
					g.setColor(Color.red);					//������ɫ
					g.drawRect(xPos-Point.DIAMETER/2,yPos-Point.DIAMETER/2,	  //���Ʊ߿򣬺�ɫ
						Point.DIAMETER,Point.DIAMETER);
				}
*/
				
			}
	}
	
	public void restartGame()
	{
		for(int i=0;i<chessList.length;i++)
		chessList[i] = null;
		isBlack = true;
		gameOver = false;
		chessCount = 0;
		repaint();
	}
	
	public void goback()
	{
		if(chessCount==0)
		{
			return;
		}
		
		chessList[chessCount-1] = null;
		chessCount--;
		if(chessCount>0)
		{
			xIndex = chessList[chessCount - 1].getX();
			yIndex = chessList[chessCount - 1].getY();
		}
		isBlack = !isBlack;
		repaint();
	}
	
	public void mousePressed(MouseEvent e)			//���������
	{
		if(gameOver)		
		{
			return;
		}
		String colorName = isBlack?"����":"����";
		xIndex = (e.getX()-MARGIN)/GRID_SPAN;
		yIndex = (e.getY()-MARGIN)/GRID_SPAN;

		
		if(xIndex<0 || xIndex>ROWS|| yIndex<0 || yIndex >COLS)
		{
			System.out.print("~~~~~");
			return;
		}
		
		Object[] possibleValues = { "1", "2", "3" ,"4","5","6","7","8","9"};
	Object selectedValue = JOptionPane.showInputDialog(null, 
		"Choose one", "Input123456789",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);	
//		this.drawString(selectedValue, xIndex, yIndex);
	val =Integer.parseInt(selectedValue.toString());
	System.out.print(" x="+xIndex+" y="+yIndex);
	
		//check xIndex,yIndex is valid
		for(int i=0;i<chessCount;i++)    //������
		{
			if((chessList[i].getX()==xIndex) && (chessList[i].getY()==yIndex))
			{
				System.out.print("this position is error\n");
				return;
			}
		}
		
		
		System.out.print("\n");
		
		
		Color  paint_color;
		if(isIllegal())
		{
			 paint_color        = new Color(255, 0, 0);
		}
		else
		{
			 paint_color       = new Color(0, 0, 0);
		}

		
		Point ch = new Point(xIndex,yIndex, val ,paint_color);
		chessList[chessCount++] = ch;
		repaint();				//���»����������̣������paintComponent��
		
		if(isWin())
		{
			
			String msg = String.format("��ϲ,��Ӯ��");
			JOptionPane.showMessageDialog(this,msg);
			gameOver = true;
		}
		
		
		isBlack = !isBlack;
	}
	
	// ����MouseListener�ķ���
	public void mouseClicked(MouseEvent e) {
	} // ��갴��������ϵ��������²��ͷţ�ʱ���á�

	public void mouseEntered(MouseEvent e) {
	}// �����뵽�����ʱ���á�

	public void mouseExited(MouseEvent e) {
	}// ����뿪���ʱ���á�

	public void mouseReleased(MouseEvent e) {
	} // ��갴ť��������ͷ�ʱ���á�

	private Point getChess(int xIndex,int yIndex,int num)
	{
		for(Point c :chessList)
		{
			if(c!=null&&c.getX()==xIndex&&c.getY()==yIndex&&c.getNum()==num)
			{
				return c;
			}
		}
		return null;
	}
	
	private boolean isIllegal()
	{
		//���row = yIndex,
		for(int i=0;i<chessCount;i++)
		{
			if(yIndex==chessList[i].getY())			//ͬһ��
			{
				if(val==chessList[i].getNum())
				{
					return true;
				}
			}
		}
		//���col
		for(int i=0;i<chessCount;i++)
		{
			if(xIndex==chessList[i].getX())			//ͬһ��
			{
				if(val==chessList[i].getNum())
				{
					return true;
				}
			}
		}
		
		//������ھŹ���
		int jg_xIndex = xIndex/3;
		int jg_yIndex = yIndex/3;
		jg_xIndex = jg_xIndex*3;
		jg_yIndex = jg_yIndex*3;
		
		for(int i=0;i<chessCount;i++)
		{
			if( ((chessList[i].getX()>=jg_xIndex)&&(chessList[i].getX()<=jg_xIndex+2))
				&&((chessList[i].getY()>=jg_yIndex)&&(chessList[i].getY()<=jg_yIndex+2))	)
			{
				if(val==chessList[i].getNum())
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	private boolean isWin()		//�ж��Ƿ�Ӯ
	{
		//need rewrite Win api
		Color red        = new Color(255, 0, 0);
		if(chessCount==ROWS*COLS)
		{
			for(int i=0;i<chessCount;i++)
			{
				if(red==chessList[i].getColor())
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
		
/*
		
		int continueCount = 1;
		Color c=isBlack?Color.black:Color.white;
		
		//������
		for(int x=xIndex-1;x>=0;x--)
		{
			if(getChess(x,yIndex,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		//����
		for(int x=xIndex+1;x<=ROWS;x++)
		{
			if(getChess(x,yIndex,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		if(continueCount >= 5)
		{
			return true;
		}
		else
		{
			continueCount = 1;
		}
		
		
		//����
		for(int y=yIndex-1;y>=0;y--)
		{
			if(getChess(xIndex,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		//����
		for(int y=yIndex+1;y<=ROWS;y++)
		{
			if(getChess(xIndex,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		if(continueCount >= 5)
		{
			return true;
		}
		else
		{
			continueCount = 1;
		}
		
		

		
		//����
		for(int x=xIndex+1,y=yIndex-1;y>=0&&x<=COLS;x++,y--)
		{
			if(getChess(x,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		//����
		for(int x=xIndex-1,y=yIndex+1;x>=0&&y<=ROWS;x--,y++)
		{
			if(getChess(x,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		if(continueCount >= 5)
		{
			return true;
		}
		else
		{
			continueCount = 1;
		}
		
		

		
		//���� 
		for(int x=xIndex-1,y=yIndex-1;x>=0&&y>=0;x--,y--)
		{
			if(getChess(x,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		//����
		for(int x=xIndex-1,y=yIndex+1;x>=COLS&&y<=ROWS;x++,y++)
		{
			if(getChess(x,y,c)!=null)
			{
				continueCount++;
			}
			else
			{
				break;
			}
		}
		if(continueCount >= 5)
		{
			return true;
		}
		else
		{
			continueCount = 1;
		}		
		
		return false;
		*/
	
	}
	
	
	
}
