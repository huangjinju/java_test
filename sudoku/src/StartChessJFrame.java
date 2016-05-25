import javax.swing.*;

import java.awt.event.*;
import java.awt.*;



public class StartChessJFrame extends JFrame{
	private JPanel toolbar;		//������,��Ҫ����"���¿�ʼ","����","�˳�"�Ȱ�ť
	private JButton btnStart;	//���¿�ʼ��ť
	private JButton btnBack;	//���尴ť
	private JButton btnExit;	//�˳���ť
	private JMenuBar menuBar;	//�˵�����ť
	private JMenu sysMenu;		//�˵�
	private JMenuItem startMenuItem;	//�˵���ʼѡ��
	private JMenuItem exitMenuItem;	//�˵��˳�ѡ��
	private JMenuItem backMenuItem;	//�˵�����ѡ��
	private ChessBoard chessBoard;		//����
	
	/**
	 * 
	 */
	public StartChessJFrame() {
		setTitle("������������");			//����frame����
		menuBar = new JMenuBar();			//�½��˵���
		sysMenu = new JMenu("ϵͳ");		//�½�һ��ϵͳ�˵�
		startMenuItem = new JMenuItem("���¿�ʼ");		//�½��˵���Ŀ
		exitMenuItem = new JMenuItem("�˳�");			//�½��˵���Ŀ
		backMenuItem = new JMenuItem("����");			//�½��˵���Ŀ
		chessBoard = new ChessBoard();					//����һ������
		
		
	

	

	
		
		sysMenu.add(startMenuItem);				//�Ѳ˵���Ŀ���뵽ϵͳ�˵���ȥ
		sysMenu.add(exitMenuItem);					//�Ѳ˵���Ŀ���뵽ϵͳ�˵���ȥ
		sysMenu.add(backMenuItem);					//�Ѳ˵���Ŀ���뵽ϵͳ�˵���ȥ
		
		
		MyItemListener lis = new MyItemListener();		//����һ�������������ڼ�����ť�¼��Լ��˵��¼�
		this.startMenuItem.addActionListener(lis);		//�˵���Ŀ��handler
		backMenuItem.addActionListener(lis);			//�˵���Ŀ��handler
		exitMenuItem.addActionListener(lis);			//�˵���Ŀ��handler
		menuBar.add(sysMenu);							//��ϵͳ�˵����뵽�˵�����ȥ
		setJMenuBar(menuBar);							//����jframe�Ĳ˵���
		toolbar = new JPanel();						//�½����������
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));		//�������Ĳ���
		btnStart = new JButton("���¿�ʼ");			//�½���ť
		btnBack = new JButton("����");				//�½���ť
		btnExit = new JButton("�˳�");				//�½���ť
				
		toolbar.add(btnStart);				//�Ѱ�ť���뵽��������
		toolbar.add(btnBack);				//�Ѱ�ť���뵽��������
		toolbar.add(btnExit);				//�Ѱ�ť���뵽��������
		
		btnStart.addActionListener(lis);	//��ť��handler
		btnBack.addActionListener(lis);		//��ť��handler
		btnExit.addActionListener(lis);		//��ť��handler
			
		add(toolbar,BorderLayout.SOUTH);		//frame�м��빤����
		add(chessBoard,BorderLayout.CENTER);			//frame�м�������
		
		
	//		JTextField JTextField1 = new JTextField();
	//		JTextField1.setBounds(1,1,1,1);
		
	//	add(JTextField1);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//setSize(100,100);		//�����ô�С������Ӧ
		pack();			//�Զ���������
	}
	
	private class MyItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)			//�����¼�������
		{
			Object obj = e.getSource();
			if(obj == StartChessJFrame.this.startMenuItem || obj==btnStart)//���¿�ʼ�¼�
			{
				chessBoard.restartGame();
				System.out.println("���¿�ʼ");
			}
			else if(obj==exitMenuItem || obj==btnExit)				//�˳�ϵͳ�¼�
			{
				System.exit(0);
			}
			else if(obj==backMenuItem || obj==btnBack) 			 	//�����¼�
			{
				chessBoard.goback();
				System.out.println("����...");
			}
		}
	}
	
	
	
	public static void main(String[] args)				//������
	{
		StartChessJFrame f = new StartChessJFrame();		//
		f.setVisible(true);
	}
	
}