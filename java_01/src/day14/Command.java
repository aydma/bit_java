package day14;

public interface Command {
	public void exec();
	default public void check() {
		System.out.println("Command check() 함수");
		// interface 안에는 추상메소드 아닌 메소드 사용하려면 default메소드를 사용하면된다.
		// 마치 static처럼 내부적으로 관리가 된다.
		// 필요한 부분에만 오버라이딩해서 사용한다.
	}
}
class DeleteCommand implements Command{
	@Override
	public void exec() {
		System.out.println("Delete(삭제) 수행");
	}
	public void check() {
		System.out.println("DeleteCommand check() 함수");
	}
}
class InsertCommand implements Command{
	@Override
	public void exec() {
		System.out.println("Insert(등록) 수행");
	}
}
class UpdateCommand implements Command{
	@Override
	public void exec() {
		System.out.println("Update(수정) 수행");
	}
}
class ListeCommand implements Command{
	@Override
	public void exec() {
		System.out.println("Liste(목록) 수행");
	}
}










