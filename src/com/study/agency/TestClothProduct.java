package com.study.agency;

/*
 * ��̬����ģʽ
 */
//�ӿ�
interface ClothFactory{
	void productCloth();
}

//��������(Ŀ�����)
class NickClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		System.out.println("Nick��������Nick");
	}
	
}

//������(�������)
class ProxyFactory implements ClothFactory{

	//���ձ���Ŀ�����
	ClothFactory clothFactory;
	
	//����������Ķ���ʱ,ʵ�ʴ���һ����������Ķ���
	public ProxyFactory(ClothFactory cFactory){
		this.clothFactory = cFactory;
	}
	
	@Override
	public void productCloth() {
		System.out.println("�����࿪ʼִ��,�մ����");
		clothFactory.productCloth();
	}
	
}

public class TestClothProduct {

	public static void main(String[] args) {
		NickClothFactory nick = new NickClothFactory();
		ProxyFactory pro = new ProxyFactory(nick);
		pro.productCloth();
	}
}
