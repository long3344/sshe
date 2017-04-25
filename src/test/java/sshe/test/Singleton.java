package sshe.test;

public class Singleton {
	private static Singleton instance=null;
	
	private Singleton() {}
	
	public Singleton getSingleton() {
		if (instance==null) {
			synchronized(Singleton.class) {
				if (null==instance) {
					instance=new Singleton();
				}
			}
		}
		
		return instance;
	}
}
