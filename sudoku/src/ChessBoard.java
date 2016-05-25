import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class ChessBoard extends JPanel  implements MouseListener
{
	public static final int MARGIN = 40;	//边距
	public static final int GRID_SPAN = 40;//网格间距
	public static final int ROWS = 9;		//9行
	public static final int COLS = 9;		//9列
	
	int chessCount;					
	Point[] chessList = new Point[(ROWS+1)*(COLS+1)];		//行数以及列数
	int xIndex,yIndex;									//x坐标以及y坐标
	int val;					//存放结果
	
	boolean isBlack = true;
	boolean gameOver = false;
	
	
	public ChessBoard()
	{
		setBackground(Color.ORANGE);		//设置panel背景颜色
		addMouseListener(this);				//增加鼠标监听器
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
	
	public Dimension getPreferredSize()					//面板大小
	{
		return new Dimension(MARGIN*2+GRID_SPAN*COLS,MARGIN*2+GRID_SPAN*ROWS);
	}
	
	public void paintComponent(Graphics g)
	{	
			

		
			super.paintComponent(g);
			
						
			for(int i=0;i<=ROWS;i++)		//画行
			{
				g.drawLine(MARGIN,MARGIN+i*GRID_SPAN,MARGIN+COLS*GRID_SPAN,MARGIN+i*GRID_SPAN);
			}
			for(int i=0;i<=COLS;i++)    //画列
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

			
			for(int i=0;i<chessCount;i++)    //画棋子
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
		
			


				
				//huangjinju,此处需要改为填充数字	
				//使用Graphics类的drawString
/*
				g.setColor(chessList[i].getColor());				//指定颜色，为后续填充椭圆
				
				
				g.fillOval(xPos - Point.DIAMETER/2,yPos-Point.DIAMETER/2,	//填充椭圆
						Point.DIAMETER,Point.DIAMETER);
				if(i==chessCount-1)							//判断是不是最后一个棋子？
				{
					g.setColor(Color.red);					//设置颜色
					g.drawRect(xPos-Point.DIAMETER/2,yPos-Point.DIAMETER/2,	  //绘制边框，红色
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
	
	public void mousePressed(MouseEvent e)			//鼠标点击动作
	{
		if(gameOver)		
		{
			return;
		}
		String colorName = isBlack?"黑棋":"白棋";
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
		for(int i=0;i<chessCount;i++)    //画棋子
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
		repaint();				//重新绘制整个棋盘，会调用paintComponent？
		
		if(isWin())
		{
			
			String msg = String.format("恭喜,你赢了");
			JOptionPane.showMessageDialog(this,msg);
			gameOver = true;
		}
		
		
		isBlack = !isBlack;
	}
	
	// 覆盖MouseListener的方法
	public void mouseClicked(MouseEvent e) {
	} // 鼠标按键在组件上单击（按下并释放）时调用。

	public void mouseEntered(MouseEvent e) {
	}// 鼠标进入到组件上时调用。

	public void mouseExited(MouseEvent e) {
	}// 鼠标离开组件时调用。

	public void mouseReleased(MouseEvent e) {
	} // 鼠标按钮在组件上释放时调用。

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
		//检查row = yIndex,
		for(int i=0;i<chessCount;i++)
		{
			if(yIndex==chessList[i].getY())			//同一行
			{
				if(val==chessList[i].getNum())
				{
					return true;
				}
			}
		}
		//检查col
		for(int i=0;i<chessCount;i++)
		{
			if(xIndex==chessList[i].getX())			//同一行
			{
				if(val==chessList[i].getNum())
				{
					return true;
				}
			}
		}
		
		//检查所在九宫格
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
	
	
	private boolean isWin()		//判断是否赢
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
		
		//横向西
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
		//横向东
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
		
		
		//向下
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
		//向上
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
		
		

		
		//东北
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
		//西南
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
		
		

		
		//西北 
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
		//东南
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
