package day15;

public interface Command {
	void exec();   // 미완성의 코드를 완성시켜야 객체생성가능
	default public void check() {
		System.out.println("check ~~~~ ");
	}
}

class DeleteCommand implements Command{
	@Override
	public void exec() {
		System.out.println("DeleteCommand 수행");
	}
}

class UpdateCommand implements Command{
	@Override
	public void exec() {
		System.out.println("UpdateCommand 수행");
	}
}