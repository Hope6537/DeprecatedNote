package org.hope6537.thinking_in_java.fifteen;

interface GenericGetter<T extends GenericGetter<T>> {
	T get();
}

interface Getter extends GenericGetter<Getter> {

}

public class GenericsAndReturnTypes {
	void test(Getter g){
		Getter rGetter = g.get();
		//�Բ���������ɶ��˼��
		GenericGetter gg = g.get();
	}
}
