import javax.swing.*;

import java.awt.event.*;
import java.awt.*;



public class StartChessJFrame extends JFrame{
	private JPanel toolbar;		//工具栏,需要加入"重新开始","悔棋","退出"等按钮
	private JButton btnStart;	//重新开始按钮
	private JButton btnBack;	//悔棋按钮
	private JButton btnExit;	//退出按钮
	private JMenuBar menuBar;	//菜单栏按钮
	private JMenu sysMenu;		//菜单
	private JMenuItem startMenuItem;	//菜单开始选项
	private JMenuItem exitMenuItem;	//菜单退出选项
	private JMenuItem backMenuItem;	//菜单悔棋选项
	private ChessBoard chessBoard;		//棋盘
	
	/**
	 * 
	 */
	public StartChessJFrame() {
		setTitle("单机版五子棋");			//设置frame标题
		menuBar = new JMenuBar();			//新建菜单栏
		sysMenu = new JMenu("系统");		//新建一个系统菜单
		startMenuItem = new JMenuItem("重新开始");		//新建菜单项目
		exitMenuItem = new JMenuItem("退出");			//新建菜单项目
		backMenuItem = new JMenuItem("悔棋");			//新建菜单项目
		chessBoard = new ChessBoard();					//生产一个棋盘
		
		
	

	

	
		
		sysMenu.add(startMenuItem);				//把菜单项目加入到系统菜单中去
		sysMenu.add(exitMenuItem);					//把菜单项目加入到系统菜单中去
		sysMenu.add(backMenuItem);					//把菜单项目加入到系统菜单中去
		
		
		MyItemListener lis = new MyItemListener();		//生产一个监听器，用于监听按钮事件以及菜单事件
		this.startMenuItem.addActionListener(lis);		//菜单项目的handler
		backMenuItem.addActionListener(lis);			//菜单项目的handler
		exitMenuItem.addActionListener(lis);			//菜单项目的handler
		menuBar.add(sysMenu);							//把系统菜单加入到菜单栏中去
		setJMenuBar(menuBar);							//设置jframe的菜单栏
		toolbar = new JPanel();						//新建工具栏面板
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));		//设置面板的布局
		btnStart = new JButton("重新开始");			//新建按钮
		btnBack = new JButton("悔棋");				//新建按钮
		btnExit = new JButton("退出");				//新建按钮
				
		toolbar.add(btnStart);				//把按钮加入到工具栏中
		toolbar.add(btnBack);				//把按钮加入到工具栏中
		toolbar.add(btnExit);				//把按钮加入到工具栏中
		
		btnStart.addActionListener(lis);	//按钮的handler
		btnBack.addActionListener(lis);		//按钮的handler
		btnExit.addActionListener(lis);		//按钮的handler
			
		add(toolbar,BorderLayout.SOUTH);		//frame中加入工具栏
		add(chessBoard,BorderLayout.CENTER);			//frame中加入棋盘
		
		
	//		JTextField JTextField1 = new JTextField();
	//		JTextField1.setBounds(1,1,1,1);
		
	//	add(JTextField1);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//setSize(100,100);		//不设置大小，子适应
		pack();			//自动调整布局
	}
	
	private class MyItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)			//接受事件监听器
		{
			Object obj = e.getSource();
			if(obj == StartChessJFrame.this.startMenuItem || obj==btnStart)//重新开始事件
			{
				chessBoard.restartGame();
				System.out.println("重新开始");
			}
			else if(obj==exitMenuItem || obj==btnExit)				//退出系统事件
			{
				System.exit(0);
			}
			else if(obj==backMenuItem || obj==btnBack) 			 	//悔棋事件
			{
				chessBoard.goback();
				System.out.println("悔棋...");
			}
		}
	}
	
	
	
	public static void main(String[] args)				//主程序
	{
		StartChessJFrame f = new StartChessJFrame();		//
		f.setVisible(true);
	}
	
}