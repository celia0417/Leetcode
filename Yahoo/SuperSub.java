package Yahoo;

public class SuperSub {
	public static void main(final String[] args) {
		Super obj = new Sub();
		obj.bar();
	}

	public static class Super {
		public void foo() {
			System.out.println("this is super.");
		}

		public void bar() {
			foo();
		}

	}

	public static class Sub extends Super {
		public void foo() {
			System.out.println("this is sub.");
		}
	}
}
