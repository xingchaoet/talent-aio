/**
 * **************************************************************************
 *
 * @说明: 
 * @项目名称: talent-aio-examples-server
 *
 * @author: tanyaowu 
 * @创建时间: 2016年11月18日 上午9:13:15
 *
 * **************************************************************************
 */
package com.talent.aio.examples.helloworld.common;

import java.nio.ByteBuffer;

import com.talent.aio.common.ChannelContext;
import com.talent.aio.common.exception.AioDecodeException;
import com.talent.aio.common.intf.AioHandler;

/**
 * hello world版中服务器端和客户端的编码解码算法是一样的，所以抽象一个公共的父类出来
 * @author tanyaowu 
 * @创建时间 2016年11月18日 上午9:13:15
 *
 * @操作列表
 *  编号	| 操作时间	| 操作人员	 | 操作说明
 *  (1) | 2016年11月18日 | tanyaowu | 新建类
 *
 */
public abstract class HelloAbsAioHandler implements AioHandler<Object, HelloPacket, Object>
{
	/** 
	 * @see com.talent.aio.common.intf.AioHandler#encode(com.talent.aio.common.intf.Packet)
	 * 
	 * @param packet
	 * @return
	 * @重写人: tanyaowu
	 * @重写时间: 2016年11月18日 上午9:37:44
	 * 
	 */
	@Override
	public ByteBuffer encode(HelloPacket packet, ChannelContext<Object, HelloPacket, Object> channelContext)
	{
		byte[] body = packet.getBody();
		int bodyLen = 0;
		if (body != null)
		{
			bodyLen = body.length;
		}

		int allLen = HelloPacket.HEADER_LENGHT + bodyLen;
		ByteBuffer buffer = ByteBuffer.allocate(allLen);
		buffer.order(channelContext.getGroupContext().getByteOrder());

		buffer.putInt(bodyLen);

		if (body != null)
		{
			buffer.put(body);
		}
		return buffer;
	}

	/** 
	 * @see com.talent.aio.common.intf.AioHandler#decode(java.nio.ByteBuffer)
	 * 
	 * @param buffer
	 * @return
	 * @throws AioDecodeException
	 * @重写人: tanyaowu
	 * @重写时间: 2016年11月18日 上午9:37:44
	 * 
	 */
	@Override
	public HelloPacket decode(ByteBuffer buffer, ChannelContext<Object, HelloPacket, Object> channelContext) throws AioDecodeException
	{
		int readableLength = buffer.limit() - buffer.position();
		if (readableLength < HelloPacket.HEADER_LENGHT)
		{
			return null;
		}

		int bodyLength = buffer.getInt();

		if (bodyLength < 0)
		{
			throw new AioDecodeException("bodyLength [" + bodyLength + "] is not right, remote:" + channelContext.getClientNode());
		}

		int neededLength = HelloPacket.HEADER_LENGHT + bodyLength;
		int test = readableLength - neededLength;
		if (test < 0) // 不够消息体长度(剩下的buffe组不了消息体)
		{
			return null;
		} else
		{
			HelloPacket imPacket = new HelloPacket();
			if (bodyLength > 0)
			{
				byte[] dst = new byte[bodyLength];
				buffer.get(dst);
				imPacket.setBody(dst);
			}
			return imPacket;
		}
	}


}
