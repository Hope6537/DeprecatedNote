package org.hope6537.datastructs.Hash;

public class HashFunction {

	/**
	 * @Descirbe һ�ֺõ�Hash���ɷ�ʽ
	 * @Author Hope6537(����)
	 * @Params @param key
	 * @Params @param tableSize
	 * @Params @return
	 * @SignDate 2014-4-3����07:28:14
	 * @Version 0.9
	 * @param key
	 * @param tableSize
	 * @return
	 */
	public static int hash(String key,int tableSize){
		int hashVal = 0;
		for(int i = 0 ; i<key.length();i++){
			hashVal = 37*hashVal + key.charAt(i);
		}
		hashVal %= tableSize;
		if(hashVal<0){
			hashVal += tableSize;
		}
		return hashVal;
	}
	
}
