public class encryt {
	final static int key = 5;
	public StringBuffer encrypt(String password){
		StringBuffer encryted = new StringBuffer("");
		char [] chars = password.toCharArray();
		for ( char c: chars) {
			c+=key;
			encryted.append(c);
		}
		return  encryted;
	}
    public StringBuffer deencrypt(String password){
		StringBuffer dencryted = new StringBuffer("");
		char [] chars = password.toCharArray();
		for ( char c: chars) {
			c-=key;
			dencryted.append(c);
		}
		return  dencryted;
	}
}