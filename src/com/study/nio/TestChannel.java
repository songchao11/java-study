package com.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/*
 * 1.ͨ��(Channel):����Դ�ڵ���Ŀ��ڵ������.��Java NIO�и��𻺳��������ݵĴ���.
 * Channel�����洢����,�����Ҫ��ϻ��������д���
 * 2.ͨ������Ҫʵ����
 *  java.nio.channels.Channel�ӿ�:
 *  	|--FileChannel
 *  	|--SocketChannel
 *  	|--ServerSocketChannel
 *  	|--DatagramChannel
 * 3.��ȡͨ��
 * ��Java���֧��ͨ�������ṩ��getChannel()����
 * 	����IO:
 * 		FileInputStream  FileOutputStream
 * 		RandomAccessFile
 * 	����IO:
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 * ����jdk1.7����Ը���ͨ���ṩ�˾�̬����open()
 * ����jdk1.7�е�Files�������newByteChannel()
 * 
 * 4.ͨ��֮������ݴ���
 * transferFrom()
 * transferTo()
 * 
 * 5.��ɢ(Scatter)��ۼ�(Gather)
 * ��ɢ��ȡ(Scattering Reads):��ͨ���е����ݷ�ɢ�������������
 * �ۼ�д��(Gathering Writes):������������ڵ����ݾۼ���ͨ����
 */
public class TestChannel {

	/*
	 * ����ͨ������ļ��ĸ���(��ֱ�ӻ�����)
	 */
	@Test
	public void test1(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		//�ٻ�ȡͨ��
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			fis = new FileInputStream("hello.txt");
			fos = new FileOutputStream("channel.txt");
			inChannel = fis.getChannel();
			outChannel = fos.getChannel();
			//�ڷ���ָ����С�Ļ�����
			ByteBuffer bbf = ByteBuffer.allocate(1024);
			//�۽�ͨ���е����ݴ��뻺������
			while(inChannel.read(bbf) != -1){
				bbf.flip();//����������ģʽ
				//�ܽ��������е�����д��ͨ��
				outChannel.write(bbf);
				bbf.clear();//��ջ�����
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(outChannel != null){
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(inChannel != null){
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * ʹ��ֱ�ӻ���������ļ��ĸ���(�ڴ�ӳ���ļ�)
	 */
	@Test
	public void test2() throws IOException{
		FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("channel1.txt"), StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);
		
		//�ڴ�ӳ���ļ�
		MappedByteBuffer inMappedBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outMappedBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		
		//ֱ�ӶԻ������������ݵĶ�д����
		byte[] b = new byte[inMappedBuf.limit()];
		inMappedBuf.get(b);
		outMappedBuf.put(b);
		
		inChannel.close();
		outChannel.close();
	}
	
	/*
	 * ͨ��֮������ݴ���(ֱ�ӻ�����)
	 */
	@Test
	public void test3() throws IOException{
		FileChannel inChannel = FileChannel.open(Paths.get("hello.txt"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("haha.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
		
		inChannel.transferTo(0, inChannel.size(), outChannel);
		inChannel.close();
		outChannel.close();
	}
	
	/*
	 * ��ɢ��ȡ��ۼ�д��
	 */
	@Test
	public void test4() throws Exception{
		RandomAccessFile raf1 = new RandomAccessFile("ok.txt", "rw");
		//1.��ȡͨ��
		FileChannel channel1 = raf1.getChannel();
		//2.����ָ����С�Ļ�����
		ByteBuffer bbf1 = ByteBuffer.allocate(100);
		ByteBuffer bbf2 = ByteBuffer.allocate(1024);
		//3.��ɢ��ȡ
		ByteBuffer[] bbfs = {bbf1, bbf2};
		channel1.read(bbfs);
		for(ByteBuffer bf : bbfs){
			bf.flip();
		}
		System.out.println(new String(bbfs[0].array(), 0, bbfs[0].limit()));
		System.out.println("-----------------");
		System.out.println(new String(bbfs[1].array(), 0, bbfs[1].limit()));
		
		//4.�ۼ�д��
		RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		channel2.write(bbfs);
		channel1.close();
		channel2.close();
	}
	
	@Test
	public void test5(){
		Map<String, Charset> map = Charset.availableCharsets();
		Set<Entry<String, Charset>> set = map.entrySet();
		for(Entry<String, Charset> entry : set){
			System.out.println(entry.getKey()+"=="+entry.getValue());
		}
	}
	
	@Test
	public void test6() throws IOException{
		Charset cs1 = Charset.forName("GBK");
		//��ȡ������
		CharsetEncoder ce = cs1.newEncoder();
		//��ȡ������
		CharsetDecoder cd = cs1.newDecoder();
		
		CharBuffer cBuf = CharBuffer.allocate(1024);
		cBuf.put("��ȡ������");
		cBuf.flip();
		//����
		ByteBuffer bBuf = ce.encode(cBuf);
		for(int i = 0;i < 12;i++){
			System.out.println(bBuf.get());
		}
//		bBuf.flip();
//		CharBuffer cBuf2 = cd.decode(bBuf);
//		System.out.println(cBuf2.toString());
		
	}
	
}
