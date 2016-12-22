/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.talent.aio.examples.im.client.ui;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.talent.aio.client.ClientChannelContext;
import com.talent.aio.client.ClientGroupStat;
import com.talent.aio.common.Aio;
import com.talent.aio.common.ChannelContext;
import com.talent.aio.common.ObjWithReadWriteLock;
import com.talent.aio.common.maintain.ClientNodes;
import com.talent.aio.common.utils.SystemTimer;
import com.talent.aio.examples.im.client.ImClientStarter;
import com.talent.aio.examples.im.client.handler.ChatRespHandler;
import com.talent.aio.examples.im.client.ui.component.MyTextArea;
import com.talent.aio.examples.im.common.Command;
import com.talent.aio.examples.im.common.Const.ChatType;
import com.talent.aio.examples.im.common.ImPacket;
import com.talent.aio.examples.im.common.bs.ChatReqBody;
import com.talent.aio.examples.im.common.bs.JoinReqBody;
import com.talent.aio.examples.im.common.json.Json;

/**
 *
 * @author Administrator
 */
public class JFrameMain extends javax.swing.JFrame
{

	private static Logger log = LoggerFactory.getLogger(JFrameMain.class);
	private static JFrameMain instance = null;

	private static ImClientStarter imClientStarter = null;

	/** 
	 * 设置窗口图标 
	 */
	protected void setWindowIcon()
	{
		//javax.swing.ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"));
		//		this.setIconImage(imageIcon.getImage());
	}

	/**
	 * @return
	 */
	public static JFrameMain getInstance()
	{
		if (instance == null)
		{
			synchronized (log)
			{
				if (instance == null)
				{
					instance = new JFrameMain();
					instance.setWindowIcon();
				}
			}
		}
		return instance;
	}

	/**
	 * Creates new form JFrameMain
	 */
	private JFrameMain()
	{
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        lianjie = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        clients = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        logtext = new MyTextArea();
        deleteBtn = new javax.swing.JButton();
        msgField = new javax.swing.JTextField();
        sendBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        msgTextArea = new MyTextArea();
        groupField = new javax.swing.JTextField();
        joinBtn = new javax.swing.JButton();
        loopcountField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        clientCountLabel = new javax.swing.JLabel();
        loginnameSufEndField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cleanBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("talent-im-client");

        serverip.setText("127.0.0.1");
        serverip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serveripActionPerformed(evt);
            }
        });

        jLabel1.setText("Server");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        jLabel2.setText(":");

        port.setText("9321");
        port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portActionPerformed(evt);
            }
        });

        lianjie.setText("连接");
        lianjie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lianjieActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(clients);

        logtext.setColumns(20);
        logtext.setRows(5);
        logtext.setText("使用说明：\n1、设置好Server和端口\n2、设置好连接数量(可以用默认的)\n3、设置好群组名(可以用默认的)\n\n4、点击“连接”\n5、选中连接，再点击“进入群组”。（注意进入群组和后面的发送聊天，都只针对选中的客户端进行操作）\n\n");
        jScrollPane2.setViewportView(logtext);

        deleteBtn.setText("删除选中的客户端");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        msgField.setText("hello!");

        sendBtn.setText("发送聊天");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        msgTextArea.setColumns(20);
        msgTextArea.setRows(5);
        msgTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msgTextAreaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(msgTextArea);

        groupField.setText("9527");
        groupField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupFieldActionPerformed(evt);
            }
        });

        joinBtn.setText("进入群组");
        joinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinBtnActionPerformed(evt);
            }
        });

        loopcountField.setText("1");
        loopcountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopcountFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("次");

        loginnameSufEndField.setText("1000");
        loginnameSufEndField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginnameSufEndFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("连接数量");

        cleanBtn1.setText("打印统计信息");
        cleanBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serverip, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteBtn)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginnameSufEndField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lianjie)
                        .addGap(31, 31, 31)
                        .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(joinBtn)
                        .addGap(69, 69, 69)
                        .addComponent(msgField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loopcountField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(sendBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cleanBtn1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginnameSufEndField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lianjie)
                    .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinBtn)
                    .addComponent(msgField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loopcountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(sendBtn)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(clientCountLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteBtn)
                            .addComponent(cleanBtn1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void serveripActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_serveripActionPerformed
			// TODO add your handling code here:
	}//GEN-LAST:event_serveripActionPerformed

	private void portActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_portActionPerformed
			// TODO add your handling code here:
	}//GEN-LAST:event_portActionPerformed

	public void updateClientCount()
	{
		int clientSize = imClientStarter.getAioClient().getClientGroupContext().getConnections().getSet().getObj().size();
		clientCountLabel.setText(clientSize + "个客户端");
	}

	@SuppressWarnings("unchecked")
	private void lianjieActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_lianjieActionPerformed
		try
		{
			String serverip_ = serverip.getText();
			Integer port_ = Integer.parseInt(port.getText());
			imClientStarter = new ImClientStarter(serverip_, port_);
			int start = 0;//Integer.parseInt(loginnameSufStartField.getText());
			int end = Integer.parseInt(loginnameSufEndField.getText());
			//                int count = end - start + 1;
			for (int i = start; i < end; i++)
			{
				ClientChannelContext<Object, ImPacket, Object> channelContext = imClientStarter.getAioClient().connect(null, null, true);

				listModel.addElement(ClientNodes.getKey(channelContext));
				clients.setModel(listModel);
			}
			updateClientCount();

		} catch (Exception e)
		{
			String str = ExceptionUtils.getStackTrace(e);
			logtext.append(str);
		}

	}//GEN-LAST:event_lianjieActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_deleteBtnActionPerformed
		List<String> ids = clients.getSelectedValuesList();//.getSelectedIndex();
		if (ids != null && ids.size() > 0)
		{
			for (String id : ids)
			{
				ChannelContext<Object, ImPacket, Object> channelContext = imClientStarter.getAioClient().getClientGroupContext().getClientNodes().find(id);
				if (channelContext != null)
				{
					Aio.close(channelContext, "");

				}
			}
			//			updateClientCount();
			//			ListModel<String> listModel1 = clients.getModel();
			//			String id = (String)listModel1.getElementAt(index);

		}
	}//GEN-LAST:event_deleteBtnActionPerformed

	public static String getSelectedId()
	{
		int index = JFrameMain.getInstance().clients.getSelectedIndex();//.getModel();
		if (index < 0)
		{
			log.error("没有选中任何客户端");
			return null;
		}
		String id = (String) JFrameMain.getInstance().listModel.getElementAt(index);
		return id;
	}

	
	private long sendStartTime;
	private void sendBtnActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_sendBtnActionPerformed
		
		
		JFrameMain.getInstance().getMsgTextArea().setText("");
		ChatRespHandler.count.set(0);
		List<String> ids = clients.getSelectedValuesList();
		if (ids == null || ids.size() == 0)
		{
			log.error("没有选中任何客户端");
		}

		String msg = msgField.getText();
		int loopcount = Integer.parseInt(loopcountField.getText());
		String toGroup = groupField.getText();
		ChatReqBody chatReqBody = new ChatReqBody(ChatType.pub, msg, toGroup, null, null);
		int count = 0;
		setSendStartTime(SystemTimer.currentTimeMillis());
		for (String id : ids)
		{
			for (int i = 0; i < loopcount; i++)
			{
				try
				{
					ChannelContext<Object, ImPacket, Object> channelContext = imClientStarter.getAioClient().getClientGroupContext().getClientNodes().find(id);
					if (channelContext != null)
					{
						byte[] body = Json.toJson(chatReqBody).getBytes(ImPacket.CHARSET);
						ImPacket packet = new ImPacket(body, Command.CHAT_REQ);
						Aio.send(channelContext, packet);
					}

				} catch (Exception e1)
				{
					log.error(e1.toString(), e1);
				}
				//				count++;
				//				if (count >= 1000)
				//				{
				//					try
				//					{
				//						count = 0;
				//						Thread.sleep(1000);
				//					} catch (InterruptedException e)
				//					{
				//						log.error(e.toString(), e);
				//					}
				//				}
			}
		}

	}//GEN-LAST:event_sendBtnActionPerformed

	private void groupFieldActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_groupFieldActionPerformed
			// TODO add your handling code here:
	}//GEN-LAST:event_groupFieldActionPerformed

	private void joinBtnActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_joinBtnActionPerformed

		//        String id = getSelectedId();
		//        if (StringUtils.isBlank(id)) {
		//            return;
		//        }
		List<String> ids = clients.getSelectedValuesList();
		if (ids == null || ids.size() == 0)
		{
			log.error("没有选中任何客户端");
		}

		String group = groupField.getText();
		JoinReqBody joinReqBody = new JoinReqBody(group);

		for (String id : ids)
		{
			try
			{
				//				MsgSendApi.send(Command.JOIN_GROUP_REQ, joinReqBody, id);

				ChannelContext<Object, ImPacket, Object> channelContext = imClientStarter.getAioClient().getClientGroupContext().getClientNodes().find(id);
				if (channelContext != null)
				{
					byte[] body = Json.toJson(joinReqBody).getBytes(ImPacket.CHARSET);
					ImPacket packet = new ImPacket(body, Command.JOIN_GROUP_REQ);
					Aio.send(channelContext, packet);
				}
			} catch (Exception e)
			{
				log.error(e.toString(), e);
			}
		}

	}//GEN-LAST:event_joinBtnActionPerformed

	private void loginnameSufEndFieldActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_loginnameSufEndFieldActionPerformed
			// TODO add your handling code here:
	}//GEN-LAST:event_loginnameSufEndFieldActionPerformed

	private void msgTextAreaMouseClicked(java.awt.event.MouseEvent evt)
	{//GEN-FIRST:event_msgTextAreaMouseClicked

		if (evt.getButton() == MouseEvent.BUTTON3)
		{//右键
			log.error(evt.getButton() + "");
		}
	}//GEN-LAST:event_msgTextAreaMouseClicked

	private void loopcountFieldActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_loopcountFieldActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_loopcountFieldActionPerformed

	private void cleanBtn1ActionPerformed(java.awt.event.ActionEvent evt)
	{//GEN-FIRST:event_cleanBtn1ActionPerformed
		String id = imClientStarter.getClientGroupContext().getId();
		ObjWithReadWriteLock<Set<ChannelContext<Object, ImPacket, Object>>> connections = imClientStarter.getClientGroupContext().getConnections().getSet();
		Set<ChannelContext<Object, ImPacket, Object>> set = connections.getObj();
		ClientGroupStat clientGroupStat = imClientStarter.getClientGroupContext().getClientGroupStat();
		log.error("[{}]:[{}]: curr:{}, closed:{}, received:({}p)({}b), handled:{}, sent:({}p)({}b)", SystemTimer.currentTimeMillis(), id, set.size(),
				clientGroupStat.getClosed().get(), clientGroupStat.getReceivedPacket().get(), clientGroupStat.getReceivedBytes().get(), clientGroupStat.getHandledPacket().get(),
				clientGroupStat.getSentPacket().get(), clientGroupStat.getSentBytes().get());
	}//GEN-LAST:event_cleanBtn1ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try
		{
			//			try
			//			{
			//				com.talent.aio.examples.im.client.ImClientStarter.init();
			//			} catch (Exception e)
			//			{
			//				throw new RuntimeException(e);
			//			}

			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrameMain.getInstance().setVisible(true);
			}
		});
	}

	DefaultListModel listModel = new DefaultListModel();

	//    private Set<ChannelContext> clients_ = new HashSet<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanBtn1;
    private javax.swing.JLabel clientCountLabel;
    private javax.swing.JList<String> clients;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField groupField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton joinBtn;
    private javax.swing.JButton lianjie;
    private javax.swing.JTextField loginnameSufEndField;
    private javax.swing.JTextArea logtext;
    private javax.swing.JTextField loopcountField;
    private javax.swing.JTextField msgField;
    private javax.swing.JTextArea msgTextArea;
    private javax.swing.JTextField port;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField serverip;
    // End of variables declaration//GEN-END:variables

	public javax.swing.JTextArea getLogtext()
	{
		return logtext;
	}

	public javax.swing.JList<String> getClients()
	{
		return clients;
	}

	public javax.swing.JTextArea getMsgTextArea()
	{
		return msgTextArea;
	}

	public javax.swing.JLabel getClientCountLabel()
	{
		return clientCountLabel;
	}

	/**
	 * @return the imClientStarter
	 */
	public static ImClientStarter getImClientStarter()
	{
		return imClientStarter;
	}

	/**
	 * @param imClientStarter the imClientStarter to set
	 */
	public static void setImClientStarter(ImClientStarter imClientStarter)
	{
		JFrameMain.imClientStarter = imClientStarter;
	}

	/**
	 * @return the listModel
	 */
	public DefaultListModel getListModel()
	{
		return listModel;
	}

	/**
	 * @param listModel the listModel to set
	 */
	public void setListModel(DefaultListModel listModel)
	{
		this.listModel = listModel;
	}

//	/**
//	 * @return the cleanBtn
//	 */
//	public javax.swing.JButton getCleanBtn()
//	{
//		return cleanBtn;
//	}
//
//	/**
//	 * @param cleanBtn the cleanBtn to set
//	 */
//	public void setCleanBtn(javax.swing.JButton cleanBtn)
//	{
//		this.cleanBtn = cleanBtn;
//	}

	/**
	 * @return the printBtn
	 */
	public javax.swing.JButton getPrintBtn()
	{
		return cleanBtn1;
	}

	/**
	 * @param printBtn the printBtn to set
	 */
	public void setPrintBtn(javax.swing.JButton printBtn)
	{
		this.cleanBtn1 = printBtn;
	}

	/**
	 * @return the deleteBtn
	 */
	public javax.swing.JButton getDeleteBtn()
	{
		return deleteBtn;
	}

	/**
	 * @param deleteBtn the deleteBtn to set
	 */
	public void setDeleteBtn(javax.swing.JButton deleteBtn)
	{
		this.deleteBtn = deleteBtn;
	}

	/**
	 * @return the groupField
	 */
	public javax.swing.JTextField getGroupField()
	{
		return groupField;
	}

	/**
	 * @param groupField the groupField to set
	 */
	public void setGroupField(javax.swing.JTextField groupField)
	{
		this.groupField = groupField;
	}

	/**
	 * @return the jLabel1
	 */
	public javax.swing.JLabel getjLabel1()
	{
		return jLabel1;
	}

	/**
	 * @param jLabel1 the jLabel1 to set
	 */
	public void setjLabel1(javax.swing.JLabel jLabel1)
	{
		this.jLabel1 = jLabel1;
	}

	/**
	 * @return the jLabel2
	 */
	public javax.swing.JLabel getjLabel2()
	{
		return jLabel2;
	}

	/**
	 * @param jLabel2 the jLabel2 to set
	 */
	public void setjLabel2(javax.swing.JLabel jLabel2)
	{
		this.jLabel2 = jLabel2;
	}

	/**
	 * @return the jLabel3
	 */
	public javax.swing.JLabel getjLabel3()
	{
		return jLabel3;
	}

	/**
	 * @param jLabel3 the jLabel3 to set
	 */
	public void setjLabel3(javax.swing.JLabel jLabel3)
	{
		this.jLabel3 = jLabel3;
	}

	/**
	 * @return the jLabel6
	 */
	public javax.swing.JLabel getjLabel6()
	{
		return jLabel6;
	}

	/**
	 * @param jLabel6 the jLabel6 to set
	 */
	public void setjLabel6(javax.swing.JLabel jLabel6)
	{
		this.jLabel6 = jLabel6;
	}

	/**
	 * @return the jScrollPane1
	 */
	public javax.swing.JScrollPane getjScrollPane1()
	{
		return jScrollPane1;
	}

	/**
	 * @param jScrollPane1 the jScrollPane1 to set
	 */
	public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1)
	{
		this.jScrollPane1 = jScrollPane1;
	}

	/**
	 * @return the jScrollPane2
	 */
	public javax.swing.JScrollPane getjScrollPane2()
	{
		return jScrollPane2;
	}

	/**
	 * @param jScrollPane2 the jScrollPane2 to set
	 */
	public void setjScrollPane2(javax.swing.JScrollPane jScrollPane2)
	{
		this.jScrollPane2 = jScrollPane2;
	}

	/**
	 * @return the jScrollPane3
	 */
	public javax.swing.JScrollPane getjScrollPane3()
	{
		return jScrollPane3;
	}

	/**
	 * @param jScrollPane3 the jScrollPane3 to set
	 */
	public void setjScrollPane3(javax.swing.JScrollPane jScrollPane3)
	{
		this.jScrollPane3 = jScrollPane3;
	}

	/**
	 * @return the joinBtn
	 */
	public javax.swing.JButton getJoinBtn()
	{
		return joinBtn;
	}

	/**
	 * @param joinBtn the joinBtn to set
	 */
	public void setJoinBtn(javax.swing.JButton joinBtn)
	{
		this.joinBtn = joinBtn;
	}

	/**
	 * @return the lianjie
	 */
	public javax.swing.JButton getLianjie()
	{
		return lianjie;
	}

	/**
	 * @param lianjie the lianjie to set
	 */
	public void setLianjie(javax.swing.JButton lianjie)
	{
		this.lianjie = lianjie;
	}

	/**
	 * @return the loginnameSufEndField
	 */
	public javax.swing.JTextField getLoginnameSufEndField()
	{
		return loginnameSufEndField;
	}

	/**
	 * @param loginnameSufEndField the loginnameSufEndField to set
	 */
	public void setLoginnameSufEndField(javax.swing.JTextField loginnameSufEndField)
	{
		this.loginnameSufEndField = loginnameSufEndField;
	}

	/**
	 * @return the loopcountField
	 */
	public javax.swing.JTextField getLoopcountField()
	{
		return loopcountField;
	}

	/**
	 * @param loopcountField the loopcountField to set
	 */
	public void setLoopcountField(javax.swing.JTextField loopcountField)
	{
		this.loopcountField = loopcountField;
	}

	/**
	 * @return the msgField
	 */
	public javax.swing.JTextField getMsgField()
	{
		return msgField;
	}

	/**
	 * @param msgField the msgField to set
	 */
	public void setMsgField(javax.swing.JTextField msgField)
	{
		this.msgField = msgField;
	}

	/**
	 * @return the port
	 */
	public javax.swing.JTextField getPort()
	{
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(javax.swing.JTextField port)
	{
		this.port = port;
	}

	/**
	 * @return the sendBtn
	 */
	public javax.swing.JButton getSendBtn()
	{
		return sendBtn;
	}

	/**
	 * @param sendBtn the sendBtn to set
	 */
	public void setSendBtn(javax.swing.JButton sendBtn)
	{
		this.sendBtn = sendBtn;
	}

	/**
	 * @return the serverip
	 */
	public javax.swing.JTextField getServerip()
	{
		return serverip;
	}

	/**
	 * @param serverip the serverip to set
	 */
	public void setServerip(javax.swing.JTextField serverip)
	{
		this.serverip = serverip;
	}

	/**
	 * @param clientCountLabel the clientCountLabel to set
	 */
	public void setClientCountLabel(javax.swing.JLabel clientCountLabel)
	{
		this.clientCountLabel = clientCountLabel;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(javax.swing.JList<String> clients)
	{
		this.clients = clients;
	}

	/**
	 * @param logtext the logtext to set
	 */
	public void setLogtext(javax.swing.JTextArea logtext)
	{
		this.logtext = logtext;
	}

	/**
	 * @param msgTextArea the msgTextArea to set
	 */
	public void setMsgTextArea(javax.swing.JTextArea msgTextArea)
	{
		this.msgTextArea = msgTextArea;
	}

	/**
	 * @return the sendStartTime
	 */
	public long getSendStartTime()
	{
		return sendStartTime;
	}

	/**
	 * @param sendStartTime the sendStartTime to set
	 */
	public void setSendStartTime(long sendStartTime)
	{
		this.sendStartTime = sendStartTime;
	}
}
