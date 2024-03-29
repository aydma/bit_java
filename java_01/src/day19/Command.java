package day19;

@FunctionalInterface  // 람다표기법이 가능한 인터페이스이다.
public interface Command {
	void exec();
	default public void print() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
}

class DeleteCommand implements Command{
	@Override
	public void exec() {
		System.out.println("DeleteCommand 수행 ");
	}
}
class UpdateCommand implements Command{
	@Override
	public void exec() {
		System.out.println("UpdateCommand 수행 ");
	}
}
class InsertCommand implements Command{
	@Override
	public void exec() {
		System.out.println("InsertCommand 수행 ");
	}
}
class SelectCommand implements Command{
	@Override
	public void exec() {
		System.out.println("SelectCommand 수행 ");
	}
}







