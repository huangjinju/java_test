import java.awt.*;
import javax.swing.*;




public class Point
{
	private int x;				//x坐标
	private int y;				//y坐标
	private int num;			//数字
	private Color color;	//颜色
	public static final int DIAMETER=30;		
	public Point(int x,int y,int num,Color color)			//放棋
	{
		this.x = x;
		this.y = y;
		this.num = num;
		this.color = color;
	}
	public int getX()							//获取x坐标
	{
		return x;
	}
	public int getY()							//获取y坐标
	{
		return y;
	}
	public Color getColor()						//获取颜色
	{
		return color;
	}
	public int getNum()
	{
		return num;
	}
};




