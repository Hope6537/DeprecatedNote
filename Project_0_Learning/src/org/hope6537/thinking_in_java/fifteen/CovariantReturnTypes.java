package org.hope6537.thinking_in_java.fifteen;

class Base{}
class Derived extends Base{}

interface OrdinaryGetter{
	//����ӿ�
	Base get();
}

interface DerivedGetter extends OrdinaryGetter{
	//����ӿ�
	//�ڼ̳и���ӿڷ�����ͬʱ,������Get������ͬʱ��������Ҳ�����˸��ǣ�����������
	//��ΪBase��Derived�ĸ��ࣿ
	Derived get();
}

/**
 * @Describe Э�䷵������
 * @Author Hope6537(����)
 * @Signdate 2014-7-20����12:26:34
 * @version 0.9
 * @company Changchun University&SHXT
 */
public class CovariantReturnTypes {
	void test(DerivedGetter d){
		Derived d2 = d.get();
		
	}
}
