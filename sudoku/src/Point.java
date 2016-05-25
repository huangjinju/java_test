import java.awt.*;
import javax.swing.*;




public class Point
{
	private int x;				//x����
	private int y;				//y����
	private int num;			//����
	private Color color;	//��ɫ
	public static final int DIAMETER=30;		
	public Point(int x,int y,int num,Color color)			//����
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.color = color;
	}
	public int getX()							//��ȡx����
	{
		return x;
	}
	public int getY()							//��ȡy����
	{
		return y;
	}
	public Color getColor()						//��ȡ��ɫ
	{
		return color;
	}
	public int getNum()
	{
		return num;
	}
};




